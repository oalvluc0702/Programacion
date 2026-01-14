package modelo.habilidades;

import modelo.Dado;
import modelo.Personaje;
import modelo.estadosAlterados.Quemado;

public class RayoDivino extends Habilidades{
    public RayoDivino() {
        super("Rayo Divino",80, "distancia");
    }

    @Override
    public int usarHabilidad(Personaje personaje) {
        Dado dado = new Dado();
        int danio = dado.tirarVarios(1, getPotencia()) + personaje.getEstadisticas().getInteligencia();
        if (Math.random() < 0.80){
            personaje.agregarEstado(new Quemado());
            System.out.println("El enemigo se resiente de las quemaduras, ahora sufre quemado");
        }
        System.out.println("Le has causado a tu enemigo: "+ danio+" puntos de salud");
        return danio;
    }
}
