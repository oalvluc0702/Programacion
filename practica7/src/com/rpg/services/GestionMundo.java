package com.rpg.services;

import com.rpg.handler.DatoInvalidoException;
import com.rpg.handler.RPGDataException;
import com.rpg.model.Ciudades;
import com.rpg.model.Items;
import com.rpg.model.Personajes;
import com.rpg.utils.JsonHelper;
import com.rpg.utils.LoggerCustom;
import com.rpg.utils.TxtHelper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class GestionMundo {
    private List<Personajes> personajes;
    private JsonHelper jsonHelper;
    private TxtHelper txtHelper;
    private List<Ciudades> ciudades;
    private HashMap<String, Items> catalogoItems;
    public GestionMundo() throws Exception {
        this.jsonHelper = new JsonHelper();
        this.txtHelper = new TxtHelper();
        this.catalogoItems = new HashMap<>();
        cargarTodo();
        crearPersonaje();
        guardarCambios();
    }

    public void cargarTodo() throws RPGDataException {
        // 1. Cargamos personajes y ciudades
        this.personajes = jsonHelper.readlist("practica7/ficheros/personajes.json", Personajes.class);
        this.ciudades = txtHelper.cargarFicheroCiudades("practica7/ficheros/ciudades.txt");
        // 2. Cargamos ítems y los metemos en el Mapa inmediatamente
        List<Items> listaItems = jsonHelper.readlist("practica7/ficheros/items.json", Items.class);
        for (Items item : listaItems) {
            this.catalogoItems.put(item.getId(), item);
        }
    }
    public void crearPersonaje() throws Exception {
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

            // Búsqueda eficiente O(1) usando el mapa
            Items objetoEncontrado = catalogoItems.get(idItem);

            if (objetoEncontrado == null) {
                System.out.println("Ese item no existe. Vuelve a intentarlo.");
            } else {
                itemsObjetos.add(objetoEncontrado);
                itemsIds.add(idItem);
                System.out.println("Añadido: " + objetoEncontrado.getNombre() + ". ¿Otro? 's' para continuar.");
                if (!scanner.nextLine().equalsIgnoreCase("s")) finalizar = true;
            }
        }

        System.out.println("Dime el nivel del personaje:");
        // uso parseInt para que no tenga problemas con saltos de líneas
        int nivel = Integer.parseInt(scanner.nextLine());

        try {
            if (nivel < 0) {
                throw new DatoInvalidoException("Personaje " + nombre + " nivel: " + nivel + " no permitido");
            }

            // Creamos el personaje con la lista de IDs para el JSON
            Personajes nuevo = new Personajes(nombre, raza, nivel, itemsIds);

            // Y le asignamos la lista de objetos reales para el uso inmediato en Java
            nuevo.setEquipo(itemsObjetos);

            this.personajes.add(nuevo);
            System.out.println("¡Personaje " + nombre + " creado y equipado!");

        } catch (DatoInvalidoException e) {
            LoggerCustom.log("[" + LocalDateTime.now() + "] ERROR: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void guardarCambios() throws Exception {
        jsonHelper.writeList("practica7/ficheros/personajes.json",personajes);
        LoggerCustom.log("[" + LocalDateTime.now() + "] INFO: Se han guardado los cambios correctamente");
    }
}
