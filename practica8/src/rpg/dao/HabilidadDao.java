package rpg.dao;
import rpg.model.Habilidades;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HabilidadDao {
    private List<Habilidades> listaHabilidades;

    public HabilidadDao() {
        this.listaHabilidades = new ArrayList<>();
        cargarHabilidades();
    }

    public void cargarHabilidades() {
        this.listaHabilidades.clear();
        String sql = "SELECT * FROM HABILIDADES";
        try (Connection conn = Conexion.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                listaHabilidades.add(new Habilidades(
                    rs.getInt("id"), rs.getString("nombre"),
                    rs.getInt("dano_base"), rs.getInt("usos_maximos"),
                    rs.getInt("id_clase")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar habilidades");
        }
    }

    public List<Habilidades> getHabilidadesPorClase(int idClase) {
        List<Habilidades> filtradas = new ArrayList<>();
        for (Habilidades h : listaHabilidades) {
            if (h.getId_clase() == idClase) filtradas.add(h);
        }
        return filtradas;
    }

    public Map<Habilidades, Boolean> getHabilidadesPersonaje(List<Habilidades> hGlobales, int idPers) {
        Map<Habilidades, Boolean> habilidadesPersonaje = new HashMap<>();
        String sql = "SELECT * FROM PERSONAJES_HABILIDADES WHERE ID_PERSONAJE = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPers);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idH = rs.getInt("id_habilidad");
                boolean equipada = rs.getBoolean("equipada_combate");
                Habilidades h = buscarPorId(idH);
                if (h != null) habilidadesPersonaje.put(h, equipada);
            }
        } catch (SQLException e) {
            System.out.println("Error en habilidades personaje");
        }
        return habilidadesPersonaje;
    }

    public Habilidades buscarPorId(int id) {
        for (Habilidades h : listaHabilidades) {
            if (h.getId() == id) return h;
        }
        return null;
    }

    public List<Habilidades> getListaHabilidades() { return listaHabilidades; }
}