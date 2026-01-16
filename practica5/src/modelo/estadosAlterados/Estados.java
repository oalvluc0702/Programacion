package modelo.estadosAlterados;

import modelo.Personaje;
//Esta clase abstracta hace de padre de las subclases que son estados alterados
public abstract class Estados {
    //tienen un nombre y una duración
    private String nombre;
    private int duracion;
    //en el constructor le pasas el nombre y la duración
    public Estados(String nombre, int duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }
    //esta es la función que tienen que implementar todas las subclases de su propia forma

    public abstract void aplicarEfecto(Personaje personaje);

    //getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    //esta función sirve para disminuir la duración dentro del combate del estado alterado
    public void disminuirDuracion(){
        setDuracion(this.getDuracion()-1);
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    //esta función comprueba si el estado alterado ha finalizado y devuelve un verdadero o falso

    public boolean haFinalizado(){
        return this.getDuracion() <= 0;
    }
}
