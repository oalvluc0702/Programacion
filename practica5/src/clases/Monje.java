package clases;

import habilidades.CuracionMenor;
import habilidades.GolpeFuerte;
import habilidades.Habilidades;
import razas.Personaje;

import java.util.ArrayList;

public class Monje implements Clase {
    public Monje() {
    }

    @Override
    public void agregarBonificacionClase(Personaje personaje) {
        int statTotalDestreza = personaje.getEstadisticas().getDestreza() + 1;
        personaje.getEstadisticas().setDestreza(statTotalDestreza);
        int statTotalFuerza = personaje.getEstadisticas().getFuerza() + 2;
        personaje.getEstadisticas().setFuerza(statTotalFuerza);
        int statTotalVida = personaje.getEstadisticas().getVida() + 110;
        personaje.getEstadisticas().setVida(statTotalVida);
        personaje.getEstadisticas().setVidaActual(statTotalVida);
    }

    @Override
    public void agregarHabilidad(Personaje personaje) {
        ArrayList<Habilidades> listaHabilidades = personaje.getHabilidades();
        listaHabilidades.add(new CuracionMenor());
        listaHabilidades.add(new GolpeFuerte());
    }
}
