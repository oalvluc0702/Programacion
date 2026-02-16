import java.util.ArrayList;

public class Bebida extends Producto{
    private String tamanio;

    public Bebida(String nombre, double precio, int descuento, String tamanio) {
        super(nombre, precio, descuento);
        this.tamanio = tamanio;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }
}
