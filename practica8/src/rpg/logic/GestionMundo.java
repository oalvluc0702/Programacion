package rpg.logic;

import rpg.dao.Conexion;
import rpg.model.Ciudades;
import rpg.model.ClasesRPG;
import rpg.model.Items;
import rpg.model.Razas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionMundo {
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Ciudades> listaCiudades = new ArrayList<>();
    private ArrayList<Items> listaItems = new ArrayList<>();
    private ArrayList<Razas> listaRazas = new ArrayList<>();
    private ArrayList<ClasesRPG> listaClases = new ArrayList<>();
    public GestionMundo() {
        /*mostrarMenu();*/
        cargarTodo();
//        for (Ciudades ciudad : listaCiudades){
//            System.out.println(ciudad.toString());
//        }
//        for (Items item : listaItems){
//            System.out.println(item.toString());
//        }
//        for (Razas raza : listaRazas){
//            System.out.println(raza.toString());
//        }
        for (ClasesRPG clase : listaClases){
            System.out.println(clase.toString());
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
        try{
            ResultSet res = Conexion.consulta("SELECT * FROM CIUDADES");
            while(res.next()){
                int id = res.getInt("id");
                String nombre = res.getString("nombre");
                int nivelMinimoAcceso = res.getInt("nivel_minimo_acceso");
                listaCiudades.add(new Ciudades(id,nombre,nivelMinimoAcceso));
            }
            ResultSet resItems = Conexion.consulta("SELECT * FROM ITEMS");
            while (resItems.next()){
                int id = resItems.getInt("id");
                String nombre = resItems.getString("nombre");
                String tipo = resItems.getString("tipo");
                int precioOro = resItems.getInt("precio_oro");
                int bonificadorAtaque = resItems.getInt("bonificador_ataque");
                int bonificadorDefensa= resItems.getInt("bonificador_defensa");
                listaItems.add(new Items(id,nombre,tipo,precioOro,bonificadorAtaque,bonificadorDefensa));
            }
            ResultSet resRazas = Conexion.consulta("SELECT * FROM RAZAS");

            while (resRazas.next()) {
                int id = resRazas.getInt("id");
                String nombre = resRazas.getString("nombre");
                int bonificadorVida = resRazas.getInt("bonificador_vida");
                int bonificadorFuerza = resRazas.getInt("bonificador_fuerza");
                listaRazas.add(new Razas(id, nombre, bonificadorVida, bonificadorFuerza));
            }

            ResultSet resClases = Conexion.consulta("SELECT * FROM CLASES_RPG");

            while (resClases.next()){
                int id = resClases.getInt("id");
                String nombre = resClases.getString("nombre");

                listaClases.add(new ClasesRPG(id,nombre));
            }
        } catch (SQLException e ){
            System.out.println("Fallo en las consultas");
        }

    }
}
