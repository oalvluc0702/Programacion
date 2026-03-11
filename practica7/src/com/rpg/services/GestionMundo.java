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
import java.util.List;
import java.util.Scanner;

public class GestionMundo {
    private List<Personajes> personajes;
    private List<Items> objetos;
    private JsonHelper jsonHelper;
    private TxtHelper txtHelper;
    private List<Ciudades> ciudades;
    public GestionMundo() throws Exception {
        this.jsonHelper = new JsonHelper();
        this.txtHelper = new TxtHelper();
        cargarTodo();
        System.out.println(personajes.toString());
        System.out.println(ciudades.toString());
        System.out.println(objetos.toString());
        crearPersonaje(this.objetos);
        jsonHelper.writeList("practica7/ficheros/personajes.json",personajes);
    }

    public void cargarTodo() throws RPGDataException {
            this.personajes = jsonHelper.readlist("practica7/ficheros/personajes.json",Personajes.class);
            this.ciudades = txtHelper.cargarFicheroCiudades("practica7/ficheros/ciudades.txt");
            this.objetos = jsonHelper.readlist("practica7/ficheros/items.json", Items.class);
    }
    public void crearPersonaje(List<Items> objetos) throws Exception {
        String nombre;
        String raza;
        List<Items> items = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean finalizar = false;
        System.out.println("Dime el nombre de tu personaje");
        nombre = scanner.nextLine();
        System.out.println("Dime su raza");
        raza = scanner.nextLine();
        while(!finalizar){
            System.out.println("Dime el id del item");
            String idItem = scanner.nextLine();
            boolean existe = false;
            for (Items objeto: objetos){
                if (objeto.getId().equals(idItem)){
                    existe = true;
                    items.add(objeto);
                    break;
                }
            }
            if (!existe){
                System.out.println("Ese item no existe vuelve a intentarlo");
            } else {
                System.out.println("Item añadido perfectamente quieres añadir otro? 's' para continuar");
                if (!scanner.nextLine().equals("s")) finalizar = true;
            }
        }
        int nivel = -2;
        try{
            if (nivel < 0){
                throw new DatoInvalidoException("Personaje "+nombre+" nivel: "+nivel+" no permitido");
            }
            this.personajes.add(new Personajes(nombre,raza,nivel,items));
            System.out.println("Personaje añadido con éxito");
        } catch (DatoInvalidoException e){
            LoggerCustom.log("["+ LocalDateTime.now()+"] ERROR:"+ e.getClass().getSimpleName()+"- en "+e.getMessage());
            System.out.println("no se ha podido añadir el personaje");
        }

    }
}
