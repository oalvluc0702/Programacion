package modelo.habilidades;

import modelo.Dado;
import modelo.Personaje;

public class GolpeFuerte extends Habilidades{
    public GolpeFuerte() {
        super("Golpe Fuerte",20, "melee");
    }

    @Override
    public int usarHabilidad(Personaje personaje) {
        Dado dado = new Dado();
        return dado.tirar(getPotencia()) + personaje.getEstadisticas().getFuerza();
    }
}
