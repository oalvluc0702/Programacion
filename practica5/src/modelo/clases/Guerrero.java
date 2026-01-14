package modelo.clases;

import modelo.habilidades.CuracionMenor;
import modelo.habilidades.EspadaVorpal;
import modelo.habilidades.GolpeFuerte;
import modelo.habilidades.Habilidades;
import modelo.Personaje;

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
        listaHabilidades.add(new EspadaVorpal());
    }
}
