package modelo.habilidades;

import modelo.Dado;
import modelo.Personaje;
import modelo.estadosAlterados.Sangrado;

public class Corte extends Habilidades{
    public Corte() {
        super("Corte",5, "melee");
    }

    @Override
    public int usarHabilidad(Personaje personaje) {
        Dado dado = new Dado();
        if (Math.random() < 0.30){
            personaje.agregarEstado(new Sangrado());
        }
        return dado.tirar(getPotencia()) + personaje.getEstadisticas().getDestreza();
    }
}
