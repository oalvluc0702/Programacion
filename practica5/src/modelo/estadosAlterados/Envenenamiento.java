package modelo.estadosAlterados;

import modelo.Dado;
import modelo.Personaje;

public class Envenenamiento extends Estados{
    public Envenenamiento() {
        super("Envenenamiento",8 );
    }

    @Override
    void aplicarEfecto(Personaje personaje) {
        Dado dado = new Dado();
        personaje.recibirDanio(dado.tirar((10)));
    }

}
