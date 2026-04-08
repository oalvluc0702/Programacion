package rpg.logic;
import rpg.dao.*;
import rpg.model.*;
import rpg.ui.Vista;
import rpg.exception.FondosInsuficientesException;
import java.util.List;

public class GestionMundo {
    private Vista vista;
    private CiudadesDao ciudadesDao;
    private ItemsDao itemsDao;
    private RazasDao razasDao;
    private ClasesRPGDao clasesRPGDao;
    private HabilidadDao habilidadDao;
    private PersonajesDao personajesDao;

    public GestionMundo() {
        this.vista = new Vista();
        
        // 1. Instanciar DAOs maestros (se cargan solos en su constructor)
        this.ciudadesDao = new CiudadesDao();
        this.itemsDao = new ItemsDao();
        this.razasDao = new RazasDao();
        this.habilidadDao = new HabilidadDao();
        this.clasesRPGDao = new ClasesRPGDao(habilidadDao);

        // 2. Instanciar PersonajesDao y cargarlo manualmente pasándole los otros
        this.personajesDao = new PersonajesDao(itemsDao, habilidadDao);
        personajesDao.cargarPersonajes(ciudadesDao, razasDao, clasesRPGDao);

        iniciar();
    }

    public void irALaTienda() {
        vista.mostrarMensaje("\n--- 💰 BIENVENIDO A LA TIENDA ---");
        
        // Obtenemos la lista del DAO
        List<Personajes> lista = personajesDao.getListaPersonajes();
        vista.mostrarListaPersonajesResumida(lista);
        
        int idPersonaje = vista.pedirOpcion();
        Personajes pSel = personajesDao.buscarPorId(idPersonaje);

        if (pSel != null) {
            boolean salir = false;
            do {
                vista.mostrarListaItems(itemsDao.getListaItems());
                int idItem = vista.pedirOpcionTienda();
                Items item = itemsDao.buscarPorId(idItem);

                if (item != null) {
                    try {
                        if (pSel.getOro() < item.getPrecioOro()) {
                            throw new FondosInsuficientesException("Oro insuficiente");
                        }
                        // Lógica de compra...
                    } catch (FondosInsuficientesException e) {
                        vista.mostrarMensaje(e.getMessage());
                    }
                }
                if (vista.pedirConfirmacion() != 0) salir = true;
            } while (!salir);
        }
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
            case 0 -> vista.mostrarMensaje("Saliendo...");
            default -> vista.mostrarMensaje("Opción no válida");
        }
    }
    public void crearPersonaje(){

    }
    public void viajarACiudad(){

    }
}