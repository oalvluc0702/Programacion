import java.util.ArrayList;
import java.util.HashSet;

public class Comida extends Producto{
    private HashSet<String> alergenos;
    private int tiempoCocinado;

    public Comida(String nombre, double precio, int descuento, int tiempoCocinado) {
        super(nombre, precio, descuento);
        this.alergenos = new HashSet<>();
        this.tiempoCocinado = tiempoCocinado;
    }

    public HashSet<String> getAlergenos() {
        return alergenos;
    }

    public int getTiempoCocinado() {
        return tiempoCocinado;
    }

    public void setAlergenos(HashSet<String> alergenos) {
        this.alergenos = alergenos;
    }

    public void setTiempoCocinado(int tiempoCocinado) {
        this.tiempoCocinado = tiempoCocinado;
    }
}
