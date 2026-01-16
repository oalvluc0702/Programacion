package modelo.habilidades;

import modelo.Dado;
import modelo.Personaje;

public class Golpe extends Habilidades{
    public Golpe() {
        super("Golpe",20, "melee");
    }

    @Override
    public int usarHabilidad(Personaje personaje, Personaje enemigo) {
            Dado dado = new Dado();
            int danio = dado.tirar(getPotencia()) + personaje.getEstadisticas().getFuerza();
            System.out.println("Le has causado a tu enemigo: "+ danio+" puntos de salud");
            return danio;
    }
}
