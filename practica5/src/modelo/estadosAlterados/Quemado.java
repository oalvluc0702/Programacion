package modelo.estadosAlterados;

import modelo.Dado;
import modelo.Personaje;

public class Quemado extends Estados{
    public Quemado() {
        super("Quemado",5 );
    }

    @Override
    public void aplicarEfecto(Personaje personaje) {
        Dado dado = new Dado();
        int danio = dado.tirar(20);
        personaje.recibirDanio(danio);
        System.out.println("Ha recibido "+danio+" puntos de daño por quemado");
    }

}
