package rpg.dao;
import rpg.model.Razas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RazasDao {
    private List<Razas> listaRazas;

    public RazasDao() {
        this.listaRazas = new ArrayList<>();
        cargarRazas();
    }

    public void cargarRazas() {
        this.listaRazas.clear();
        String sql = "SELECT * FROM RAZAS";
        try (Connection connection = Conexion.getConexion();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(sql)) {
            while (result.next()) {
                listaRazas.add(new Razas(
                    result.getInt("id"),
                    result.getString("nombre"),
                    result.getInt("bonificador_vida"),
                    result.getInt("bonificador_fuerza")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar razas");
        }
    }

    public Razas buscarPorId(int id) {
        for (Razas r : listaRazas) {
            if (r.getId() == id) return r;
        }
        return null;
    }

    public List<Razas> getListaRazas() { return listaRazas; }
}