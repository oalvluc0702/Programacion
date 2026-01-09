package vista;

import java.util.Scanner;

public class Vista {
    public void mostrarMenuPrincipal(){
        System.out.printf("=====================================%n");
        System.out.printf("               MENÚ%n");
        System.out.printf("=====================================%n");
        System.out.printf("1. Jugar%n");
        System.out.printf("2. Crear Personaje%n");
        System.out.printf("3. Salir%n");
        System.out.printf("=====================================%n");
        System.out.printf("Seleccione una opción: ");
    }
    public int pedirOpcion(){
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }
}
