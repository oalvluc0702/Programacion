package clases;

import habilidades.CuracionMayor;
import habilidades.CuracionMenor;
import habilidades.Golpe;
import habilidades.Habilidades;
import razas.Personaje;

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
        listaHabilidades.add(new Golpe());
    }
}
