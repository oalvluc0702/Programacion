package rpg.dao;

import java.sql.*;

public class Conexion {
    private static final String URL = "jdbc:postgresql://localhost:5432/XRPG";
    private static final String USER = "xrpg_user";
    private static final String PASS = "xrpg_password";

    public static Connection getConexion() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            throw new SQLException("¡Driver no encontrado! Revisa tu archivo pom.xml o librerías.", e);
        }
    }
    public static ResultSet consulta(String sql){
        try (Connection conexion = Conexion.getConexion()){
            Statement statement = conexion.createStatement();
            return statement.executeQuery(sql);
        } catch (SQLException e){
            System.out.println("Error en la consulta " + e.getCause());
        }
        return null;
    }

}
