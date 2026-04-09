package rpg.ui;

import rpg.model.Items;
import rpg.model.Personajes;
import rpg.model.Razas;

import java.util.List;
import java.util.Scanner;

public class Vista {
    private Scanner sc;
    public Vista() {
        sc = new Scanner(System.in);
    }
    public int mostrarMenuPrincipal() {
        System.out.println("\n--- ⚔️ RPG DATABASE MANAGER ⚔️ ---");
        System.out.println("1. Crear Personaje");
        System.out.println("2. Viajar a Ciudad");
        System.out.println("3. Ir a la Tienda");
        System.out.println("4. Cobro de Impuestos (Mantenimiento)");
        System.out.println("5. Gestionar Habilidades y Combate");
        System.out.println("6. Centro de Estadísticas");
        System.out.println("0. Salir");
        System.out.print("Selecciona una opción: ");

        while (!sc.hasNextInt()) {
            System.out.print("Por favor, introduce un número válido: ");
            sc.next();
        }
        return sc.nextInt();
    }
    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
    public void mostrarListaPersonajesResumida(List<Personajes> personajes) {
        if (personajes.isEmpty()) {
            System.out.println("\n--- ⚠️ No hay personajes registrados en la Guild ---");
            return;
        }

        System.out.println("\n========================================");
        System.out.println("       📜 LISTADO DE PERSONAJES");
        System.out.println("========================================");
        // %-5s: String alineado a la izquierda con 5 espacios
        // %-20s: String alineado a la izquierda con 20 espacios
        System.out.printf("| %-5s | %-25s |\n", "ID", "NOMBRE DEL HÉROE");
        System.out.println("----------------------------------------");

        for (Personajes p : personajes) {
            System.out.printf("| %-5d | %-25s |\n", p.getId(), p.getNombre());
        }
        System.out.println("========================================\n");
    }
    public int pedirOpcion(){
        mostrarMensaje("Dime que personaje quieres que compre (introducir el ID)");
        return sc.nextInt();
    }
    public int pedirOpcionTienda(){
        mostrarMensaje("Elige objeto para comprar");
        return sc.nextInt();
    }
    public int pedirConfirmacion(){
        mostrarMensaje("Quieres seguir comprando? (0 si o 1 no)");
        return sc.nextInt();
    }
    public void mostrarListaItems(List<Items> items) {
        if (items == null || items.isEmpty()) {
            System.out.println("\n--- ⚠️ No hay items disponibles en el inventario global ---");
            return;
        }

        System.out.println("\n==========================================================================");
        System.out.println("                         ⚔️ CATÁLOGO DE OBJETOS ⚔️");
        System.out.println("==========================================================================");
        // %-5s (ID), %-20s (Nombre), %-12s (Tipo), %-10s (Precio), %-8s (Atq), %-8s (Def)
        System.out.printf("| %-5s | %-20s | %-12s | %-10s | %-6s | %-6s |\n",
                "ID", "NOMBRE", "TIPO", "PRECIO", "ATQ", "DEF");
        System.out.println("--------------------------------------------------------------------------");

        for (Items item : items) {
            System.out.printf("| %-5d | %-20s | %-12s | %-10d | %-6d | %-6d |\n",
                    item.getId(),
                    item.getNombre(),
                    item.getTipo(),
                    item.getPrecioOro(),
                    item.getBonificadorAtaque(),
                    item.getBonificadorDefensa());
        }
        System.out.println("==========================================================================\n");
    }
    public void mostrarListaRazas(List<Razas> razas) {
        if (razas == null || razas.isEmpty()) {
            System.out.println("\n--- ⚠️ No hay razas disponibles ---");
            return;
        }

        System.out.println("\n==========================================================================");
        System.out.println("                         ⚔️ RAZAS DISPONIBLES ⚔️");
        System.out.println("==========================================================================");
        // %-5s (ID), %-20s (Nombre), %-12s (Tipo), %-10s (Precio), %-8s (Atq), %-8s (Def)
        System.out.printf("| %-5s | %-20s | %-12s | %-10s |\n",
                "ID", "NOMBRE", "BON_VIDA", "BON_FUERZA");
        System.out.println("--------------------------------------------------------------------------");

        for (Razas raza : razas) {
            System.out.printf("| %-5d | %-20s | %-12d | %-10d |\n",
                    raza.getId(),
                    raza.getNombre(),
                    raza.getBonificadorVida(),
                    raza.getBonificadorFuerza());
        }
        System.out.println("==========================================================================\n");
    }
    public String pedirNombre(){
        mostrarMensaje("Dime el nombre para tu personaje");
        return sc.nextLine();
    }
}
