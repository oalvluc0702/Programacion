package vista;

import modelo.CargaDatos;
import modelo.CrearPersonaje;
import modelo.Personaje;
import modelo.clases.*;
import modelo.estadosAlterados.Estados;
import modelo.habilidades.Habilidades;
import modelo.razas.Elfo;
import modelo.razas.Enano;
import modelo.razas.Humano;
import modelo.razas.Raza;
import java.util.ArrayList;
import java.util.Scanner;

//clase que se encarga principalmente de mandar todos los mensajes y de gestionar los inputs por pantalla
//tiene una lista de personajes que recibirá de la carga de datos para utilizar diversas funciones y clases.
public class Vista {

    private ArrayList<Personaje> personajes;

    //constructor - almacena la lista de personajes de la carga de datos y llama a la función de inicio()
    public Vista(){
        CargaDatos cargaDatos = new CargaDatos();
        this.personajes = cargaDatos.getListaPersonajes();
        inicio();
    }
    //función que ejecuta el primer menú principal utilizando mensajes de la vista y pidiendo opciones
    public void inicio(){
        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = pedirOpcion();
            switch (opcion){
                //se encarga de pedir 2 combatientes para crear un nuevo combate
                case 1:
                    mostrarMenuCombate();
                    System.out.println("Selecciona tu primer luchador:");
                    Personaje luchador1 = pedirCombatiente();
                    System.out.println("Selecciona a tu segundo luchador");
                    Personaje luchador2 = pedirCombatiente();
                    Combate combate = new Combate(luchador1,luchador2,this);
                    break;
                //se encarga de ejecutar el bloque referente a la creación de personaje llamando a la clase CrearPersonaje
                case 2:
                    mostrarCreacionPersonaje();
                    String nombre = pedirNombre();
                    Raza raza = pedirRaza();
                    Clase clase = pedirClase();
                    CrearPersonaje crearPersonaje = new CrearPersonaje(nombre,raza,clase, this.personajes);
                    System.out.println("Personaje "+nombre+ " creado correctamente");
                    break;
                //finaliza el programa
                case 3:
                    System.out.println("Juego Finalizado");
                    break;
            }
        } while (opcion != 3);
    }
    //se encarga de pedir el combatiente de la lista de personajes
    public Personaje pedirCombatiente(){
        Scanner s = new Scanner(System.in);
        int opcion = s.nextInt();
        return this.personajes.get(opcion);
    }
    //muestra el menú del combate y el listado de los personajes
    public void mostrarMenuCombate(){
        System.out.printf("=====================================%n");
        System.out.printf("            HAS ELEGIDO EL COMBATE %n");
        System.out.printf("=====================================%n");
        mostrarPersonajesDisponibles();
    }
    // muestra un listado con índices de los personajes que tienes en la lista de personajes
    public void mostrarPersonajesDisponibles(){
        int contador = 0;
        for (Personaje personaje: this.personajes){
            System.out.printf("%d.-Nombre: %s Raza: %s Clase: %s%n",contador,personaje.getNombre(),personaje.getRaza().getClass().getSimpleName(),personaje.getClase().getClass().getSimpleName());
            contador++;
        }
    }
    //Muestra el menú principal
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
    // pide una opción para los switch
    public int pedirOpcion(){
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }
    //Muestra el cartel de crear personaje
    public void mostrarCreacionPersonaje(){
        System.out.printf("=====================================%n");
        System.out.printf("        CREA TU PERSONAJE %n");
        System.out.printf("=====================================%n");
    }
    //te pide el nombre para el personaje
    public String pedirNombre(){
        Scanner s = new Scanner(System.in);
        System.out.printf("=====================================%n");
        System.out.printf("  DIME EL NOMBRE DE TU PERSONAJE %n");
        System.out.printf("=====================================%n");
        return s.nextLine();
    }
    //te pide una raza que dependiendo del número que tu escojas te crea un nuevo objeto del tipo Raza que le corresponda
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
    // hace lo mismo que con la raza pero para clase
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
    // muestra el personaje con sus características y estados alterados
    public void mostrarPersonaje(Personaje personaje){
        System.out.printf("%s: %d/%d%n",personaje.getNombre(),personaje.getEstadisticas().getVidaActual(),personaje.getEstadisticas().getVida());
        System.out.printf("usos: melee- %d curación- %d distancia/ultimate %d  %n",personaje.getEstadisticas().getMelee(),personaje.getEstadisticas().getCuracion(),personaje.getEstadisticas().getHabilidadDistancia());
        System.out.printf("estados: ");
        if (personaje.getEstados().isEmpty()){
            System.out.printf("None");
        } else {
            for (Estados estados: personaje.getEstados()){
                System.out.printf("%s ",mostrarIconoEstado(estados.getNombre()));
            }
        }
        System.out.println();

    }
    //función que sirve para mostrar un el icono dependiendo del estado que esté sufriendo
    public String mostrarIconoEstado(String estado){
        switch (estado){
            case "Envenenamiento" -> {
                return "☠️";
            }
            case "Sangrado" -> {
                return "🩸";
            }
            case "Quemado" -> {
                return "\uD83D\uDD25";
            }
        }
        return estado;
    }
    //muestra el menú de acciones que tiene un peleador en el combate
    public void mostrarMenuAcciones(){
        System.out.printf("=====================================%n");
        System.out.printf("         MENÚ DE ACCIONES:    %n");
        System.out.printf("=====================================%n");
        System.out.printf("1. Atacar%n");
        System.out.printf("2. Habilidades %n");
    }
    //hace un listado de las habilidades por índice para que sea utilizable en el combate
    public void mostrarHabilidades(Personaje personaje){
        int contador= 0;
        for (Habilidades habilidades: personaje.getHabilidades()){
            System.out.printf("%d. %s: Tipo: %s Potencia: %d%n",contador,habilidades.getNombre(), habilidades.getTipo(), habilidades.getPotencia());
            contador++;
        }
    }
    //muestra el mensaje de victoria, muestra el contrario al que le haya bajado la vida a 0
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
