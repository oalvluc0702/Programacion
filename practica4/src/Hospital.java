import java.awt.geom.Area;
import java.util.ArrayList;

public class Hospital {
    private String cif;
    private String nombre;
    private ArrayList<Areas> areas;


    public Hospital() {
    }

    public Hospital(String cif, String nombre) {
        this.cif = cif;
        this.nombre = nombre;
        this.areas = new ArrayList<>();
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Areas> getAreas() {
        return areas;
    }

    public void agregarArea(Areas areas) {
        this.areas.add(areas);
    }
}

