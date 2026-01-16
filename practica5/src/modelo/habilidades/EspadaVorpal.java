package modelo.habilidades;

import modelo.Dado;
import modelo.Personaje;
import modelo.estadosAlterados.Sangrado;

public class EspadaVorpal extends Habilidades{
    public EspadaVorpal() {
        super("Espada Vorpal",80, "distancia");
    }

    @Override
    public int usarHabilidad(Personaje personaje, Personaje enemigo) {
        Dado dado = new Dado();
        int danio = dado.tirar(getPotencia()) + personaje.getEstadisticas().getFuerza();
        if (Math.random() < 0.50){
            enemigo.agregarEstado(new Sangrado());
            System.out.println("El enemigo ahora sufre sangrado!!!");
        }
        System.out.println("Le has causado a tu enemigo: "+ danio+" puntos de salud");
        return danio;
    }
}
