package rpg.model;

import java.util.Map;

public class Personajes {
    private int id;
    private String nombre;
    private int nivel;
    private int oro;
    private int vida_actual;

    private Razas raza;
    private ClasesRPG clase;
    private Ciudades ciudad;

    private Map<Items, Integer> inventario;

    private Map<Habilidades, Boolean> habilidadesEquipadas;

    public Personajes(int id, String nombre, Razas raza, ClasesRPG clase, Ciudades ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.clase = clase;
        this.ciudad = ciudad;
        this.nivel = 1;
        this.vida_actual = 100;
        this.oro = 100;
    }

    public Personajes(int id, String nombre, int nivel, int oro, int vida_actual, Razas raza, ClasesRPG clase, Ciudades ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
        this.oro = oro;
        this.vida_actual = vida_actual;
        this.raza = raza;
        this.clase = clase;
        this.ciudad = ciudad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public int getVida_actual() {
        return vida_actual;
    }

    public void setVida_actual(int vida_actual) {
        this.vida_actual = vida_actual;
    }

    public Razas getRaza() {
        return raza;
    }

    public void setRaza(Razas raza) {
        this.raza = raza;
    }

    public ClasesRPG getClase() {
        return clase;
    }

    public void setClase(ClasesRPG clase) {
        this.clase = clase;
    }

    public Ciudades getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudades ciudad) {
        this.ciudad = ciudad;
    }

    public Map<Items, Integer> getInventario() {
        return inventario;
    }

    public void setInventario(Map<Items, Integer> inventario) {
        this.inventario = inventario;
    }

    public Map<Habilidades, Boolean> getHabilidadesEquipadas() {
        return habilidadesEquipadas;
    }

    public void setHabilidadesEquipadas(Map<Habilidades, Boolean> habilidadesEquipadas) {
        this.habilidadesEquipadas = habilidadesEquipadas;
    }

    @Override
    public String toString() {
        return "Personajes{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", oro=" + oro +
                ", vida_actual=" + vida_actual +
                ", raza=" + raza +
                ", clase=" + clase +
                ", ciudad=" + ciudad +
                ", inventario=" + inventario +
                ", habilidadesEquipadas=" + habilidadesEquipadas +
                '}';
    }
}

