package rpg.model;

import java.util.ArrayList;
import java.util.List;

public class ClasesRPG {
    private int id;
    private String nombre;
    private List<Habilidades> listaHabilidades;

    public ClasesRPG(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.listaHabilidades = new ArrayList<>();
    }


    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public List<Habilidades> getListaHabilidades() { return listaHabilidades; }
    public void setListaHabilidades(List<Habilidades> listaHabilidades) {
        this.listaHabilidades = listaHabilidades;
    }

    @Override
    public String toString() {
        return "Clase: " + nombre + " | Habilidades: " + listaHabilidades.size();
    }
}