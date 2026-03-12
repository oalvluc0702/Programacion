package com.rpg.utils;

import com.rpg.handler.FormatoInvalidoException;
import com.rpg.handler.RPGDataException;
import com.rpg.handler.RecursoNoEncontradoException;
import com.rpg.model.Ciudades;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TxtHelper {
    public TxtHelper() {
    }

    public List<Ciudades> cargarFicheroCiudades(String path) throws RPGDataException {
        List<Ciudades> listaCiudad = new ArrayList<>();

        try {
            List<String> lineas = Files.readAllLines(Paths.get(path));

            for (String linea : lineas) {
                // para poder saltar líneas vacías o comentarios
                if (linea.trim().isEmpty() || linea.startsWith("#")) continue;

                try {
                    String[] splited = linea.split(";");

                    // comprobar que tenga 4 campos
                    if (splited.length < 4) {
                        throw new FormatoInvalidoException("Se esperaban 4 campos, se encontraron " + splited.length);
                    }

                    // 2. pasar el string a numero, pero si el dato está mal puede dar una excepción de formato de numero
                    String nombre = splited[0].trim();
                    Integer poblacion = Integer.parseInt(splited[1].trim());
                    String clima = splited[2].trim();
                    Integer riesgo = Integer.parseInt(splited[3].trim());

                    listaCiudad.add(new Ciudades(nombre, poblacion, clima, riesgo));

                } catch (FormatoInvalidoException | NumberFormatException e) {
                    // cogemos cualquier de las 2 excepciones la de formato o la de numero
                    LoggerCustom.log("[" + LocalDateTime.now() + "] ERROR: " + e.getClass().getSimpleName()
                            + " en Ciudad: Línea saltada: '" + linea + "'. Causa: " + e.getMessage());
                }
            }
            return listaCiudad;

        } catch (IOException e) {
            // el archivo no existe
            LoggerCustom.log("[" + LocalDateTime.now() + "] ERROR: No se ha encontrado el archivo "+path+" error crítico");
            throw new RecursoNoEncontradoException("No se ha encontrado el archivo: " + path);
        }
    }
}
