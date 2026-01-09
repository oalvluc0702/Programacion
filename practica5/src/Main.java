import controlador.Inicio;
import modelo.CargaDatos;
import vista.Vista;

public class Main {
    public static void main(String[] args) {
        CargaDatos carga = new CargaDatos();
        Vista vista = new Vista();
        Inicio inicio = new Inicio(vista,carga);
        inicio.mostrarMenuInicio();
    }
}