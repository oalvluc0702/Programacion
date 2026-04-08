package rpg.dao;

import rpg.model.Ciudades;
import rpg.model.Items;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemsDao {
    public ItemsDao() {
    }

    public List<Items> getItems() {
        List<Items> listaItems = new ArrayList<>();
        String sql = "SELECT * FROM ITEMS";

        try (Connection connection = Conexion.getConexion();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(sql)) {

            while (result.next()) {
                int id = result.getInt("id");
                String nombre = result.getString("nombre");
                String tipo = result.getString("tipo");
                int precioOro = result.getInt("precio_oro");
                int bonificadorAtaque = result.getInt("bonificador_ataque");
                int bonificadorDefensa = result.getInt("bonificador_defensa");

                // Creamos el objeto Item y lo añadimos a la lista
                listaItems.add(new Items(id, nombre, tipo, precioOro, bonificadorAtaque, bonificadorDefensa));
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener los ítems: " + e.getMessage());
        }

        return listaItems;
    }

    public Map<Items,Integer> getInventario(int idPersonaje, List<Items> listaItems){
        Map<Items,Integer> inventario = new HashMap<>();
        String sql = "SELECT * FROM INVENTARIOS WHERE ID_PERSONAJE = ?";
        try(Connection conexion = Conexion.getConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql)){

            preparedStatement.setInt(1,idPersonaje);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                int idItem = resultSet.getInt("id_item");
                Integer cantidad = resultSet.getInt("cantidad");

                for (Items item : listaItems){
                    if(item.getId() == idItem) inventario.put(item, cantidad);
                }
            }

        } catch (SQLException e){
            System.out.println("error en la consulta "+e.getMessage());
        }
        return inventario;
    }

}
