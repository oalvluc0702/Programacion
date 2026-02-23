package com.rpg.model;

public class Ciudades {
    private String nombre;
    private int poblacion;
    private String clima;
    private int nivelRiesgo;

    public Ciudades(String nombre, int poblacion, String clima, int nivelRiesgo) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.clima = clima;
        this.nivelRiesgo = nivelRiesgo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public int getNivelRiesgo() {
        return nivelRiesgo;
    }

    public void setNivelRiesgo(int nivelRiesgo) {
        this.nivelRiesgo = nivelRiesgo;
    }
}
