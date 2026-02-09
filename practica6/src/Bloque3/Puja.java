package Bloque3;

public class Puja {
    private String jugador;
    private double cantidad;

    public Puja(String jugador, double cantidad) {
        this.jugador = jugador;
        this.cantidad = cantidad;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
}
