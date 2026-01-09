package modelo.habilidades;

import modelo.Dado;
import modelo.Personaje;

public class CuracionMenor extends Habilidades{
    public CuracionMenor() {
        super("Curación Menor",3, "curación");
    }

    @Override
    public int usarHabilidad(Personaje personaje) {
        Dado dado = new Dado();
        return dado.tirar(getPotencia()) + personaje.getEstadisticas().getInteligencia();
    }
}
