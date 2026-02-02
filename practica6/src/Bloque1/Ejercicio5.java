package Bloque1;

import java.util.HashMap;

public class Ejercicio5 {
    public static void main(String[] args){
        HashMap<String, Double> mercadoHechizos = new HashMap<>();
        mercadoHechizos.put("Espadas centelleantes", 80.0);
        mercadoHechizos.put("Bolita de fuego", 20.0);
        mercadoHechizos.put("Flecha abisal", 50.5);
        mercadoHechizos.put("Gravitón",120.20);
        for (String hechizo: mercadoHechizos.keySet()){
            if (mercadoHechizos.get(hechizo) >= 50) System.out.println(hechizo);
        }
    }
}
