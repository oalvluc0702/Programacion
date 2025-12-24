package clases;

import habilidades.CuracionMayor;
import habilidades.CuracionMenor;
import habilidades.Golpe;
import habilidades.Habilidades;
import razas.Personaje;

import java.util.ArrayList;

public class Sacerdote implements Clase {
    public Sacerdote() {
    }
    @Override
    public void agregarBonificacionClase(Personaje personaje) {
        int statTotalInteligencia = personaje.getEstadisticas().getInteligencia() + 3;
        personaje.getEstadisticas().setInteligencia(statTotalInteligencia);
        int statTotalVida = personaje.getEstadisticas().getVida() + 95;
        personaje.getEstadisticas().setVida(statTotalVida);
        personaje.getEstadisticas().setVidaActual(statTotalVida);
    }

    @Override
    public void agregarHabilidad(Personaje personaje) {
        ArrayList<Habilidades> listaHabilidades = personaje.getHabilidades();
        listaHabilidades.add(new CuracionMayor());
        listaHabilidades.add(new Golpe());
    }
}
