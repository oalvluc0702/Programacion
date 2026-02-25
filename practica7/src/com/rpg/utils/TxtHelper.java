package com.rpg.utils;

import com.rpg.handler.RPGDataException;
import com.rpg.handler.RecursoNoEncontradoException;
import com.rpg.model.Ciudades;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TxtHelper {
    public TxtHelper() {
    }

    public List<Ciudades> cargarFicheroCiudades(String path) throws RPGDataException {
         try{
             List<String> lineas = Files.readAllLines(Paths.get(path));
             List<Ciudades> listaCiudad = new ArrayList<>();
             for (String linea: lineas){
                 String[] splited = linea.split(";");
                 String nombre = splited[0];
                 Integer poblacion = Integer.parseInt(splited[1]);
                 String clima = splited[2];
                 Integer riesgo = Integer.parseInt(splited[3]);
                 listaCiudad.add(new Ciudades(nombre,poblacion,clima,riesgo));
             }
             return listaCiudad;
         } catch (IOException e){
             throw new RecursoNoEncontradoException("No se ha encontrado el archivo");
         }
    }
}
