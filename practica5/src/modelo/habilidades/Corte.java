package modelo.habilidades;

import modelo.Dado;
import modelo.Personaje;
import modelo.estadosAlterados.Sangrado;

public class Corte extends Habilidades{
    public Corte() {
        super("Corte",15, "melee");
    }

    @Override
    public int usarHabilidad(Personaje personaje, Personaje enemigo) {
        Dado dado = new Dado();
        if (Math.random() < 0.30){
            enemigo.agregarEstado(new Sangrado());
            System.out.println("El enemigo ahora sufre sangrado!!!");
        }
        int danio = dado.tirar(getPotencia()) + personaje.getEstadisticas().getDestreza();
        System.out.println("Le has causado a tu enemigo: "+ danio+" puntos de salud");
        return danio;
    }
}
