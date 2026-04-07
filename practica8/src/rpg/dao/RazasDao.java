package rpg.dao;


import rpg.model.Razas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RazasDao {
    public RazasDao() {
    }

    public List<Razas> getRazas() {
        List<Razas> listaRazas = new ArrayList<>();
        String sql = "SELECT * FROM RAZAS";

        try (Connection connection = Conexion.getConexion();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(sql)) {

            while (result.next()) {
                int id = result.getInt("id");
                String nombre = result.getString("nombre");
                int bonificadorVida = result.getInt("bonificador_vida");
                int bonificadorFuerza = result.getInt("bonificador_fuerza");

                // Añadimos la raza a la lista usando su constructor
                listaRazas.add(new Razas(id, nombre, bonificadorVida, bonificadorFuerza));
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener las razas: " + e.getMessage());
        }

        return listaRazas;
    }

}
