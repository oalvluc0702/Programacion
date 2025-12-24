package clases;

import habilidades.CuracionMedia;
import habilidades.CuracionMenor;
import habilidades.GolpeFuerte;
import habilidades.Habilidades;
import razas.Personaje;

import java.util.ArrayList;

public class Guerrero implements Clase{
    public Guerrero() {
    }
    @Override
    public void agregarBonificacionClase(Personaje personaje) {
        int statTotalFuerza = personaje.getEstadisticas().getFuerza() + 3;
        personaje.getEstadisticas().setFuerza(statTotalFuerza);
        int statTotalVida = personaje.getEstadisticas().getVida() + 120;
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
