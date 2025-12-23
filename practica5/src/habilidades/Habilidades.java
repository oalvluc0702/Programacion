package habilidades;

import razas.Personaje;

public abstract class Habilidades {
    private String nombre;
    private int potencia;
    private String tipo;

    public Habilidades(String nombre, int potencia, String tipo) {
        this.nombre = nombre;
        this.potencia = potencia;
        this.tipo = tipo;
    }

    public abstract void usarHabilidad(Personaje personaje, Personaje objetivo);

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
