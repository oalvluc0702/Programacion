package rpg.model;

import rpg.dao.Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClasesRPG {
    private int id;
    private String nombre;
    private ArrayList<Habilidades> listaHabilidades;

    public ClasesRPG(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.listaHabilidades = new ArrayList<>();
        this.loadHabilidades();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Habilidades> getListaHabilidades() {
        return listaHabilidades;
    }

    public void setListaHabilidades(ArrayList<Habilidades> listaHabilidades) {
        this.listaHabilidades = listaHabilidades;
    }

    public void loadHabilidades(){
        ArrayList<Habilidades> listaHabilidadesClase = new ArrayList<>();
        // select habilidades por la clase

        try {
            ResultSet resHabilidad = Conexion.consulta("SELECT H.id, H.nombre, H.dano_base, H.usos_maximos , H.id_clase\n" +
                    "FROM HABILIDADES H\n" +
                    "INNER JOIN CLASES_RPG C ON H.id_clase = C.id\n" +
                    "where H.ID_CLASE = "+ this.id);
            while(resHabilidad.next()){
                int id = resHabilidad.getInt("id");
                String nombre = resHabilidad.getString("nombre");
                int danioBase = resHabilidad.getInt("dano_base");
                int usosMaximos = resHabilidad.getInt("usos_maximos");
                int idClase = resHabilidad.getInt("id_clase");
                listaHabilidadesClase.add(new Habilidades(id,nombre,danioBase,usosMaximos,idClase));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // lista de habilidades que pertenece a la clase
        this.listaHabilidades = listaHabilidadesClase;
        // igualo a this.listaHabilidades

    }

    @Override
    public String toString() {
        return "ClasesRPG{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", listaHabilidades=" + listaHabilidades +
                '}';
    }
}
