package controlador;

import modelo.CargaDatos;
import vista.Vista;

public class Inicio {
    private Vista vista;
    private CargaDatos cargaDatos;

    public Inicio(Vista vista, CargaDatos cargaDatos) {
        this.vista = vista;
        this.cargaDatos = cargaDatos;
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
                    break;
                case 3:
                    break;
            }
        } while (opcion != 3);
    }
}
