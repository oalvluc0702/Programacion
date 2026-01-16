package modelo.habilidades;

import modelo.Personaje;
//Esta es la clase abstracta que hace de padre para todas las habilidades
//tiene un nombre una potencia y un tipo con el que luego se trabajará en el combate
public abstract class Habilidades {
    private String nombre;
    private int potencia;
    private String tipo;

    //constructor

    public Habilidades(String nombre, int potencia, String tipo) {
        this.nombre = nombre;
        this.potencia = potencia;
        this.tipo = tipo;
    }
    //esta es la función abstracta que todas las habilidades tienen que implementar a su manera
    public abstract int usarHabilidad(Personaje personaje);

    //getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
