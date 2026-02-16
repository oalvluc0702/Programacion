import java.util.HashMap;

public class Inventario {
    private HashMap<String, Integer> productos;
    private HashMap<String,Integer> ingredientes;

    public Inventario() {
        this.productos = new HashMap<>();
        this.ingredientes = new HashMap<>();
    }

    public HashMap<String, Integer> getProductos() {
        return productos;
    }

    public void setProductos(HashMap<String, Integer> productos) {
        this.productos = productos;
    }

    public HashMap<String, Integer> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(HashMap<String, Integer> ingredientes) {
        this.ingredientes = ingredientes;
    }
    public void agregarProducto(Producto producto){
        this.productos.put(producto.getNombre(), this.productos.getOrDefault(producto.getNombre() +1,0));
    }
    public void eliminarProducto(Producto producto){
        this.productos.remove(producto.getNombre());
    }
    public int consultarStock(Producto producto){
        return this.productos.get(producto.getNombre());
    }
    public int consultarStockIngrediente(String ingrediente){
        return this.productos.get(ingrediente);
    }
}
