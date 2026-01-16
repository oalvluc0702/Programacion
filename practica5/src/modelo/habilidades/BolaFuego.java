package modelo.habilidades;

import modelo.Dado;
import modelo.Personaje;
import modelo.estadosAlterados.Quemado;

public class BolaFuego extends Habilidades{
    public BolaFuego() {
        super("Bola de fuego",70, "distancia");
    }

    @Override
    public int usarHabilidad(Personaje personaje, Personaje enemigo) {
        Dado dado = new Dado();
        int danio = dado.tirarVarios(2, getPotencia()) + personaje.getEstadisticas().getInteligencia();
        if (Math.random() < 0.60){
            enemigo.agregarEstado(new Quemado());
            System.out.println("El enemigo se resiente de las quemaduras, ahora sufre quemado");
        }
        System.out.println("Le has causado a tu enemigo: "+ danio+" puntos de salud");
        return danio;
    }
}
