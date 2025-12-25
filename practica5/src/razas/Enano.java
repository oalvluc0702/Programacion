package razas;

public class Enano implements Raza{
    @Override
    public void establecerEstadisticasBase(Estadisticas estadisticas) {
        estadisticas.setFuerza(7);
        estadisticas.setInteligencia(4);
        estadisticas.setDestreza(4);
        estadisticas.setVida(110);
    }
}
