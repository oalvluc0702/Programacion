package Bloque3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Ejercicio13 {
    public static String encontrarMvp(HashMap<String, ArrayList<HashSet<String>>> historial){
        //mapa para contar participaciones
        HashMap<String, Integer> contador = new HashMap<>();

        //recorrer todas las mazmorras
        for (String mazmorra: historial.keySet()){
            ArrayList<HashSet<String>> raids = historial.get(mazmorra);

            //recorrer las raids
            for (HashSet<String> raid: raids){

                //recorrer los jugadores de cada raid y añadirlos como contador, el valor será 0 si no hay
                for (String jugador : raid){
                    contador.put(jugador, contador.getOrDefault(jugador,0)+1);
                }
            }
        }
        String mvp = null;
        int maxParticipaciones = 0;

        for (String jugador: contador.keySet()){
            int participaciones = contador.get(jugador);

            if (participaciones>maxParticipaciones){
                maxParticipaciones = participaciones;
                mvp = jugador;
            }
        }
        return "El mvp es: "+mvp;
    }
    public static void main(String[] args){
        HashMap<String, ArrayList<HashSet<String>>> historial = new HashMap<>();
        //raids
        HashSet<String> raid1 = new HashSet<>(List.of("Óscar","Mario","Josemi"));
        HashSet<String> raid2 = new HashSet<>(List.of("Óscar","Mario"));
        HashSet<String> raid3 = new HashSet<>(List.of("Óscar","Josemi"));
        ArrayList<HashSet<String>> mazmorraCelestial = new ArrayList<>();
        mazmorraCelestial.add(raid1);
        mazmorraCelestial.add(raid2);
        ArrayList<HashSet<String>> mazmorraTerrestre = new ArrayList<>();
        mazmorraTerrestre.add(raid3);
        historial.put("Mazmorra celestial",mazmorraCelestial);
        historial.put("Mazmorra terrestre",mazmorraTerrestre);
        // para mostrar el mvp
        System.out.println(encontrarMvp(historial));
    }
}
