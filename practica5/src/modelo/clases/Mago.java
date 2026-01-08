package modelo.clases;

import modelo.habilidades.*;
import modelo.Personaje;

import java.util.ArrayList;

public class Mago implements Clase {
    public Mago() {
    }

    @Override
    public void agregarBonificacionClase(Personaje personaje) {
        int statTotalInteligencia = personaje.getEstadisticas().getInteligencia() + 3;
        personaje.getEstadisticas().setInteligencia(statTotalInteligencia);
        int statTotalVida = personaje.getEstadisticas().getVida() + 90;
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
