package modelo.razas;



public class Elfo implements Raza{
    @Override
    public void establecerEstadisticasBase(Estadisticas estadisticas) {
        estadisticas.setFuerza(4);
        estadisticas.setInteligencia(6);
        estadisticas.setDestreza(7);
        estadisticas.setVida(90);
    }
}
