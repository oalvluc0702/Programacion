import java.util.Scanner;

public  class Main {
    public static void main(String[] args){
        //Instanciamos el objeto menú para poder acceder a la función presentación
        MenuGestor menu = new MenuGestor();
        //llamamos al metodo presentación que es el que ejecuta la estructura del programa.
        menu.presentacion();
    }
}
