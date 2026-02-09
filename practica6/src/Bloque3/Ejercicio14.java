package Bloque3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Ejercicio14 {
    public static void analizarMensajes(HashMap<String, ArrayList<String>> historialMensajes, HashSet<String> jugadoresSilenciados){
        for (String jugadores: historialMensajes.keySet()){
            ArrayList<String> mensajes = historialMensajes.get(jugadores);
            HashSet<String> comprobarMensajes = new HashSet<>();
            if (mensajes.size() < 3){
                System.out.println(jugadores+": No tiene suficientes mensajes para poder analizar");
                continue;
            }else {
                for (int i = mensajes.size()-1; i >= mensajes.size()-3 ; i--) {
                    comprobarMensajes.add(mensajes.get(i));
                }
                if (comprobarMensajes.size() !=3){
                    jugadoresSilenciados.add(jugadores);
                    mensajes.clear();
                }
            }
        }
    }
    public static void main(String[] args){
        HashMap<String, ArrayList<String>> historialMensajes = new HashMap<>();
        HashSet<String> jugadoresSilenciados = new HashSet<>();
        historialMensajes.put("Mario", new ArrayList<>(List.of("hola","como estás","hola","listo")));
        historialMensajes.put("Oscar", new ArrayList<>(List.of("hola","bien","bien","no")));
        analizarMensajes(historialMensajes,jugadoresSilenciados);
        System.out.println("Jugadores Silenciados: "+ jugadoresSilenciados.toString());
        System.out.println("Mario: "+ historialMensajes.get("Mario").toString());
        System.out.println("Óscar"+ historialMensajes.get("Oscar").toString());
    }
}
