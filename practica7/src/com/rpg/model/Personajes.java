package com.rpg.model;

import java.util.List;

public class Personajes {
    private String nombre;
    private String raza;
    private Integer nivel;
    private List<Items> equipo;

    public Personajes(String nombre, String raza, Integer nivel, List<String> equipo) {
        this.nombre = nombre;
        this.raza = raza;
        this.nivel = nivel;
        this.equipo = equipo;
    }

    public Personajes(String nombre, String raza, List<String> items) {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public List<Items> getEquipo() {
        return equipo;
    }

    public void setEquipo(List<Items> equipo) {
        this.equipo = equipo;
    }
}
