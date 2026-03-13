package com.rpg.model;

import java.util.ArrayList;
import java.util.List;

public class Personajes {
    private String nombre;
    private String raza;
    private Integer nivel;

    // Este campo se lee y escribe en el JSON para luego la validación
    private List<String> equipoIds;

    // transient hace que GSON ignore este campo al leer
    private transient List<Items> equipo;
    private String nombreCiudad;
    private transient Ciudades ciudad;
    // Constructor vacío
    public Personajes() {
        this.equipoIds = new ArrayList<>();
        this.equipo = new ArrayList<>();
    }

    // Constructor completo
    public Personajes(String nombre, String raza, Integer nivel, List<String> equipoIds, String nombreCiudad) {
        this.nombre = nombre;
        this.raza = raza;
        this.nivel = nivel;
        this.equipoIds = equipoIds;
        // se inicializa vacío hasta que se le asignan los objetos
        this.equipo = new ArrayList<>();
        this.nombreCiudad = nombreCiudad;
    }

    // --- GETTERS Y SETTERS ---


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public Ciudades getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudades ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public Integer getNivel() {
        return nivel;
    }

    public List<String> getEquipoIds() {
        return equipoIds;
    }

    public void setEquipoIds(List<String> equipoIds) {
        this.equipoIds = equipoIds;
    }

    public List<Items> getEquipo() {
        return equipo;
    }

    public void setEquipo(List<Items> equipo) {
        this.equipo = equipo;
    }

    // ... (Mantén tus otros getters y setters de nombre, raza, nivel) ...

    @Override
    public String toString() {
        return "Personajes{" +
                "nombre='" + nombre + '\'' +
                ", raza='" + raza + '\'' +
                ", nivel=" + nivel +
                ", equipoIds=" + equipoIds +
                ", equipo=" + equipo +
                '}';
    }
}