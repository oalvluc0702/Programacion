package modelo;

import modelo.clases.Paladin;
import modelo.clases.Picaro;
import modelo.razas.Elfo;
import modelo.razas.Enano;

import java.util.ArrayList;

//Esta es la clase que se encarga de cargar los datos de los personajes pre-creados tiene como atributo la lista de personajes
// se crea en el constructor tanto los personajes como la lista y luego se añaden.
public class CargaDatos {

    private ArrayList<Personaje> listaPersonajes;

    //Constructor

    public CargaDatos() {
        Personaje p1 = new Personaje("Óscar",new Paladin(),new Enano());
        Personaje p2 = new Personaje("Mario",new Picaro(),new Elfo());
        this.listaPersonajes = new ArrayList<>();
        listaPersonajes.add(p1);
        listaPersonajes.add(p2);
    }
    //getters y setters

    public ArrayList<Personaje> getListaPersonajes() {
        return listaPersonajes;
    }

    public void setListaPersonajes(ArrayList<Personaje> listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
    }
}
