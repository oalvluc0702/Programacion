package modelo.habilidades;

import modelo.Dado;
import modelo.Personaje;

public class GolpeFuerte extends Habilidades{
    public GolpeFuerte() {
        super("Golpe Fuerte",300, "melee");
    }

    @Override
    public int usarHabilidad(Personaje personaje) {
        Dado dado = new Dado();
        int danio = dado.tirar(getPotencia()) + personaje.getEstadisticas().getFuerza();
        System.out.println("Le has causado a tu enemigo: "+ danio+" puntos de salud");
        return danio;
    }
}
