package rpg.dao;

import rpg.model.Habilidades;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<Habilidades,Boolean> getHabilidadesPersonaje(List<Habilidades> listaHabilidades, int idPersonaje){
        Map<Habilidades,Boolean> habilidadesPersonaje = new HashMap<>();
        String sql = "SELECT * FROM PERSONAJES_HABILIDADES WHERE ID_PERSONAJE = ?";
        try(Connection connection = Conexion.getConexion();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,idPersonaje);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()){
                int idHabilidad = result.getInt("id_habilidad");
                Boolean equipada = result.getBoolean("equipada_combate");

                for (Habilidades habilidades : listaHabilidades){
                    if (habilidades.getId() == idHabilidad) habilidadesPersonaje.put(habilidades,equipada);
                }
            }
        } catch (SQLException e){
            System.out.println("Error en la consulta " + e.getMessage());
        }
        return habilidadesPersonaje;
    }
}
