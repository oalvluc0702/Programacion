import java.util.ArrayList;

public class Producto {
    private String nombre;
    private ArrayList<Producto> comboFiesta;
    private double precio;
    private int descuento;

    public Producto(String nombre, ArrayList<Producto> comboFiesta, double precio, int descuento) {
        this.nombre = nombre;
        this.comboFiesta = new ArrayList<>();
        this.precio = precio;
        this.descuento = descuento;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Producto> getComboFiesta() {
        return comboFiesta;
    }

    public double getPrecio() {
        return precio;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setComboFiesta(ArrayList<Producto> comboFiesta) {
        this.comboFiesta = comboFiesta;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public double calcularPrecioComboFiesta(){
        double precioTotal = 0.0;
        for (Producto producto : this.comboFiesta){
            precioTotal+= producto.getPrecio();
        }
        return precioTotal;
    }
    public void establecerDescuento(){
        double descuento = (double) this.descuento / 100;
        this.setPrecio(this.precio*(1-descuento));
    }
}

