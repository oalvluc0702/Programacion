package com.rpg.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class LoggerCustom {
    public static void log(String mensaje) throws Exception {
        String path = "practica7/ficheros/errores.log";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))){
            writer.write(mensaje);
            writer.newLine();
        } catch (Exception e){
            throw new Exception("No se ha podido escribir los errores");
        }
    }
}
