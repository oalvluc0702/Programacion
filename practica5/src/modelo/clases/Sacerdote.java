package modelo.clases;

import modelo.habilidades.CuracionMayor;
import modelo.habilidades.Golpe;
import modelo.habilidades.Habilidades;
import modelo.Personaje;

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
