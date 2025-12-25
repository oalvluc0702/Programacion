package habilidades;

import modelo.Dado;
import razas.Personaje;

public class Golpe extends Habilidades{
    public Golpe() {
        super("Golpe",10, "golpe");
    }

    @Override
    public void usarHabilidad(Personaje personaje, Personaje objetivo) {
            Dado dado = new Dado();
            int danio = dado.tirar(getPotencia()) + personaje.getEstadisticas().getFuerza();
            int vidaActual = objetivo.getEstadisticas().getVidaActual() - danio;
            objetivo.getEstadisticas().setVidaActual(vidaActual < 0 ? 0 : vidaActual);
            personaje.getEstadisticas().setMelee(personaje.getEstadisticas().getMelee() - 1);
    }
}
