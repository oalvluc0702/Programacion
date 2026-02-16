import java.util.ArrayList;
import java.util.HashSet;

public class Comida extends Producto{
    private HashSet<String> alergenos;
    private int tiempoCocinado;

    public Comida(String nombre, ArrayList<Producto> comboFiesta, double precio, int descuento, HashSet<String> alergenos, int tiempoCocinado) {
        super(nombre, comboFiesta, precio, descuento);
        this.alergenos = alergenos;
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
