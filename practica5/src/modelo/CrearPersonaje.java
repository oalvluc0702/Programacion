package modelo;

import modelo.clases.Clase;
import modelo.razas.Raza;

import java.util.ArrayList;
//Esta es la clase que se encarga de la creación de personajes y añadirlo a la lista de personajes
//le tienes que pasar un nombre, una raza, una clase y la lista de personajes.
public class CrearPersonaje {
    private String nombre;
    private Raza raza;
    private Clase clase;
    private ArrayList<Personaje> personajes;

    //constructor

    public CrearPersonaje(String nombre, Raza raza, Clase clase, ArrayList<Personaje> personajes) {
        this.nombre = nombre;
        this.raza = raza;
        this.clase = clase;
        this.personajes = personajes;
        Personaje personaje = new Personaje(this.nombre,this.clase,this.raza);
        agregarPersonajeLista(personajes,personaje);
    }

    //esta es la función que se encarga de añadir el personaje a la lista

    public void agregarPersonajeLista(ArrayList<Personaje> listaPersonajes, Personaje personaje){
        listaPersonajes.add(personaje);
    }
}
