package modelo.estadosAlterados;

import modelo.Personaje;

public abstract class Estados {
    private String nombre;
    private int duracion;

    public Estados(String nombre, int duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }
    public abstract void aplicarEfecto(Personaje personaje);

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }
    public void disminuirDuracion(){
        setDuracion(this.getDuracion()-1);
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public boolean haFinalizado(){
        return this.getDuracion() <= 0;
    }
}
