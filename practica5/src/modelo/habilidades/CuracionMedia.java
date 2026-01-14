package modelo.habilidades;

import modelo.Dado;
import modelo.Personaje;

public class CuracionMedia extends Habilidades{
    public CuracionMedia() {
        super("Curación Media",20, "curación");
    }

    @Override
    public int usarHabilidad(Personaje personaje) {
        Dado dado = new Dado();
        int cura = dado.tirar(getPotencia()) + personaje.getEstadisticas().getInteligencia();
        System.out.println("Te has curado: "+cura+" puntos de salud");
        return cura;
    }
}
