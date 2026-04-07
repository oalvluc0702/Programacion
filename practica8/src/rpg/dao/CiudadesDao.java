package rpg.dao;

import rpg.model.Ciudades;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CiudadesDao {
    public CiudadesDao() {
    }

    public List<Ciudades> getCiudades(){
        List<Ciudades> listaCiudades = new ArrayList<>();
        String sql = "SELECT * FROM CIUDADES";

        try (Connection connection = Conexion.getConexion()){
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()){
                int id = result.getInt("id");
                String nombre = result.getString("nombre");
                int nivelMinimoAcceso = result.getInt("nivel_minimo_acceso");
                listaCiudades.add(new Ciudades(id,nombre,nivelMinimoAcceso));
            }

        } catch (SQLException e){
            System.out.println("Error en la consulta");
        }
        return listaCiudades;
    }

    public boolean actualizarCiudad(int idCiudad, String nombreNuevo){
        String sql = "UPDATE CIUDADES SET NOMBRE = ? WHERE ID = ?";

        try ( Connection connection = Conexion.getConexion();
              PreparedStatement preparedStatement = connection.prepareStatement(sql)){
             preparedStatement.setString(1,nombreNuevo);
             preparedStatement.setInt(2,idCiudad);
             preparedStatement.executeUpdate();
        } catch (SQLException e ) {
            return false;
        }
        return true;
    }
}
