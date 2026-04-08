package rpg.dao;
import rpg.model.Items;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemsDao {
    private List<Items> listaItems;

    public ItemsDao() {
        this.listaItems = new ArrayList<>();
        cargarItems();
    }

    public void cargarItems() {
        this.listaItems.clear();
        String sql = "SELECT * FROM ITEMS";
        try (Connection connection = Conexion.getConexion();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(sql)) {
            while (result.next()) {
                listaItems.add(new Items(
                    result.getInt("id"),
                    result.getString("nombre"),
                    result.getString("tipo"),
                    result.getInt("precio_oro"),
                    result.getInt("bonificador_ataque"),
                    result.getInt("bonificador_defensa")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los ítems");
        }
    }

    // El método que pedía el PersonajesDao para rellenar el mapa
    public Map<Items, Integer> getInventario(int idPersonaje, List<Items> itemsGlobales) {
        Map<Items, Integer> inventario = new HashMap<>();
        String sql = "SELECT * FROM INVENTARIOS WHERE ID_PERSONAJE = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPersonaje);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idItem = rs.getInt("id_item");
                int cantidad = rs.getInt("cantidad");
                Items item = buscarPorId(idItem);
                if (item != null) inventario.put(item, cantidad);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar inventario");
        }
        return inventario;
    }

    public Items buscarPorId(int id) {
        for (Items i : listaItems) {
            if (i.getId() == id) return i;
        }
        return null;
    }

    public List<Items> getListaItems() { return listaItems; }
}