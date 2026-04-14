package rpg.logic;


import rpg.dao.HabilidadDao;
import rpg.dao.PersonajesDao;
import rpg.model.Habilidades;
import rpg.model.Personajes;
import rpg.ui.Vista;
import rpg.utils.LoggerCustom;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class MotorCombate {
    private Personajes luchador1;
    private Personajes luchador2;
    private Vista vista;
    private PersonajesDao personajesDao;
    private HabilidadDao habilidadDao;

    public MotorCombate(Personajes luchador1, Personajes luchador2, Vista vista, PersonajesDao personajesDao, HabilidadDao habilidadDao) {
        this.luchador1 = luchador1;
        this.luchador2 = luchador2;
        this.vista = vista;
        this.personajesDao = personajesDao;
        this.habilidadDao = habilidadDao;
        iniciarCombate();
    }
    public void iniciarCombate() {
        LoggerCustom.log("[ "+ LocalDateTime.now() + " ]" + "INFO: "+ "el combate entre "+luchador1.getNombre()+" y "+ luchador2.getNombre()+" se está dando lugar");
        // Inicializar usos de habilidades en memoria
        Map<Habilidades, Integer> usosL1 = inicializarUsos(luchador1);
        Map<Habilidades, Integer> usosL2 = inicializarUsos(luchador2);

        Personajes atacante = luchador1;
        Personajes defensor = luchador2;
        Map<Habilidades, Integer> usosAtacante = usosL1;

        while (luchador1.getVida_actual() > 0 && luchador2.getVida_actual() > 0) {
            vista.mensajeTurno(atacante.getNombre());

            // Mostrar opciones y elegir acción
            // depende de lo que devuelva se usa la habilidad o un ataque basico
            int idHabilidadElegida = vista.elegirHabilidadCombate(atacante,usosAtacante);
            Habilidades habilidadElegida = habilidadDao.buscarPorId(idHabilidadElegida);

            int danoProducido = 0;

            if (habilidadElegida != null && usosAtacante.get(habilidadElegida) > 0) {
                // USO DE HABILIDAD
                danoProducido = habilidadElegida.getDanioBase() - (defensor.getDefensaTotal() / 2);
                usosAtacante.put(habilidadElegida, usosAtacante.get(habilidadElegida) - 1);
                vista.mensajeAtaqueHabilidad(habilidadElegida.getNombre(), danoProducido);
            } else {
                // ATAQUE BÁSICO
                danoProducido = atacante.getFuerzaTotal() - (defensor.getDefensaTotal() / 2);
                vista.mensajeAtaqueBasico(danoProducido);
            }

            // Aplicar daño teniendo cuidado que no sea negativo para que no cure al rival
            if (danoProducido < 0) danoProducido = 1;
            defensor.setVida_actual(defensor.getVida_actual() - danoProducido);

            vista.mostrarVida(luchador1, luchador2);

            // Turnos: Intercambiar atacante y defensor
            if (defensor.getVida_actual() > 0) {
                Personajes temp = atacante;
                atacante = defensor;
                defensor = temp;
                usosAtacante = (atacante == luchador1) ? usosL1 : usosL2;
            }
        }

        finalizarCombate();
    }
    private Map<Habilidades, Integer> inicializarUsos(Personajes p) {
        Map<Habilidades, Integer> usosCombate = new HashMap<>();
        for (Map.Entry<Habilidades, Boolean> entry : p.getHabilidadesEquipadas().entrySet()) {
            // solo añadimos las que estén equipadas
            if (entry.getValue()) {
                Habilidades hab = entry.getKey();
                usosCombate.put(hab, hab.getUsosMaximos());
            }
        }
        return usosCombate;
    }
    private void finalizarCombate() {
        Personajes ganador = (luchador1.getVida_actual() > 0) ? luchador1 : luchador2;
        Personajes perdedor = (ganador == luchador1) ? luchador2 : luchador1;

        int oroRobado = (int) (perdedor.getOro() * 0.20);

        ganador.setOro(ganador.getOro() + oroRobado);
        perdedor.setOro(perdedor.getOro() - oroRobado);

        vista.mensajeFinCombate(ganador, oroRobado);

        // guardar cambios en la base de datos
        personajesDao.updateOro(ganador.getId(),ganador.getOro());
        personajesDao.updateOro(perdedor.getId(),perdedor.getOro());
        LoggerCustom.log("[ "+ LocalDateTime.now() + " ]" + "INFO: "+ "ha ganado: "+ ganador.getNombre()+" y ha robado "+oroRobado+" G");

        // restablecemos la vida de los personajes
        luchador1.restablecerVida();
        luchador2.restablecerVida();
    }
}
