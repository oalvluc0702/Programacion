package Bloque3;

import java.util.HashMap;

public class Ejercicio12 {
    public static void desbloquearGolpeDivino(String claseRecibida,HashMap<String, HashMap<String, Boolean>> clase){
        if (clase.get(claseRecibida).get("Enfoque")){
            clase.get(claseRecibida).put("Golpe Divino",true);
            System.out.println("Se ha desbloqueado la habilidad correctamente");
            System.out.println(claseRecibida+": "+clase.get(claseRecibida).toString());
        } else {
            System.out.println("No se puede desbloquear la habilidad");
            System.out.println(claseRecibida+": "+clase.get(claseRecibida).toString());
        }
    }
    public static void main(String[] args){
        HashMap<String, HashMap<String, Boolean>> clase = new HashMap<>();
        HashMap<String, Boolean> habilidadesPaladin = new HashMap<>();
        HashMap<String, Boolean> habilidadesGuerrero = new HashMap<>();
        habilidadesPaladin.put("Enfoque", false);
        habilidadesPaladin.put("Golpe Divino", false);
        clase.put("Paladín", habilidadesPaladin);
        habilidadesGuerrero.put("Enfoque", true);
        habilidadesGuerrero.put("Golpe Divino", false);
        clase.put("Guerrero", habilidadesGuerrero);
        desbloquearGolpeDivino("Paladín",clase);
        desbloquearGolpeDivino("Guerrero", clase);
    }
}
