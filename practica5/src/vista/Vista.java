package vista;

import modelo.clases.*;
import modelo.razas.Elfo;
import modelo.razas.Enano;
import modelo.razas.Humano;
import modelo.razas.Raza;

import java.util.Scanner;

public class Vista {
    public Vista(){
        int opcion;
        do {
            this.mostrarMenuPrincipal();
            opcion = this.pedirOpcion();
            switch (opcion){
                case 1:
                    break;
                case 2:
                    //crearPersonaje();
                    break;
                case 3:
                    break;
            }
        } while (opcion != 3);
    }
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
    public void mostrarCreacionPersonaje(){
        System.out.printf("=====================================%n");
        System.out.printf("        CREA TU PERSONAJE %n");
        System.out.printf("=====================================%n");
    }
    public String pedirNombre(){
        Scanner s = new Scanner(System.in);
        System.out.printf("=====================================%n");
        System.out.printf("  DIME EL NOMBRE DE TU PERSONAJE %n");
        System.out.printf("=====================================%n");
        return s.nextLine();
    }
    public Raza pedirRaza(){
        Scanner s = new Scanner(System.in);
        System.out.printf("=====================================%n");
        System.out.printf(" SELECCIONA LA RAZA DE TU PERSONAJE %n");
        System.out.printf("=====================================%n");
        System.out.printf("1. Elfo%n");
        System.out.printf("2. Enano%n");
        System.out.printf("3. Humano%n");
        int opcion = s.nextInt();
        switch (opcion){
            case 1:
                return new Elfo();
            case 2:
                return new Enano();
            case 3:
                return new Humano();
            default:
                return new Humano();
        }
    }
    public Clase pedirClase(){
        Scanner s = new Scanner(System.in);
        System.out.printf("=====================================%n");
        System.out.printf(" SELECCIONA LA CLASE DE TU PERSONAJE %n");
        System.out.printf("=====================================%n");
        System.out.printf("1. Bardo%n");
        System.out.printf("2. Druida%n");
        System.out.printf("3. Guerrero%n");
        System.out.printf("4. Mago%n");
        System.out.printf("5. Monje%n");
        System.out.printf("6. Paladin%n");
        System.out.printf("7. Picaro%n");
        System.out.printf("8. Sacerdote%n");
        int opcion = s.nextInt();
        switch (opcion){
            case 1:
                return new Bardo();
            case 2:
                return new Druida();
            case 3:
                return new Guerrero();
            case 4:
                return new Mago();
            case 5:
                return new Monje();
            case 6:
                return new Paladin();
            case 7:
                return new Picaro();
            case 8:
                return new Sacerdote();
            default:
                return new Guerrero();
        }
    }
}
