package modelo.estadosAlterados;

import modelo.Dado;
import modelo.Personaje;

public class Quemado extends Estados{
    public Quemado() {
        super("Quemado",5 );
    }

    @Override
    void aplicarEfecto(Personaje personaje) {
        Dado dado = new Dado();
        personaje.recibirDanio(dado.tirar((20)));
    }

}
