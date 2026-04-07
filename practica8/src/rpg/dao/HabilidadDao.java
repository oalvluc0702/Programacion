package rpg.dao;

import rpg.model.Habilidades;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HabilidadDao {
    public HabilidadDao(){

    }

    public List<Habilidades> getHabilidadesPorClase(int idClase) {
        List<Habilidades> lista = new ArrayList<>();
        String sql = "SELECT * FROM HABILIDADES WHERE id_clase = ?";

        try (Connection connection = Conexion.getConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, idClase);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Habilidades(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getInt("dano_base"),
                            rs.getInt("usos_maximos"),
                            rs.getInt("id_clase")
                    ));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar habilidades: " + e.getMessage());
        }
        return lista;
    }

    public List<Habilidades> getHabilidades() {
        List<Habilidades> listaHabilidades = new ArrayList<>();
        String sql = "SELECT * FROM HABILIDADES";

        try (Connection conn = Conexion.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                // Extraemos los datos de cada fila
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int danoBase = rs.getInt("dano_base");
                int usosMaximos = rs.getInt("usos_maximos");
                int idClase = rs.getInt("id_clase");

                // Creamos el objeto y lo añadimos a la lista
                listaHabilidades.add(new Habilidades(id, nombre, danoBase, usosMaximos, idClase));
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener todas las habilidades: " + e.getMessage());
        }

        return listaHabilidades;
    }
}
