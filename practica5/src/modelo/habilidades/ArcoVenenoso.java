package modelo.habilidades;

import modelo.Dado;
import modelo.Personaje;
import modelo.estadosAlterados.Envenenamiento;
import modelo.estadosAlterados.Quemado;

public class ArcoVenenoso extends Habilidades{
    public ArcoVenenoso() {
        super("Arco Venenoso",50, "distancia");
    }

    @Override
    public int usarHabilidad(Personaje personaje) {
        Dado dado = new Dado();
        int danio = dado.tirarVarios(2, getPotencia()) + personaje.getEstadisticas().getDestreza();
        if (Math.random() < 0.70){
            personaje.agregarEstado(new Envenenamiento());
            System.out.println("El enemigo se ha envenenado!!!");
        }
        System.out.println("Le has causado a tu enemigo: "+ danio+" puntos de salud");
        return danio;
    }
}
