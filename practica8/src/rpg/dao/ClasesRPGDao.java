package rpg.dao;

import rpg.model.ClasesRPG;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClasesRPGDao {
    private HabilidadDao habilidadDao;
    public ClasesRPGDao(){
        habilidadDao = new HabilidadDao();
    }
    public List<ClasesRPG> getClases() {
        List<ClasesRPG> listaClases = new ArrayList<>();
        String sql = "SELECT * FROM CLASES_RPG";

        try (Connection conn = Conexion.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");

                ClasesRPG clase = new ClasesRPG(id, nombre);
                // RELLENAMOS LAS HABILIDADES USANDO EL OTRO DAO
                clase.setListaHabilidades(habilidadDao.getHabilidadesPorClase(id));

                listaClases.add(clase);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaClases;
    }
}
