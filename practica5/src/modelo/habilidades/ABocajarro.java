package modelo.habilidades;

import modelo.Dado;
import modelo.Personaje;

public class ABocajarro extends Habilidades{
    public ABocajarro() {
        super("A Bocajarro",40, "distancia");
    }

    @Override
    public int usarHabilidad(Personaje personaje, Personaje enemigo) {
        Dado dado = new Dado();
        int danio = dado.tirarVarios(3, getPotencia()) + personaje.getEstadisticas().getFuerza();
        System.out.println("Le has causado a tu enemigo: "+ danio+" puntos de salud");
        return danio;
    }
}
