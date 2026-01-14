package modelo.estadosAlterados;

import modelo.Dado;
import modelo.Personaje;

public class Sangrado extends Estados{
    public Sangrado() {
        super("Sangrado",3 );
    }

    @Override
    public void aplicarEfecto(Personaje personaje) {
        Dado dado = new Dado();
        int danio = dado.tirar((int) (personaje.getEstadisticas().getVida()*0.1));
        personaje.recibirDanio(danio);
        System.out.println("Has recibido: "+danio+" puntos de daño por sangrado");
    }

}
