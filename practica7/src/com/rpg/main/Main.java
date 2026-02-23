package com.rpg.main;

import com.rpg.model.Ciudades;
import com.rpg.model.Personajes;
import com.rpg.utils.JsonHelper;
import com.rpg.utils.TxtHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) throws IOException {
        TxtHelper txtHelper = new TxtHelper();
        txtHelper.cargarFichero("practica7/ficheros/ciudades.txt");
        JsonHelper jsonHelper = new JsonHelper();
        List<Personajes> personajes = jsonHelper.readlist("practica7/ficheros/personajes.json", Personajes.class);
        for (Personajes personaje: personajes){
            System.out.println(personaje.getNombre()+": "+personaje.getNivel());
        }
    }
}
