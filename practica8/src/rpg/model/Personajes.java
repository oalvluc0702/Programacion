package rpg.model;

import rpg.dao.PersonajesDao;
import rpg.exception.LimiteHabilidadesException;

import java.util.HashMap;
import java.util.List;
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
        restablecerVida();
        if (this.ciudad.getNivelMinimoAcceso() == 1){
            this.oro = 100;
        } else{
            this.oro = 500;
        }
        inventario = new HashMap<>();
        habilidadesEquipadas = new HashMap<>();
        añadirHabilidadesDeRaza();
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
    public void añadirInventario(Items objeto){
        this.inventario.put(objeto,inventario.getOrDefault(objeto,0)+1);
    }
    public void añadirHabilidadesDeRaza() {
        List<Habilidades> listaHabilidades = clase.getListaHabilidades();
        for (Habilidades habilidad : listaHabilidades) {
            // Si ya existe, se queda como estaba.
            habilidadesEquipadas.putIfAbsent(habilidad, false);
        }
    }
    public void disminuirOro(int cantidad){
        setOro(this.oro-cantidad);
    }
    public int getFuerzaTotal(){
        int ataqueObjetos = 0;
        for (Items item : inventario.keySet()){
            int cantidad = inventario.get(item);
            int ataque = item.getBonificadorAtaque();
            int ataqueTotal = ataque*cantidad;
            ataqueObjetos+=ataqueTotal;
        }
        int fuerzaTotal = raza.getBonificadorFuerza()+ataqueObjetos;
        return fuerzaTotal;
    }
    public int getDefensaTotal() {
        int defensaObjetos = 0;

        for (Items item : inventario.keySet()) {
            int cantidad = inventario.get(item);
            int defensa = item.getBonificadorDefensa();
            int defensaTotal = defensa * cantidad;

            defensaObjetos += defensaTotal;
        }

        return defensaObjetos;
    }
    public void equiparDesequiparHabilidad(Habilidades habilidad, PersonajesDao personajesDao) throws LimiteHabilidadesException {
        // 1. Miramos el estado actual de la habilidad
        boolean estaEquipada = habilidadesEquipadas.getOrDefault(habilidad, false);

        // 2. Si NO está equipada y el usuario quiere equiparla (pasarla a true)
        if (!estaEquipada) {
            int contador = 0;

            // comprobar cuantas hay true
            for (Boolean valor : habilidadesEquipadas.values()) {
                if (valor != null && valor) {
                    contador++;
                }
            }

            // comprobamos si el contador es mayor o igual a 3
            if (contador >= 3) {
                throw new LimiteHabilidadesException("No puedes equipar más de 3 habilidades.");
            }

            // Si hay hueco, la equipamos
            habilidadesEquipadas.put(habilidad, true);
            personajesDao.updateEstadoHabilidad(id, habilidad.getId(), true);
            System.out.println("Habilidad: " + habilidad.getNombre() + " equipada.");

        } else {
            // Si ya estaba equipada (true), simplemente la desequipamos (false)
            // No hace falta contar porque desequipar nunca rompe el límite
            habilidadesEquipadas.put(habilidad, false);
            personajesDao.updateEstadoHabilidad(id, habilidad.getId(), false);
            System.out.println("Habilidad " + habilidad.getNombre() + " desequipada.");
        }
    }
    public void restablecerVida() {
        // Esta es la fórmula que usas en tu constructor
        this.vida_actual = 100 + this.raza.getBonificadorVida();
    }
    public int contarHabilidadesEquipadas(){
        int contador = 0;
        for (Habilidades habilidades : habilidadesEquipadas.keySet()){
            if (habilidadesEquipadas.get(habilidades)) contador++;
        }
        return contador;
    }
    public int contarObjetos(){
        int contador = 0;
        for (Items item : inventario.keySet()){
            int cantidad = inventario.get(item);
            contador += cantidad;
        }
        return contador;
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

