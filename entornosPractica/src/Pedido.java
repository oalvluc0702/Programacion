import java.util.HashMap;

public class Pedido {
    private HashMap<Producto, Integer> productos_consumidos;
    private int fechaPedido;
    private double precioPedido;
    private boolean cancelado;
    public Pedido(int fechaPedido, double precioPedido) {
        this.productos_consumidos = new HashMap<>();
        this.fechaPedido = fechaPedido;
        this.precioPedido = precioPedido;
        this.cancelado = false;
        calcularPrecioPedido();
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }

    public HashMap<Producto, Integer> getProductos_consumidos() {
        return productos_consumidos;
    }

    public void setProductos_consumidos(HashMap<Producto, Integer> productos_consumidos) {
        this.productos_consumidos = productos_consumidos;
    }

    public int getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(int fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public double getPrecioPedido() {
        return precioPedido;
    }


    public void setPrecioPedido(double precioPedido) {
        this.precioPedido = precioPedido;
    }
    public void cancelarPedido(){
        this.cancelado = true;
    }
    public double calcularPrecioPedido(){
        double precioTotal = 0.0;
        for (Producto producto : this.productos_consumidos.keySet()){
            double precio = producto.getPrecio() * this.productos_consumidos.get(producto);
            precioTotal+=precio;
        }
        this.precioPedido = precioTotal;
        return precioTotal;
    }
}
