package rpg.dao;
import rpg.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonajesDao {
    private List<Personajes> listaPersonajes;
    private ItemsDao itemsDao;
    private HabilidadDao habilidadDao;

    public PersonajesDao(ItemsDao itemsDao, HabilidadDao habilidadDao) {
        this.listaPersonajes = new ArrayList<>();
        this.itemsDao = itemsDao;
        this.habilidadDao = habilidadDao;
    }

    public void cargarPersonajes(CiudadesDao cDao, RazasDao rDao, ClasesRPGDao clDao) {
        this.listaPersonajes.clear();
        String sql = "SELECT * FROM PERSONAJES";
        try (Connection conexion = Conexion.getConexion();
             Statement statement = conexion.createStatement();
             ResultSet result = statement.executeQuery(sql)) {

            while (result.next()) {
                // Buscamos los objetos en las listas de los otros DAOs
                Razas raza = rDao.buscarPorId(result.getInt("id_raza"));
                ClasesRPG clase = clDao.buscarPorId(result.getInt("id_clase"));
                Ciudades ciudad = cDao.buscarPorId(result.getInt("id_ciudad_actual"));

                Personajes p = new Personajes(
                    result.getInt("id"), result.getString("nombre"),
                    result.getInt("nivel"), result.getInt("oro"),
                    result.getInt("vida_actual"), raza, clase, ciudad
                );

                // Rellenamos mapas internos (Inventario y Habilidades)
                p.setInventario(itemsDao.getInventario(p.getId(), itemsDao.getListaItems()));
                p.setHabilidadesEquipadas(habilidadDao.getHabilidadesPersonaje(habilidadDao.getListaHabilidades(), p.getId()));
                
                this.listaPersonajes.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar personajes");
        }
    }

    public List<Personajes> getListaPersonajes() { return listaPersonajes; }

    public Personajes buscarPorId(int id) {
        for (Personajes p : listaPersonajes) {
            if (p.getId() == id) return p;
        }
        return null;
    }
    public void updateOro(int idPersonaje, int cantidadOroActual){
        String sql = "UPDATE PERSONAJES SET ORO = ? WHERE ID = ?";
        try (Connection conexion = Conexion.getConexion();
             PreparedStatement preparedStatement = conexion.prepareStatement(sql)){
            preparedStatement.setInt(1,cantidadOroActual);
            preparedStatement.setInt(2,idPersonaje);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void updateInventario(int idPersonaje, int idItem, int cantidad){
        String sql = "UPDATE INVENTARIOS SET CANTIDAD = ? WHERE ID_PERSONAJE = ? AND ID_ITEM = ?";
        try (Connection conexion = Conexion.getConexion();
             PreparedStatement preparedStatement = conexion.prepareStatement(sql)){
            preparedStatement.setInt(1,cantidad);
            preparedStatement.setInt(2,idPersonaje);
            preparedStatement.setInt(3,idItem);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void insertInventario(int idPersonaje, int idItem, int cantidad){
        String sql = "INSERT INTO INVENTARIOS (ID_PERSONAJE, ID_ITEM, CANTIDAD) VALUES (?,?,?)";
        try (Connection conexion = Conexion.getConexion();
             PreparedStatement preparedStatement = conexion.prepareStatement(sql)){
            preparedStatement.setInt(1,idPersonaje);
            preparedStatement.setInt(2,idItem);
            preparedStatement.setInt(3,cantidad);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void insertPersonaje(){

    }
}