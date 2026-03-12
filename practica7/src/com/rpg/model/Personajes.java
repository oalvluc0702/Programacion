package com.rpg.model;

import java.util.ArrayList;
import java.util.List;

public class Personajes {
    private String nombre;
    private String raza;
    private Integer nivel;

    // Este campo se lee y escribe en el JSON ("equipoIds": ["E01", "W02"])
    private List<String> equipoIds;

    // 'transient' hace que GSON ignore este campo al serializar/deserializar
    private transient List<Items> equipo;

    // Constructor vacío
    public Personajes() {
        this.equipoIds = new ArrayList<>();
        this.equipo = new ArrayList<>();
    }

    // Constructor completo
    public Personajes(String nombre, String raza, Integer nivel, List<String> equipoIds) {
        this.nombre = nombre;
        this.raza = raza;
        this.nivel = nivel;
        this.equipoIds = equipoIds;
        this.equipo = new ArrayList<>(); // Se inicializa vacía hasta que se vincule
    }

    // --- GETTERS Y SETTERS ---

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
                ", equipoIds=" + equipoIds + // Mostramos los IDs
                ", equipo=" + equipo +       // Y los objetos si ya están vinculados
                '}';
    }
}