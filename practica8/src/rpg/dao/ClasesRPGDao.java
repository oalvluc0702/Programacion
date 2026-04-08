package rpg.dao;
import rpg.model.ClasesRPG;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClasesRPGDao {
    private List<ClasesRPG> listaClases;
    private HabilidadDao habilidadDao;

    public ClasesRPGDao(HabilidadDao hDao) {
        this.listaClases = new ArrayList<>();
        this.habilidadDao = hDao;
        cargarClases();
    }

    public void cargarClases() {
        this.listaClases.clear();
        String sql = "SELECT * FROM CLASES_RPG";
        try (Connection conn = Conexion.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                ClasesRPG clase = new ClasesRPG(id, rs.getString("nombre"));
                // Rellenamos sus habilidades usando el otro DAO
                clase.setListaHabilidades(habilidadDao.getHabilidadesPorClase(id));
                listaClases.add(clase);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ClasesRPG buscarPorId(int id) {
        for (ClasesRPG c : listaClases) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    public List<ClasesRPG> getListaClases() { return listaClases; }
}