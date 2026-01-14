package modelo.clases;
import modelo.habilidades.CuracionMenor;
import modelo.habilidades.GolpeFuerte;
import modelo.habilidades.Habilidades;
import modelo.Personaje;
import modelo.habilidades.RayoDivino;

import java.util.ArrayList;

public class Paladin implements Clase{
    public Paladin() {
    }
    @Override
    public void agregarBonificacionClase(Personaje personaje) {
        int statTotalInteligencia = personaje.getEstadisticas().getInteligencia() + 1;
        int statTotalFuerza = personaje.getEstadisticas().getFuerza() + 2;
        personaje.getEstadisticas().setInteligencia(statTotalInteligencia);
        personaje.getEstadisticas().setFuerza(statTotalFuerza);
        int statTotalVida = personaje.getEstadisticas().getVida() + 115;
        personaje.getEstadisticas().setVida(statTotalVida);
        personaje.getEstadisticas().setVidaActual(statTotalVida);
    }

    @Override
    public void agregarHabilidad(Personaje personaje) {
        ArrayList<Habilidades> listaHabilidades = personaje.getHabilidades();
        listaHabilidades.add(new CuracionMenor());
        listaHabilidades.add(new GolpeFuerte());
        listaHabilidades.add(new RayoDivino());
    }
}
