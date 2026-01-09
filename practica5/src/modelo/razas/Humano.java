package modelo.razas;

import modelo.Estadisticas;

public class Humano implements Raza{
    @Override
    public void establecerEstadisticasBase(Estadisticas estadisticas) {
        estadisticas.setFuerza(5);
        estadisticas.setInteligencia(5);
        estadisticas.setDestreza(5);
        estadisticas.setVida(100);
    }
}
