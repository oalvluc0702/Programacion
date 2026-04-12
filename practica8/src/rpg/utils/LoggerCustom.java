package rpg.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;

public class LoggerCustom {
    public static void log(String mensaje) {
        String path = "practica8/ficheros/info.log";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write(mensaje);
            writer.newLine();
        } catch (Exception e) {
            // En lugar de llamar a log(), usamos la salida de error estándar
            System.out.println("[" + LocalDateTime.now() + "] ERROR: No se pudo escribir en el log.");
            System.out.println("Causa original: " + e.getMessage());
        }
    }
}
