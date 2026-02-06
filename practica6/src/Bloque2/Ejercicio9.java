package Bloque2;

import java.util.HashMap;
import java.util.HashSet;

public class Ejercicio9 {
    public static void main(String[] args){
           HashMap<String, HashMap<String, Integer>> jugadores = new HashMap<>();
           HashMap<String, Integer> estadisticasConan = new HashMap<>();
           estadisticasConan.put("Fuerza", 5);
           estadisticasConan.put("Destreza",5);
           estadisticasConan.put("Inteligencia",5);
           estadisticasConan.put("Vida",200);
           jugadores.put("Conan", estadisticasConan);
           Integer fuerzaNueva = jugadores.get("Conan").get("Fuerza")+2;
           jugadores.get("Conan").put("Fuerza",fuerzaNueva);
           System.out.println(jugadores.get("Conan"));
    }
}
