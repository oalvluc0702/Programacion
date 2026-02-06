package Bloque2;

import java.sql.Array;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.HashMap;

public class Ejercicio7 {
    public static void mostrarGremio(HashMap<String, ArrayList<String>> repositorio, String gremio){
        for(String miembro: repositorio.get(gremio)){
            System.out.println(miembro);
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
        guerreros.add("Vane");
        guerreros.add("Narmaya");
        repositorioGremial.put("magos",magos);
        repositorioGremial.put("guerreros",guerreros);
        mostrarGremio(repositorioGremial, "magos");
    }
}
