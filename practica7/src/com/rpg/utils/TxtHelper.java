package com.rpg.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TxtHelper {
    public TxtHelper() {
    }

    public void cargarFichero(String path) throws IOException {
         try{
             List<String> lineas = Files.readAllLines(Paths.get(path));
             for (String linea: lineas){
                 System.out.println(linea);
             }
         } catch (IOException e){
             System.out.println("no se ha encontrado el archivo");
         }
    }
}
