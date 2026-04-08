package rpg.logic;

import rpg.dao.*;
import rpg.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionMundo {
    private Scanner sc = new Scanner(System.in);
    //Listas
    private List<Ciudades> listaCiudades;
    private List<Items> listaItems;
    private List<Razas> listaRazas;
    private List<ClasesRPG> listaClases;
    private List<Habilidades> listaHabilidades;
    private List<Personajes> listaPersonajes;
    //DAO
    private CiudadesDao ciudadesDao;
    private ItemsDao itemsDao;
    private RazasDao razasDao;
    private ClasesRPGDao clasesRPGDao;
    private HabilidadDao habilidadDao;
    private PersonajesDao personajesDao;
    public GestionMundo() {
        listaItems = new ArrayList<>();
        listaRazas = new ArrayList<>();
        listaCiudades = new ArrayList<>();
        listaClases = new ArrayList<>();
        listaHabilidades = new ArrayList<>();
        listaPersonajes = new ArrayList<>();

        ciudadesDao = new CiudadesDao();
        itemsDao = new ItemsDao();
        razasDao = new RazasDao();
        clasesRPGDao = new ClasesRPGDao();
        habilidadDao = new HabilidadDao();
        personajesDao = new PersonajesDao();
        /*mostrarMenu();*/
        cargarTodo();
        for (Ciudades ciudad : listaCiudades){
           System.out.println(ciudad.toString());
        }
        for (Items item : listaItems){
            System.out.println(item.toString());
        }
        for (Razas raza : listaRazas){
            System.out.println(raza.toString());
        }
        for (ClasesRPG clase : listaClases){
            System.out.println(clase.toString());
        }
        for (Personajes personajes : listaPersonajes){
            System.out.println(personajes.toString());
        }
    }
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- ⚔️ RPG DATABASE MANAGER ⚔️ ---");
            System.out.println("1. Crear Personaje");
            System.out.println("2. Viajar a Ciudad");
            System.out.println("3. Ir a la Tienda");
            System.out.println("4. Cobro de Impuestos (Mantenimiento)");
            System.out.println("5. Gestionar Habilidades y Combate");
            System.out.println("6. Centro de Estadísticas");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();
            /*
            switch (opcion) {
                case 1 -> crearPersonaje();
                case 2 -> viajar();
                case 3 -> comprarItems();
                case 4 -> ejecutarImpuestos();
                case 5 -> menuCombate();
                case 6 -> mostrarEstadisticas();
                case 0 -> System.out.println("Guardando partida y saliendo...");
            }
             */
        } while (opcion != 0);
    }
    public void cargarTodo(){
            listaCiudades = ciudadesDao.getCiudades();
            listaItems = itemsDao.getItems();
            listaRazas = razasDao.getRazas();
            listaClases = clasesRPGDao.getClases();
            listaHabilidades = habilidadDao.getHabilidades();
            listaPersonajes = personajesDao.getPersonajes(listaItems,listaCiudades,listaHabilidades,listaClases,listaRazas);
    }
}
