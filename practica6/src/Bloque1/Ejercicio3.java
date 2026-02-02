package Bloque1;

import java.util.HashMap;


public class Ejercicio3 {
    public static void main(String[] args){
        HashMap<String, Integer> bolsaOro = new HashMap<>();
        bolsaOro.put("Mario", 500);
        bolsaOro.put("Óscar", 1000000);
        bolsaOro.put("Pedro Sánchez", 700000000);
        System.out.println(bolsaOro.get("Pedro Sánchez"));
    }
}
