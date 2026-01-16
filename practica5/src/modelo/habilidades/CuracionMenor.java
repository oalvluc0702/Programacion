package modelo.habilidades;

import modelo.Dado;
import modelo.Personaje;

public class CuracionMenor extends Habilidades{
    public CuracionMenor() {
        super("Curación Menor",10, "curación");
    }

    @Override
    public int usarHabilidad(Personaje personaje, Personaje enemigo) {
        Dado dado = new Dado();
        int cura = dado.tirar(getPotencia()) + personaje.getEstadisticas().getInteligencia();
        System.out.println("Te has curado: "+cura+" puntos de salud");
        return cura;
    }
}
