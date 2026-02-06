package Bloque2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Ejercicio10 {
    public static void mostrarGremio(HashMap<String, ArrayList<String>> repositorio, String gremio){
        for(String miembro: repositorio.get(gremio)){
            System.out.println(miembro);
        }
    }
    public static void buscarAventureroEliminar(HashMap<String, ArrayList<String>> repositorio, String aventurero){
            for (String gremio: repositorio.keySet()){
                repositorio.get(gremio).remove(aventurero);
            }
    }
    public static void main(String[] args){

            HashMap<String, ArrayList<String>> repositorioGremial = new HashMap<>();
            ArrayList<String> magos = new ArrayList<>();
            ArrayList<String> guerreros = new ArrayList<>();
            magos.add("Oscar");
            magos.add("Mario");
            magos.add("Gandalf");
            guerreros.add("Percival");
            magos.add("Judas");
            guerreros.add("Vane");
            guerreros.add("Narmaya");
            repositorioGremial.put("magos",magos);
            repositorioGremial.put("guerreros",guerreros);
            buscarAventureroEliminar(repositorioGremial, "Judas");
            System.out.println(repositorioGremial.entrySet());
    }
}
