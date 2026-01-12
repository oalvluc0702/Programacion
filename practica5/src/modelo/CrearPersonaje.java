package modelo;

import modelo.clases.Clase;
import modelo.razas.Raza;

import java.util.ArrayList;

public class CrearPersonaje {
    private String nombre;
    private Raza raza;
    private Clase clase;
    private ArrayList<Personaje> personajes;
    public CrearPersonaje(String nombre, Raza raza, Clase clase, ArrayList<Personaje> personajes) {
        this.nombre = nombre;
        this.raza = raza;
        this.clase = clase;
        this.personajes = personajes;
        Personaje personaje = new Personaje(this.nombre,this.clase,this.raza);
        agregarPersonajeLista(personajes,personaje);
    }
    public void agregarPersonajeLista(ArrayList<Personaje> listaPersonajes, Personaje personaje){
        listaPersonajes.add(personaje);
    }
}
