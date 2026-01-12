package modelo.estadosAlterados;

import modelo.Dado;
import modelo.Personaje;

public class Envenenamiento extends Estados{
    public Envenenamiento() {
        super("Envenenamiento",8 );
    }

    @Override
    public void aplicarEfecto(Personaje personaje) {
        Dado dado = new Dado();
        int danio = dado.tirar(10);
        personaje.recibirDanio(danio);
        System.out.println("Ha recibido "+danio+" puntos de daño por envenenamiento");
    }

}
