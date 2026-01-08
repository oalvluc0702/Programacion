package modelo.clases;

import modelo.habilidades.*;
import modelo.Personaje;

import java.util.ArrayList;

public class Druida implements Clase {
    public Druida() {
    }

    @Override
    public void agregarBonificacionClase(Personaje personaje) {
        int statTotalInteligencia = personaje.getEstadisticas().getInteligencia() + 2;
        int statTotalFuerza = personaje.getEstadisticas().getFuerza() + 1;
        personaje.getEstadisticas().setInteligencia(statTotalInteligencia);
        personaje.getEstadisticas().setFuerza(statTotalFuerza);
        int statTotalVida = personaje.getEstadisticas().getVida() + 100;
        personaje.getEstadisticas().setVida(statTotalVida);
        personaje.getEstadisticas().setVidaActual(statTotalVida);
    }

    @Override
    public void agregarHabilidad(Personaje personaje) {
        ArrayList<Habilidades> listaHabilidades = personaje.getHabilidades();
        listaHabilidades.add(new CuracionMedia());
        listaHabilidades.add(new GolpeFuerte());
    }
}
