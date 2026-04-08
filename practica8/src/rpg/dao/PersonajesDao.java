package rpg.dao;


import rpg.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonajesDao {
    private ItemsDao itemsDao;
    public PersonajesDao(){
        itemsDao = new ItemsDao();
    }

    public List<Personajes> getPersonajes(List<Items> listaItems, List<Ciudades> listaCiudades, List<Habilidades> listaHabilidades, List<ClasesRPG> listaClases, List<Razas> listaRazas){
        String sql = "SELECT * FROM PERSONAJES";
        List<Personajes> listaPersonajes = new ArrayList<>();
        try(Connection conexion = Conexion.getConexion()){
            Statement statement = conexion.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                int id = result.getInt("id");
                String nombre = result.getString("nombre");
                int nivel = result.getInt("nivel");
                int oro = result.getInt("oro");
                int vidaActual = result.getInt("vida_actual");

                int idRaza = result.getInt("id_raza");
                int idClase = result.getInt("id_clase");
                int idCiudad = result.getInt("id_ciudad_actual");

                Razas razas = null;
                ClasesRPG clasesRPG = null;
                Ciudades ciudad = null;

                for (Razas raza : listaRazas){
                    if (raza.getId() == idRaza) razas = raza;
                }
                for (ClasesRPG clase : listaClases){
                    if (clase.getId() == idClase) clasesRPG = clase;
                }
                for (Ciudades ciudades : listaCiudades){
                    if ( ciudades.getId() == idCiudad) ciudad = ciudades;
                }

                Personajes personaje = new Personajes(id,nombre,nivel,oro,vidaActual,razas,clasesRPG,ciudad);
                personaje.setInventario(itemsDao.getInventario(id,listaItems));
                listaPersonajes.add(personaje);
            }

        } catch (SQLException e){
            System.out.println("Error en la consulta");
        }
        return listaPersonajes;
    }
}
