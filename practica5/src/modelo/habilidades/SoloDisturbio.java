package modelo.habilidades;

import modelo.Dado;
import modelo.Personaje;

public class SoloDisturbio extends Habilidades{
    public SoloDisturbio() {
        super("Solo de disturbio",10, "distancia");
    }

    @Override
    public int usarHabilidad(Personaje personaje) {
        Dado dado = new Dado();
        int danio = dado.tirarVarios(8, getPotencia()) + personaje.getEstadisticas().getInteligencia();
        System.out.println("Le has causado a tu enemigo: "+ danio+" puntos de salud");
        return danio;
    }
}
