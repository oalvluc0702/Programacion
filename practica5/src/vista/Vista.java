package vista;

import modelo.CargaDatos;
import modelo.CrearPersonaje;
import modelo.Personaje;
import modelo.clases.*;
import modelo.habilidades.Habilidades;
import modelo.razas.Elfo;
import modelo.razas.Enano;
import modelo.razas.Humano;
import modelo.razas.Raza;
import java.util.ArrayList;
import java.util.Scanner;

public class Vista {

    private ArrayList<Personaje> personajes;

    public Vista(){
        CargaDatos cargaDatos = new CargaDatos();
        this.personajes = cargaDatos.getListaPersonajes();
        inicio();
    }
    public void inicio(){
        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = pedirOpcion();
            switch (opcion){
                case 1:
                    mostrarMenuCombate();
                    System.out.println("Selecciona tu primer luchador:");
                    Personaje luchador1 = pedirCombatiente();
                    System.out.println("Selecciona a tu segundo luchador");
                    Personaje luchador2 = pedirCombatiente();
                    Combate combate = new Combate(luchador1,luchador2,this);
                    break;
                case 2:
                    mostrarCreacionPersonaje();
                    String nombre = pedirNombre();
                    Raza raza = pedirRaza();
                    Clase clase = pedirClase();
                    CrearPersonaje crearPersonaje = new CrearPersonaje(nombre,raza,clase, this.personajes);
                    System.out.println("Personaje "+nombre+ " creado correctamente");
                    break;
                case 3:
                    System.out.println("Juego Finalizado");
                    break;
            }
        } while (opcion != 3);
    }
    public Personaje pedirCombatiente(){
        Scanner s = new Scanner(System.in);
        int opcion = s.nextInt();
        return this.personajes.get(opcion);
    }
    public void mostrarMenuCombate(){
        System.out.printf("=====================================%n");
        System.out.printf("            HAS ELEGIDO EL COMBATE %n");
        System.out.printf("=====================================%n");
        mostrarPersonajesDisponibles();
    }
    public void mostrarPersonajesDisponibles(){
        int contador = 0;
        for (Personaje personaje: this.personajes){
            System.out.printf("%d.-Nombre: %s Raza: %s Clase: %s%n",contador,personaje.getNombre(),personaje.getRaza().getClass().getSimpleName(),personaje.getClase().getClass().getSimpleName());
            contador++;
        }
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
    public void mostrarPersonaje(Personaje personaje){
        System.out.printf("%s: %d/%d%n",personaje.getNombre(),personaje.getEstadisticas().getVidaActual(),personaje.getEstadisticas().getVida());
        System.out.printf("usos: melee- %d curación- %d distancia/ultimate %d  %n",personaje.getEstadisticas().getMelee(),personaje.getEstadisticas().getCuracion(),personaje.getEstadisticas().getHabilidadDistancia());
       // System.out.printf("estados %s", personaje.getEstados());

    }
    public void mostrarMenuAcciones(){
        System.out.printf("=====================================%n");
        System.out.printf("         MENÚ DE ACCIONES:    %n");
        System.out.printf("=====================================%n");
        System.out.printf("1. Atacar%n");
        System.out.printf("2. Habilidades %n");
    }
    public void mostrarHabilidades(Personaje personaje){
        int contador= 0;
        for (Habilidades habilidades: personaje.getHabilidades()){
            System.out.printf("%d. %s: Tipo: %s Potencia: %d%n",contador,habilidades.getNombre(), habilidades.getTipo(), habilidades.getPotencia());
            contador++;
        }
    }
    public void mostrarMensajeVictoria(Personaje luchador1, Personaje luchador2){
        if (luchador1.getEstadisticas().getVidaActual() <= 0){
            System.out.printf("=====================================%n");
            System.out.printf("         HA GANADO: %s    %n",luchador2.getNombre());
            System.out.printf("=====================================%n");
        } else {
            System.out.printf("=====================================%n");
            System.out.printf("         HA GANADO: %s    %n",luchador1.getNombre());
            System.out.printf("=====================================%n");
        }

    }
}
