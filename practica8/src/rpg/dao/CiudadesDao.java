package rpg.dao;
import rpg.model.Ciudades;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CiudadesDao {
    private List<Ciudades> listaCiudades;

    public CiudadesDao() {
        this.listaCiudades = new ArrayList<>();
        cargarCiudades(); // Carga automática al instanciar
    }

    public void cargarCiudades() {
        this.listaCiudades.clear();
        String sql = "SELECT * FROM CIUDADES";
        try (Connection connection = Conexion.getConexion();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(sql)) {
            while (result.next()) {
                listaCiudades.add(new Ciudades(
                    result.getInt("id"),
                    result.getString("nombre"),
                    result.getInt("nivel_minimo_acceso")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar ciudades");
        }
    }

    public Ciudades buscarPorId(int id) {
        for (Ciudades c : listaCiudades) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    public List<Ciudades> getListaCiudades() {
        return listaCiudades;
    }
}