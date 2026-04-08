package rpg.logic;

import rpg.dao.*;
import rpg.exception.FondosInsuficientesException;
import rpg.model.*;
import rpg.ui.Vista;

import java.util.ArrayList;
import java.util.List;

public class GestionMundo {
    //utilidad
    private Vista vista;
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
        vista = new Vista();
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
        cargarTodo();

        iniciar();

    }
    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenuPrincipal();
            manejarOpcion(opcion);
        } while (opcion != 0);
    }

    public void manejarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> crearPersonaje();
            case 2 -> viajarACiudad();
            case 3 -> irALaTienda();
            case 4 -> ejecutarCobroImpuestos();
            case 5 -> gestionarCombate();
            case 6 -> mostrarEstadisticas();
            case 0 -> vista.mostrarMensaje("Guardando partida y saliendo...");
            default -> vista.mostrarMensaje("⚠️ Opción no válida. Inténtalo de nuevo.");
        }
    }

    // --- MÉTODOS PÚBLICOS DE ACCIÓN ---

    public void crearPersonaje() {
        vista.mostrarMensaje("\n--- ✨ FORJANDO UN NUEVO HÉROE ---");
        // Aquí llamarías a: vista.pedirDatos(), luego dao.guardar()
    }

    public void viajarACiudad() {
        vista.mostrarMensaje("\n--- 🧭 PREPARANDO EL VIAJE ---");
        // Aquí listarías ciudades y actualizarías la ubicación del personaje
    }

    public void irALaTienda() {
        vista.mostrarMensaje("\n--- 💰 BIENVENIDO A LA TIENDA DE LA GUILD ---");
        vista.mostrarMensaje("Con que personaje quieres comprar?");
        vista.mostrarListaPersonajesResumida(listaPersonajes);
        int idPersonaje = vista.pedirOpcion();
        Personajes personajeSeleccionado = null;

        for (Personajes personaje : listaPersonajes){
            if (personaje.getId() == idPersonaje) personajeSeleccionado = personaje;
        }

        boolean salir = false;

        do {
            vista.mostrarListaItems(listaItems);
            int idObjeto = vista.pedirOpcionTienda();

            for (Items objeto : listaItems){

                try {
                    if (objeto.getId() == idObjeto){
                        int precio = objeto.getPrecioOro();
                        if (personajeSeleccionado.getOro()<precio) throw new FondosInsuficientesException("No hay fondos suficientes");
                    }
                } catch (FondosInsuficientesException e) {
                    vista.mostrarMensaje("No hay fondos suficientes");
                }
            }

            if (vista.pedirConfirmacion() != 0) salir = true;
        } while(!salir);
        // Aquí mostrarías items disponibles para comprar
    }

    public void ejecutarCobroImpuestos() {
        vista.mostrarMensaje("\n--- ⚖️ MANTENIMIENTO: COBRO DE IMPUESTOS ---");
        // Aquí restarías oro a todos los personajes o harías limpieza de BD
    }

    public void gestionarCombate() {
        vista.mostrarMensaje("\n--- ⚔️ GESTIÓN DE HABILIDADES Y COMBATE ---");
        // Aquí permitirías equipar habilidades o iniciar una simulación
    }

    public void mostrarEstadisticas() {
        vista.mostrarMensaje("\n--- 📊 CENTRO DE ESTADÍSTICAS ---");
        // Aquí mostrarías el top de jugadores, oro total en el mundo, etc.
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
