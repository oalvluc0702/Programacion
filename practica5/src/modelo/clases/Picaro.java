package modelo.clases;

import modelo.habilidades.ArcoVenenoso;
import modelo.habilidades.Corte;
import modelo.habilidades.CuracionMenor;
import modelo.habilidades.Habilidades;
import modelo.Personaje;

import java.util.ArrayList;

public class Picaro implements Clase {
    public Picaro() {
    }

    @Override
    public void agregarBonificacionClase(Personaje personaje) {
        int statTotalDestreza = personaje.getEstadisticas().getDestreza() + 3;
        personaje.getEstadisticas().setDestreza(statTotalDestreza);
        int statTotalVida = personaje.getEstadisticas().getVida() + 105;
        personaje.getEstadisticas().setVida(statTotalVida);
        personaje.getEstadisticas().setVidaActual(statTotalVida);
    }

    @Override
    public void agregarHabilidad(Personaje personaje) {
        ArrayList<Habilidades> listaHabilidades = personaje.getHabilidades();
        listaHabilidades.add(new CuracionMenor());
        listaHabilidades.add(new Corte());
        listaHabilidades.add(new ArcoVenenoso());
    }
}
