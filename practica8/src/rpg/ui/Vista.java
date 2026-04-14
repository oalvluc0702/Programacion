package rpg.ui;

import rpg.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Vista {
    private Scanner sc;

    public Vista() {
        sc = new Scanner(System.in);
    }
    // la mayoria de menús los ha hecho gemini, por eso se ven tan bonitos

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
            sc.next(); // Descarta la entrada no válida
        }

        int opcion = sc.nextInt();
        sc.nextLine(); // Limpiamos el buffer para que la siguiente lectura no falle
        return opcion;
    }

    public void mostrarMensaje(String mensaje) {
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

    public void mostrarListaPersonajesNivel(List<Personajes> personajes) {
        if (personajes == null || personajes.isEmpty()) {
            System.out.println("\n--- ⚠️ No hay personajes registrados en la Guild ---");
            return;
        }

        System.out.println("\n==================================================");
        System.out.println("            📜 LISTADO DE PERSONAJES");
        System.out.println("==================================================");

        // %-5s (ID), %-25s (Nombre), %-10s (Nivel)
        System.out.printf("| %-5s | %-25s | %-10s |\n", "ID", "NOMBRE DEL HÉROE", "NIVEL");
        System.out.println("--------------------------------------------------");

        for (Personajes p : personajes) {
            System.out.printf("| %-5d | %-25s | %-10d |\n",
                    p.getId(),
                    p.getNombre(),
                    p.getNivel());
        }
        System.out.println("==================================================\n");
    }

    public void mostrarListaPersonajesOro(List<Personajes> personajes) {
        if (personajes == null || personajes.isEmpty()) {
            System.out.println("\n--- ⚠️ No hay personajes registrados en la Guild ---");
            return;
        }

        System.out.println("\n=========================================================");
        System.out.println("          💰 ESTADO FINANCIERO DE LA GUILD");
        System.out.println("=========================================================");

        // %-5s (ID), %-25s (Nombre), %-12s (Oro)
        System.out.printf("| %-5s | %-25s | %-12s |\n", "ID", "NOMBRE DEL HÉROE", "ORO (G)");
        System.out.println("---------------------------------------------------------");

        for (Personajes p : personajes) {
            // Formateamos el oro con una "G" de Gold o monedas
            String oroFormateado = p.getOro() + " G";

            System.out.printf("| %-5d | %-25s | %-12s |\n",
                    p.getId(),
                    p.getNombre(),
                    oroFormateado);
        }
        System.out.println("=========================================================\n");
    }

    public int pedirIdCiudadViaje(Personajes psel) {
        System.out.println("\n----------------------------------------------------------");
        System.out.println("📍 VIAJE RÁPIDO");
        mostrarMensaje("Héroe: " + psel.getNombre() + " (Nivel: " + psel.getNivel() + ")");
        mostrarMensaje("Introduce el ID de la ciudad a la que quieres viajar:");
        System.out.print("ID > ");

        int id = sc.nextInt();
        sc.nextLine(); // Limpiamos el buffer como en los anteriores
        return id;
    }

    public int pedirIdPersonaje() {
        mostrarMensaje("Dime que personaje quieres seleccionar (introducir el ID)");
        int opcion = sc.nextInt();
        sc.nextLine(); // Limpiar buffer
        return opcion;
    }

    public int pedirOpcionTienda() {
        mostrarMensaje("Elige objeto para comprar");
        int opcion = sc.nextInt();
        sc.nextLine(); // Limpiar buffer
        return opcion;
    }
    public int pedirIdHabilidad() {
        mostrarMensaje("Escoge la habilidad por ID (0 salir)");
        int opcion = sc.nextInt();
        sc.nextLine(); // Limpiar buffer
        return opcion;
    }

    public int pedirConfirmacion() {
        mostrarMensaje("Quieres seguir comprando? (0 si o 1 no)");
        int confirmacion = sc.nextInt();
        sc.nextLine(); // Limpiar buffer
        return confirmacion;
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

    public void mostrarListaCiudades(List<Ciudades> ciudades) {
        if (ciudades == null || ciudades.isEmpty()) {
            System.out.println("\n--- ⚠️ No hay ciudades descubiertas en el mapa ---");
            return;
        }

        System.out.println("\n==========================================================");
        System.out.println("                  🗺️ MAPA DE CIUDADES 🗺️");
        System.out.println("==========================================================");

        // %-5s (ID), %-25s (Nombre), %-15s (Nivel Mínimo)
        System.out.printf("| %-5s | %-25s | %-15s |\n",
                "ID", "NOMBRE DE CIUDAD", "NIVEL MÍNIMO");
        System.out.println("----------------------------------------------------------");

        for (Ciudades ciudad : ciudades) {
            System.out.printf("| %-5d | %-25s | %-15d |\n",
                    ciudad.getId(),
                    ciudad.getNombre(),
                    ciudad.getNivelMinimoAcceso());
        }
        System.out.println("==========================================================\n");
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

    public String pedirNombre() {
        mostrarMensaje("Dime el nombre para tu personaje");
        return sc.nextLine();
    }

    public int pedirIdRaza() {
        mostrarMensaje("Dime que raza quieres (escribe su id)");
        int id = sc.nextInt();
        sc.nextLine();
        return id;
    }

    public int pedirIdClase() {
        mostrarMensaje("Dime qué clase quieres (escribe su ID)");
        int id = sc.nextInt();
        sc.nextLine();
        return id;
    }

    public void mostrarListaClases(List<ClasesRPG> clases) {
        if (clases == null || clases.isEmpty()) {
            System.out.println("\n--- ⚠️ No hay clases disponibles ---");
            return;
        }

        System.out.println("\n==========================================================");
        System.out.println("                🛡️ CLASES DISPONIBLES 🛡️");
        System.out.println("==========================================================");

        // %-5s (ID), %-25s (Nombre), %-15s (Habilidades)
        System.out.printf("| %-5s | %-25s | %-15s |\n",
                "ID", "NOMBRE DE CLASE", "Nº HABILIDADES");
        System.out.println("----------------------------------------------------------");

        for (ClasesRPG clase : clases) {
            System.out.printf("| %-5d | %-25s | %-15d |\n",
                    clase.getId(),
                    clase.getNombre(),
                    clase.getListaHabilidades().size());
        }
        System.out.println("==========================================================\n");
    }

    public void mostrarListaPersonajesCompleta(List<Personajes> personajes) {
        if (personajes == null || personajes.isEmpty()) {
            System.out.println("\n--- ⚠️ No hay personajes registrados en la Guild ---");
            return;
        }

        System.out.println("\n=============================================================================");
        System.out.println("                 📜 REGISTRO GENERAL DE LA GUILD");
        System.out.println("=============================================================================");

        // %-5s (ID), %-20s (Nombre), %-10s (Oro), %-20s (Ciudad)
        System.out.printf("| %-5s | %-20s | %-10s | %-20s |\n", "ID", "NOMBRE", "ORO", "UBICACIÓN");
        System.out.println("-----------------------------------------------------------------------------");

        for (Personajes p : personajes) {
            // Gestionamos el Oro para que se vea bonito
            String oroTxt = p.getOro() + " G";

            // Gestionamos la Ciudad
            // Si p.getCiudadActual() devuelve el nombre (String), usamos esto:
            String ubicacion = (p.getCiudad() == null) ? "🚩 DESTERRADO" : p.getCiudad().getNombre();

            System.out.printf("| %-5d | %-20s | %-10s | %-20s |\n",
                    p.getId(),
                    p.getNombre(),
                    oroTxt,
                    ubicacion);
        }
        System.out.println("=============================================================================\n");
    }

    public void imprimirDestierro(String nombrePersonaje, String nombreCiudad) {
        System.out.printf("🚩 [DESTIERRO] | Personaje: %-15s | Ciudad: %-20s |\n",
                nombrePersonaje, nombreCiudad);
    }

    public void mostrarJugadoresRicos(List<Personajes> lista) {
        System.out.println("\n=========================================================");
        System.out.println("        🏆 TOP 3 JUGADORES MÁS RICOS (PODIO)");
        System.out.println("=========================================================");
        System.out.printf("| %-3s | %-25s | %-12s |\n", "POS", "NOMBRE DEL HÉROE", "FORTUNA (G)");
        System.out.println("---------------------------------------------------------");


        for (int i = 0; i < 3; i++) {
            // Importante: Comprobamos si existe el elemento para evitar errores
            // si la lista tiene menos de 3 personajes
            if (i < lista.size()) {
                Personajes p = lista.get(i);

                String posicion = "";
                if (i == 0) posicion = "🥇";
                else if (i == 1) posicion = "🥈";
                else posicion = "🥉";

                System.out.printf("| %-3s | %-25s | %-12s |\n",
                        posicion,
                        p.getNombre(),
                        p.getOro() + " G");
            }
        }

        System.out.println("=========================================================\n");
    }
    public void mostrarCenso(List<Personajes> listaPersonajes, Map<String,Integer> censo){
        // --- DISPLAY CON FORMATO ---
        System.out.println("\n=========================================================");
        System.out.println("          👥 CENSO POBLACIONAL POR CLASES");
        System.out.println("=========================================================");

        // %-30s (Clase), %-15s (Cantidad)
        System.out.printf("| %-30s | %-15s |\n", "TIPO DE CLASE", "Nº HABITANTES");
        System.out.println("---------------------------------------------------------");

        if (censo.isEmpty()) {
            System.out.println("| No hay datos de población disponibles.                |");
        } else {
            // Recorremos el mapa para imprimir cada fila
            for (Map.Entry<String, Integer> entrada : censo.entrySet()) {
                System.out.printf("| %-30s | %-15d |\n",
                        entrada.getKey(),
                        entrada.getValue());
            }
        }

        System.out.println("=========================================================");
        System.out.println(" TOTAL DE PERSONAJES REGISTRADOS: " + listaPersonajes.size());
        System.out.println("=========================================================\n");
    }
    public int mostrarMenuEstadisticas() {
        System.out.println("\n=========================================================");
        System.out.println("          📊 CENTRO DE ESTADÍSTICAS DE LA GUILD");
        System.out.println("=========================================================");
        System.out.println("1. Ver Censo de Personajes");
        System.out.println("2. Ver Top 3 Jugadores más Ricos");
        System.out.println("0. Volver al Menú Principal");
        System.out.println("---------------------------------------------------------");
        System.out.print("Seleccione una opción: ");

        while (!sc.hasNextInt()) {
            System.out.print("⚠️ Por favor, introduce un número válido: ");
            sc.next();
        }
        int opcion = sc.nextInt();
        sc.nextLine();

        return opcion;
    }
    public int mostrarMenuCombate() {
        System.out.println("\n=========================================================");
        System.out.println("          ⚔️ ACADEMIA DE GUERRA Y COMBATE");
        System.out.println("=========================================================");
        System.out.println("1. Gestionar Habilidades (Equipar/desequipar)");
        System.out.println("2. Iniciar Simulación de Combate");
        System.out.println("0. Volver al Menú Principal");
        System.out.println("---------------------------------------------------------");
        System.out.print("Seleccione una acción táctica: ");

        while (!sc.hasNextInt()) {
            System.out.print("⚠️ Entrada inválida. Use los números del menú: ");
            sc.next();
        }
        int opcion = sc.nextInt();
        sc.nextLine();
        return opcion;
    }
    public void mostrarHabilidadesPersonaje(Personajes personaje) {
        Map<Habilidades, Boolean> habilidades = personaje.getHabilidadesEquipadas();

        System.out.println("\n==============================================================");
        System.out.println("      ⚔️  HABILIDADES DE: " + personaje.getNombre().toUpperCase());
        System.out.println("==============================================================");

        // Ajustamos las columnas: ID (4), EST (5), NOMBRE (35)
        System.out.printf("| %-4s | %-5s | %-35s |\n", "ID", "EST.", "NOMBRE DE LA HABILIDAD");
        System.out.println("--------------------------------------------------------------");

        if (habilidades == null || habilidades.isEmpty()) {
            System.out.println("|      El personaje no tiene habilidades aprendidas.          |");
        } else {
            for (Map.Entry<Habilidades, Boolean> entrada : habilidades.entrySet()) {
                Habilidades hab = entrada.getKey();

                // Determinamos el símbolo según el valor booleano
                String estado = entrada.getValue() ? "[✔]" : "[ ]";

                // Sacamos el ID y el Nombre de la habilidad
                int idHabilidad = hab.getId(); // Asumiendo que Habilidades tiene getId()
                String nombreHabilidad = hab.getNombre();

                System.out.printf("| %-4d | %-5s | %-35s |\n",
                        idHabilidad,
                        estado,
                        nombreHabilidad);
            }
        }

        System.out.println("==============================================================");
        System.out.println(" CLASE: " + personaje.getClase().getNombre() + " | NIVEL: " + personaje.getNivel());
        System.out.println("==============================================================\n");
    }
    public void mostrarListaPersonajes(List<Personajes> listaPersonajes) {
        System.out.println("\n==========================================================================================================");
        System.out.println("                                     📜 REGISTRO DE AVENTUREROS");
        System.out.println("==========================================================================================================");

        // Definición de columnas:
        // %-3s (ID), %-15s (Nombre), %-5s (Nivel), %-10s (Raza), %-8s (Vida), %-8s (Oro), %-7s (Atq), %-7s (Def)
        System.out.printf("| %-3s | %-30s | %-5s | %-10s | %-8s | %-8s | %-7s | %-7s |\n",
                "ID", "NOMBRE", "LVL", "RAZA", "VIDA", "ORO", "ATQ", "DEF");
        System.out.println("----------------------------------------------------------------------------------------------------------");

        if (listaPersonajes.isEmpty()) {
            System.out.println("|                                No hay personajes registrados en el reino.                              |");
        } else {
            for (Personajes p : listaPersonajes) {
                System.out.printf("| %-3d | %-30s | %-5d | %-10s | %-8d | %-8d | %-7d | %-7d |\n",
                        p.getId(),
                        p.getNombre(),
                        p.getNivel(),
                        p.getRaza().getNombre(),
                        p.getVida_actual(),
                        p.getOro(),
                        p.getFuerzaTotal(),
                        p.getDefensaTotal()
                );
            }
        }

        System.out.println("==========================================================================================================");
        System.out.println(" TOTAL DE AVENTUREROS: " + listaPersonajes.size());
        System.out.println("==========================================================================================================\n");
    }

    // relacionados con el combate
    /* este es para el encabezado del combate */

    public void mensajeTurno(String nombre) {
        System.out.println("\n---------------------------------------------------------");
        System.out.println(" ⚔️  ES EL TURNO DE: " + nombre.toUpperCase());
        System.out.println("---------------------------------------------------------");
    }
    // esta va a devolver el id de la habilidad que escoge el personaje
    public int elegirHabilidadCombate(Personajes p, Map<Habilidades, Integer> usosRestantes) {
        System.out.println("Selecciona tu acción:");
        System.out.println("0. 👊 Ataque Básico (Sin límite de usos)");

        // Listamos las habilidades equipadas del personaje
        // El mapa habilidadesEquipadas contiene <Habilidad, Boolean>
        for (Map.Entry<Habilidades, Boolean> entrada : p.getHabilidadesEquipadas().entrySet()) {
            Habilidades hab = entrada.getKey();
            boolean estaEquipada = entrada.getValue();

            // Solo mostramos las que están marcadas como equipadas
            if (estaEquipada) {
                int usosActuales = usosRestantes.get(hab);
                System.out.printf("%d. %-20s (Usos: %d/%d) [Daño Base: %d]\n",
                        hab.getId(),
                        hab.getNombre(),
                        usosActuales,
                        hab.getUsosMaximos(),
                        hab.getDanioBase());
            }
        }

        System.out.print("\nIntroduce el ID de la habilidad: ");
        // Capturamos el ID que el usuario escribe
        int idSeleccionado = sc.nextInt();

        return idSeleccionado;
    }
    // mensaje de daño por una habilidad
    public void mensajeAtaqueHabilidad(String nombreHab, int dano) {
        System.out.println("\n   ✨ ¡" + nombreHab.toUpperCase() + "!");
        System.out.println("   💥 El impacto causa " + dano + " puntos de daño.");
        System.out.println("---------------------------------------------------------");
    }
    // mensaje de daño por un ataque basico
    public void mensajeAtaqueBasico(int dano) {
        System.out.println("\n   ⚔️  ¡ATAQUE FÍSICO!");
        System.out.println("   🤜 Golpeas al enemigo causando " + dano + " puntos de daño.");
        System.out.println("---------------------------------------------------------");
    }
    // mensaje de vida de los personajes
    public void mostrarVida(Personajes p1, Personajes p2) {
        System.out.println("\n         ❤️  ESTADO DE SALUD ❤️");
        System.out.println("---------------------------------------------------------");

        // usamos un operador ternario para que la vida no baje de 0 visualmente
        int vidaP1 = Math.max(0, p1.getVida_actual());
        int vidaP2 = Math.max(0, p2.getVida_actual());

        System.out.printf("| %-20s | HP: %4d puntos |\n", p1.getNombre(), vidaP1);
        System.out.printf("| %-20s | HP: %4d puntos |\n", p2.getNombre(), vidaP2);
        System.out.println("---------------------------------------------------------\n");
    }
    // mensaje para el ganador y perdedor del combate que muestra el oro que roba
    public void mensajeFinCombate(Personajes ganador, int oroRobado) {
        System.out.println("\n*********************************************************");
        System.out.println("             🏆 ¡VICTORIA FINAL! 🏆");
        System.out.println("*********************************************************");
        System.out.println("   EL GANADOR ES: " + ganador.getNombre().toUpperCase());
        System.out.println("   CLASE: " + ganador.getClase().getNombre());
        System.out.println("   NIVEL: " + ganador.getNivel());
        System.out.println("---------------------------------------------------------");
        System.out.println("   💰 BOTÍN DE GUERRA: " + oroRobado + " monedas de oro.");
        System.out.println("   El oro ha sido transferido y guardado con éxito.");
        System.out.println("*********************************************************\n");
    }
}