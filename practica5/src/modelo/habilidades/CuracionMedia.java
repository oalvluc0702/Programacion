package modelo.habilidades;

import modelo.Dado;
import modelo.Personaje;

public class CuracionMedia extends Habilidades{
    public CuracionMedia() {
        super("Curación Media",10, "curación");
    }

    @Override
    public int usarHabilidad(Personaje personaje) {
        Dado dado = new Dado();
        return dado.tirar(getPotencia()) + personaje.getEstadisticas().getInteligencia();
    }
}
