package com.rpg.services;

import com.rpg.handler.DatoInvalidoException;
import com.rpg.handler.RPGDataException;
import com.rpg.handler.RecursoNoEncontradoException;
import com.rpg.model.Ciudades;
import com.rpg.model.Items;
import com.rpg.model.Personajes;
import com.rpg.utils.JsonHelper;
import com.rpg.utils.LoggerCustom;
import com.rpg.utils.TxtHelper;

import java.time.LocalDateTime;
import java.util.*;

public class GestionMundo {
    private List<Personajes> personajes;
    private JsonHelper jsonHelper;
    private TxtHelper txtHelper;
    private List<Ciudades> ciudades;
    private HashMap<String, Items> catalogoItems;
    private HashMap<String, Ciudades> catalogoCiudad;
    // Constructor que se encarga de inicializar
    public GestionMundo() throws Exception {
        this.jsonHelper = new JsonHelper();
        this.txtHelper = new TxtHelper();
        this.catalogoItems = new HashMap<>();
        this.catalogoCiudad = new HashMap<>();
        cargarTodo();
        inicio();
    }

    public void cargarTodo() throws RPGDataException {
        //  Cargamos personajes y ciudades
        this.personajes = jsonHelper.readlist("practica7/ficheros/personajes.json", Personajes.class);
        this.ciudades = txtHelper.cargarFicheroCiudades("practica7/ficheros/ciudades.txt");
        //  Cargamos ítems y los metemos en el Mapa inmediatamente
        List<Items> listaItems = jsonHelper.readlist("practica7/ficheros/items.json", Items.class);
        for (Items item : listaItems) {
            this.catalogoItems.put(item.getId(), item);
        }
        for (Ciudades ciudad : ciudades ) {
            this.catalogoCiudad.put(ciudad.getNombre(), ciudad);
        }
        validar();
    }
    public void validar(){
        for (Personajes personaje: personajes){

            List<String> equiposId = personaje.getEquipoIds();

            try{
                for (String id : equiposId){
                    if (catalogoItems.containsKey(id)){
                        personaje.getEquipo().add(catalogoItems.get(id));
                        LoggerCustom.log("[" + LocalDateTime.now() + "] INFO: el equipo "+ catalogoItems.get(id).getNombre()+ " existe y se ha añadido correctamente");
                    } else {
                        personaje.getEquipoIds().remove(id);
                        throw new RecursoNoEncontradoException("objeto: "+id+"no encontrado se eliminará del personaje su identificador");
                    }
                }
            } catch (RecursoNoEncontradoException e){
                LoggerCustom.log("[" + LocalDateTime.now() + "] ERROR- "+e.getClass().getSimpleName()+" - "+e.getMessage());
            }
        }

        // asociar ciudades
        for (Personajes p : personajes) {
            if (catalogoCiudad.containsKey(p.getNombreCiudad())) {
                p.setCiudad(catalogoCiudad.get(p.getNombreCiudad()));
            } else {
                LoggerCustom.log("ERROR: Ciudad no encontrada para " + p.getNombre());
            }
        }

        // validar que humanos no puedan aparecer en el desierto que un arma de tipo hielo este en volcánico
        HashSet<Personajes> personajesAEliminar = new HashSet<>();
        try{
            for (Personajes personajeLista: personajes){
                if (personajeLista.getRaza().equalsIgnoreCase("humano") && personajeLista.getCiudad().getClima().equalsIgnoreCase("desierto")){
                    personajesAEliminar.add(personajeLista);
                    LoggerCustom.log("El clima no puede ser desierto cuando la raza es humana");
                    //throw new DatoInvalidoException("El clima no puede ser desierto cuando la raza es humana");
                }
            }
            for (Personajes personajeLista: personajes){
                List<Items> objetosPersonaje = personajeLista.getEquipo();
                String clima = personajeLista.getCiudad().getClima();
                for (Items item: objetosPersonaje){
                    if (item.getTipo().equalsIgnoreCase("hielo") && clima.equalsIgnoreCase("volcánico")){
                        personajesAEliminar.add(personajeLista);
                        LoggerCustom.log("Un objeto de tipo hielo no puede entrar en un volcánico");
                        //throw new DatoInvalidoException("Un objeto de tipo hielo no puede entrar en un volcánico");
                    }
                }
            }
        } catch (Exception e){
            LoggerCustom.log("[ "+LocalDateTime.now()+" ]"+"ERROR - "+e.getClass().getSimpleName()+" - "+e.getMessage());
        }
        // elimina los personajes
        for (Personajes personajeAEliminar: personajesAEliminar){
            personajes.remove(personajeAEliminar);
        }
    }
    public void crearPersonaje() {
        Scanner scanner = new Scanner(System.in);
        List<Items> itemsObjetos = new ArrayList<>();
        List<String> itemsIds = new ArrayList<>();

        System.out.println("Dime el nombre de tu personaje:");
        String nombre = scanner.nextLine();
        System.out.println("Dime su raza:");
        String raza = scanner.nextLine();

        boolean finalizar = false;
        while (!finalizar) {
            System.out.println("Dime el id del item:");
            String idItem = scanner.nextLine();

            Items objetoEncontrado = catalogoItems.get(idItem);

            if (objetoEncontrado == null) {
                System.out.println("Ese item no existe. Vuelve a intentarlo.");
            } else {
                itemsObjetos.add(objetoEncontrado);
                itemsIds.add(idItem);
                System.out.println("Añadido: " + objetoEncontrado.getNombre() + ". Otro 's' para continuar.");
                if (!scanner.nextLine().equalsIgnoreCase("s")) finalizar = true;
            }
        }

        System.out.println("Dime el nivel del personaje:");
        // uso parseInt para que no tenga problemas con saltos de líneas
        int nivel = Integer.parseInt(scanner.nextLine());
        Ciudades ciudad1 = new Ciudades("malaca",3000,"Desierto",2);
        ciudades.add(ciudad1);
        try {
            if (nivel < 0) {
                throw new DatoInvalidoException("Personaje " + nombre + " nivel: " + nivel + " no permitido");
            }

            // Creamos el personaje con la lista de los id de los objetos para el JSON
            Personajes nuevo = new Personajes(nombre, raza, nivel, itemsIds,"malaca");

            // Y le asignamos la lista de objetos que saca del HashMap
            nuevo.setEquipo(itemsObjetos);

            this.personajes.add(nuevo);
            System.out.println("Personaje " + nombre + " creado y equipado");

        } catch (DatoInvalidoException e) {
            LoggerCustom.log("[" + LocalDateTime.now() + "] ERROR: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void guardarCambios()  {
        jsonHelper.writeList("practica7/ficheros/personajes.json",personajes);
        LoggerCustom.log("[" + LocalDateTime.now() + "] INFO: Se han guardado los cambios correctamente");
    }
    public void listarCiudades(){

        System.out.printf("%-20s | %-10s | %-12s | %-10s%n", "Nombre", "Población", "Clima", "Riesgo");
        System.out.println("---------------------------------------------------------------");


        for (Ciudades c : ciudades) {
            System.out.printf("%-20s | %-10d | %-12s | %-10d%n",c.getNombre(),c.getPoblacion(),c.getClima(),c.getNivelRiesgo());
        }
    }
    public void listarPersonajes(){
        System.out.printf("%-15s | %-10s | %-8s | %s%n", "Nombre", "Raza", "Nivel", "Equipo");
        System.out.println("-------------------------------------------------------------------------");

        for (Personajes personaje : personajes) {
            // Creamos un String para guardar los nombres
            String nombresEquipo = "";

            // Recorremos la lista de objetos del personaje
            if (personaje.getEquipo() != null && !personaje.getEquipo().isEmpty()) {
                for (Items item : personaje.getEquipo()) {
                    nombresEquipo += item.getNombre() + ", ";
                }
                // Quitamos la última coma y espacio extra
                if (nombresEquipo.length() > 2) {
                    nombresEquipo = nombresEquipo.substring(0, nombresEquipo.length() - 2);
                }
            } else {
                nombresEquipo = "Vacío";
            }
            System.out.printf("%-15s | %-10s | %-8d | %s%n",personaje.getNombre(),personaje.getRaza(),personaje.getNivel(),nombresEquipo);
        }
    }
    public void listarObjetos(){
        System.out.printf("%-10s | %-20s | %-10s%n", "ID", "Nombre", "Valor");
        System.out.println("----------------------------------------------");


        for (Items item : catalogoItems.values()) {
            System.out.printf("%-10s | %-20s | %-10d%n",
                    item.getId(),
                    item.getNombre(),
                    item.getValor());
        }
    }
    public void inicio() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Crear Personaje");
            System.out.println("2. Listar Personajes");
            System.out.println("3. Listar Ciudades");
            System.out.println("4. Listar Objetos");
            System.out.println("5. Guardar Cambios");
            System.out.println("6. Salir y Guardar");
            System.out.print("Elige una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    crearPersonaje();
                    break;
                case "2":
                    listarPersonajes();
                    break;
                case "3":
                    listarCiudades();
                    break;
                case "4":
                    listarObjetos();
                    break;
                case "5":
                    guardarCambios();
                    break;
                case "6":
                    salir = true;
                    guardarCambios();
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}
