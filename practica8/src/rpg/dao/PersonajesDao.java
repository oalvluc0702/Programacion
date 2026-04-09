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
    public void insertPersonaje(String nombre, int idRaza, int idClase, RazasDao rDao, ClasesRPGDao clasDao, CiudadesDao cDao) {
        // Definimos la SQL. Omitimos ID (es SERIAL) y usamos valores por defecto para nivel, oro y ciudad inicial (id 1)
        String sql = "INSERT INTO Personajes (nombre, id_raza, id_clase, id_ciudad_actual, nivel, oro, vida_actual) VALUES (?, ?, ?, 1, 1, 100, ?)";

        // Obtenemos los objetos necesarios para calcular la vida inicial y para el objeto Java
        Razas raza = rDao.buscarPorId(idRaza);
        ClasesRPG clase = clasDao.buscarPorId(idClase);
        // Le ponemos la primera ciudad por que su nivel nos permite insertarlo por defecto
        Ciudades ciudadInicio = cDao.buscarPorId(1);

        if (raza == null || clase == null) {
            System.out.println("Error: Raza o Clase no válidas.");
            return;
        }

        int vidaInicial = 100 + raza.getBonificadorVida();

        // Usamos RETURN_GENERATED_KEYS para obtener el ID que asigne PostgreSQL automáticamente
        try (Connection conexion = Conexion.getConexion();
             PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, nombre);
            ps.setInt(2, idRaza);
            ps.setInt(3, idClase);
            ps.setInt(4, vidaInicial);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                // Esto sirve para volver a obtener el id que ha generado en la base de datos el serial
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        int idGenerado = rs.getInt(1);

                        // Creamos el objeto Java para mantener la lista actualizada sin recargar todo de la DB
                        Personajes nuevo = new Personajes(idGenerado, nombre, raza, clase, ciudadInicio);
                        this.listaPersonajes.add(nuevo);

                        System.out.println("✅ Personaje '" + nombre + "' creado con éxito (ID: " + idGenerado + ")");
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("No se ha podido crear un personaje");
        }
    }
    public void updateCiudad(int idCiudad, int idPersonaje ){
        String sql = "UPDATE PERSONAJES SET ID_CIUDAD_ACTUAL = ? WHERE ID = ?";
        try(Connection connection = Conexion.getConexion();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,idCiudad);
            preparedStatement.setInt(2,idPersonaje);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}