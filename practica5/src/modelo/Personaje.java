package modelo;
import modelo.clases.Clase;
import modelo.habilidades.Habilidades;
import modelo.razas.Estadisticas;
import modelo.razas.Raza;

import java.util.ArrayList;

public class Personaje {
    private String nombre;
    private Clase clase;
    private Raza raza;
    private Estadisticas estadisticas;
    private ArrayList<Habilidades> habilidades;

    public Personaje(String nombre, Clase clase, Raza raza) {
        this.nombre = nombre;
        this.clase = clase;
        this.raza = raza;
        this.estadisticas = new Estadisticas();
        raza.establecerEstadisticasBase(this.estadisticas);
        this.habilidades = new ArrayList<>();
        this.clase.agregarBonificacionClase(this);
        this.clase.agregarHabilidad(this);

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public Estadisticas getEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(Estadisticas estadisticas) {
        this.estadisticas = estadisticas;
    }

    public ArrayList<Habilidades> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<Habilidades> habilidades) {
        this.habilidades = habilidades;
    }
}
