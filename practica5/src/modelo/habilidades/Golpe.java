package modelo.habilidades;

import modelo.Dado;
import modelo.Personaje;

public class Golpe extends Habilidades{
    public Golpe() {
        super("Golpe",10, "melee");
    }

    @Override
    public int usarHabilidad(Personaje personaje) {
            Dado dado = new Dado();
            return dado.tirar(getPotencia()) + personaje.getEstadisticas().getFuerza();
    }
}
