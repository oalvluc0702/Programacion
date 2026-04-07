package rpg.dao;

import rpg.model.Ciudades;
import rpg.model.Items;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

}
