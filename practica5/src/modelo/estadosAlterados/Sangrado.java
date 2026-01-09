package modelo.estadosAlterados;

import modelo.Dado;
import modelo.Personaje;

public class Sangrado extends Estados{
    public Sangrado() {
        super("Sangrado",3 );
    }

    @Override
    void aplicarEfecto(Personaje personaje) {
        Dado dado = new Dado();
        personaje.recibirDanio(dado.tirar((int) (personaje.getEstadisticas().getVida()*0.1)));
    }

}
