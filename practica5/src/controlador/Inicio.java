package controlador;

import modelo.CargaDatos;
import modelo.Personaje;
import modelo.clases.Clase;
import modelo.razas.Raza;
import vista.Vista;

import java.util.ArrayList;

public class Inicio {
    private Vista vista;
    private CargaDatos cargaDatos;
    private ArrayList<Personaje> listaPersonajes;

    public Inicio(Vista vista) {
        this.vista = vista;
        this.listaPersonajes = cargaDatos.getListaPersonajes();
        this.cargaDatos = new CargaDatos();
        mostrarMenuInicio();
    }
    public void mostrarMenuInicio(){
        int opcion;
        do {
            vista.mostrarMenuPrincipal();
            opcion = vista.pedirOpcion();
            switch (opcion){
                case 1:
                    break;
                case 2:
                    crearPersonaje();
                    break;
                case 3:
                    break;
            }
        } while (opcion != 3);
    }
    public void crearPersonaje(){
        vista.mostrarCreacionPersonaje();
        String nombre = vista.pedirNombre();
        Raza raza = vista.pedirRaza();
        Clase clase = vista.pedirClase();
    }
}
