package modelo;

import modelo.clases.Paladin;
import modelo.clases.Picaro;
import modelo.razas.Elfo;
import modelo.razas.Enano;

import java.util.ArrayList;

public class CargaDatos {
    private ArrayList<Personaje> listaPersonajes;
    public CargaDatos() {
        Personaje p1 = new Personaje("Óscar",new Paladin(),new Enano());
        Personaje p2 = new Personaje("Mario",new Picaro(),new Elfo());
        this.listaPersonajes = new ArrayList<>();
        listaPersonajes.add(p1);
        listaPersonajes.add(p2);
    }
}
