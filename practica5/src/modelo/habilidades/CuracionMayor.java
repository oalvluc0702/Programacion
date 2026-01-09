package modelo.habilidades;

import modelo.Dado;
import modelo.Personaje;

public class CuracionMayor extends Habilidades{
    public CuracionMayor() {
        super("Curación Mayor",20, "curación");
    }

    @Override
    public int usarHabilidad(Personaje personaje) {
        Dado dado = new Dado();
        return dado.tirar(getPotencia()) + personaje.getEstadisticas().getInteligencia();
    }
}
