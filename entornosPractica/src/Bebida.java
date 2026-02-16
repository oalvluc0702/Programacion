import java.util.ArrayList;

public class Bebida extends Producto{
    private String tamanio;

    public Bebida(String nombre, ArrayList<Producto> comboFiesta, double precio, int descuento, String tamanio) {
        super(nombre, comboFiesta, precio, descuento);
        this.tamanio = tamanio;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }
}
