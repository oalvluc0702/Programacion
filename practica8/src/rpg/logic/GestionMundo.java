package rpg.logic;
import rpg.dao.*;
import rpg.exception.LimiteHabilidadesException;
import rpg.exception.NivelInsuficienteException;
import rpg.model.*;
import rpg.ui.Vista;
import rpg.exception.FondosInsuficientesException;
import rpg.utils.LoggerCustom;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
        
        int idPersonaje = vista.pedirIdPersonaje();
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
                            throw new FondosInsuficientesException("Oro insuficiente para comprar: " + item.getNombre()+ " al heroe: "+ pSel.getNombre()+" le faltan: "+ (item.getPrecioOro()-pSel.getOro())+ " G");
                        }

                        // le resta el oro de la compra
                        pSel.disminuirOro(item.getPrecioOro());
                        //updatea la base de datos con el oro actual del personaje
                        personajesDao.updateOro(idPersonaje, pSel.getOro());


                        // añade al inventario el objeto comprobando si existe para si en la base de datos tiene que actualizar o insertar
                        if (pSel.getInventario().containsKey(item)){
                            pSel.añadirInventario(item);
                            personajesDao.updateInventario(idPersonaje,idItem,pSel.getInventario().get(item));
                        } else {
                            pSel.añadirInventario(item);
                            personajesDao.insertInventario(idPersonaje,idItem,pSel.getInventario().get(item));
                        }

                        // realiza el mensaje de confirmación de compra en un futuro ira con el log
                        String mensajeLog = "El heroe: "+pSel.getNombre()+ " ha comprado " + item.getNombre() + " por una cantidad de: "+ item.getPrecioOro()+ " G";
                        vista.mostrarMensaje(mensajeLog);
                        LoggerCustom.log("[ "+ LocalDateTime.now() + " ]" + "INFO: "+ mensajeLog);

                    } catch (FondosInsuficientesException e) {
                        LoggerCustom.log("[ "+ LocalDateTime.now() + " ]" + "ERROR: "+ e.getMessage());
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
            case 4 -> cobrarImpuestos(personajesDao.getListaPersonajesConCiudad());
            case 5 -> gestionarHabilidadesYCombate();
            case 6 -> centroDeEstadisticas();
            case 0 -> vista.mostrarMensaje("Saliendo...");
            default -> vista.mostrarMensaje("Opción no válida");
        }
    }
    public void crearPersonaje(){
        vista.mostrarMensaje("\n--- BIENVENIDO A LA CREACION DE PERSONAJE ---");

        String nombre = vista.pedirNombre();

        vista.mostrarListaRazas(razasDao.getListaRazas());
        int idRaza = vista.pedirIdRaza();

        vista.mostrarListaClases(clasesRPGDao.getListaClases());
        int idClase = vista.pedirIdClase();
        personajesDao.insertPersonaje(nombre,idRaza,idClase,razasDao,clasesRPGDao,ciudadesDao);

    }
    public void viajarACiudad(){
        vista.mostrarMensaje("\n-- CON QUE PERSONAJE QUIERES VIAJAR? ---");

        vista.mostrarListaPersonajesNivel(personajesDao.getListaPersonajes());
        int idPersonaje = vista.pedirIdPersonaje();

        Personajes psel = personajesDao.buscarPorId(idPersonaje);
        vista.mostrarListaCiudades(ciudadesDao.getListaCiudades());

        int idCiudad = vista.pedirIdCiudadViaje(psel);
        Ciudades ciudad = ciudadesDao.buscarPorId(idCiudad);

        try {
            if (ciudad.puedeViajar(psel)){
                personajesDao.updateCiudad(idCiudad,idPersonaje);
                psel.setCiudad(ciudad);
                vista.mostrarMensaje("Se ha viajado correctamente a la ciudad: "+ ciudad.getNombre());
            } else{
                throw new NivelInsuficienteException("El nivel no es suficiente, tu nivel es: "+psel.getNivel()+" y se requiere: "+ciudad.getNivelMinimoAcceso());
            }
        } catch (NivelInsuficienteException e) {
            LoggerCustom.log("[ "+ LocalDateTime.now() + " ]" + "ERROR: "+ e.getMessage());
            System.out.println(e.getMessage());
        }
    }
    public void centroDeEstadisticas(){
        int opcion = vista.mostrarMenuEstadisticas();
        switch (opcion){
            case 1 -> censo();
            case 2 -> top3JugadoresMasRicos();
            case 0 -> vista.mostrarMensaje("Saliendo del centro de estadísticas");
            default -> vista.mostrarMensaje("Opción no válida");
        }
    }
    public void censo(){
        Map<String, Integer> censo = new HashMap<>();
        List<Personajes> listaPersonajes = personajesDao.getListaPersonajes();
        for (Personajes personaje: listaPersonajes){
            censo.put(personaje.getClase().getNombre(),censo.getOrDefault(personaje.getClase().getNombre(),0)+1);
        }
        vista.mostrarCenso(listaPersonajes,censo);
    }
    public void cobrarImpuestos(List<Personajes> listaPersonajesConCiudad){
        Iterator<Personajes> personajesIterator = listaPersonajesConCiudad.iterator();
        while(personajesIterator.hasNext()){
            // conseguimos el personaje
            Personajes personaje = personajesIterator.next();
            // guardamos su id por comodidad
            int idPersonaje= personaje.getId();
            // guardamos tambien su nombre de ciudad antes de desterrarlos
            String nombreCiudad = personaje.getCiudad().getNombre();
            // le disminuimos el oro cobrandole el impuesto
            personaje.disminuirOro(20);
            personajesDao.updateOro(idPersonaje,personaje.getOro());
            // aqui comprobamos si tiene el oro negativo y lo desterramos poniendo su ciudad a null tanto en memoria como en la base de datos
            if (personaje.getOro()<0){
                personaje.setCiudad(null);
                personajesDao.updateCiudad(null,idPersonaje);
                //imprime que ha desterrado a alguien
                vista.imprimirDestierro(personaje.getNombre(),nombreCiudad);
                //lo eliminamos del iterator de personajes con ciudad
                personajesIterator.remove();
            }
        }
    }
    public void top3JugadoresMasRicos(){
        List<Personajes> personajesRicos = personajesDao.getListaPersonajes();
        personajesRicos.sort((p1, p2) -> Integer.compare(p2.getOro(), p1.getOro()));
        vista.mostrarJugadoresRicos(personajesRicos);
    }
    public void gestionarHabilidadesYCombate(){
        int opcion;

        do {
            opcion = vista.mostrarMenuCombate();
            switch (opcion){
                case 1 -> organizarHabilidades();
                case 2 -> organizarCombate();
                case 0 -> vista.mostrarMensaje("Volviendo al menú anterior");
                default -> vista.mostrarMensaje("Opción no válida");
            }
        } while (opcion!=0);

    }
    public void organizarHabilidades(){
        vista.mostrarListaPersonajes(personajesDao.getListaPersonajes());
        int idPersonaje = vista.pedirIdPersonaje();
        Personajes pSel = personajesDao.buscarPorId(idPersonaje);
        int opcion;

        do {
            vista.mostrarHabilidadesPersonaje(pSel);
            opcion = vista.pedirIdHabilidad();
            if (opcion != 0){
                try{
                    pSel.equiparDesequiparHabilidad(habilidadDao.buscarPorId(opcion),personajesDao);
                } catch (LimiteHabilidadesException e){
                    LoggerCustom.log("[ "+ LocalDateTime.now() + " ]" + "ERROR: "+ e.getMessage());
                }
            }
        } while (opcion != 0);
    }
    public void organizarCombate(){
        vista.mostrarListaPersonajes(personajesDao.getListaPersonajes());
        int idPersonaje1 = vista.pedirIdPersonaje();
        int idPersonaje2 = vista.pedirIdPersonaje();
        Personajes personaje1 = personajesDao.buscarPorId(idPersonaje1);
        Personajes personaje2 = personajesDao.buscarPorId(idPersonaje2);
        MotorCombate combate = new MotorCombate(personaje1,personaje2,vista,personajesDao,habilidadDao);
    }
    public void  procesarRitual(List<Personajes> expedicion, int idClaseEvolucionada){
        Iterator<Personajes> personajesIterator = expedicion.iterator();
        while (personajesIterator.hasNext()){
            Personajes personaje = personajesIterator.next();
            if(personaje.contarHabilidadesEquipadas() == 3){

                if (personaje.contarObjetos() > 5){
                    // ejecuta la evolucion
                    ejecutarEvolucion(personaje,idClaseEvolucionada);
                } else {
                    if (personaje.getVida_actual() < personaje.getRaza().getBonificadorVida() * 0.1){
                        personajesDao.updateCiudad(null,personaje.getId());
                        //desterrar
                        personajesIterator.remove();
                    }
                }
            }
        }
    }
    public void ejecutarEvolucion(Personajes personaje, int idClaseEvolucionada){
        personaje.setClase(clasesRPGDao.buscarPorId(idClaseEvolucionada));
        personaje.disminuirOro(50);
        personajesDao.updateOro(personaje.getId(),personaje.getOro());
        personajesDao.updateClase(personaje.getId(),idClaseEvolucionada);
    }
}