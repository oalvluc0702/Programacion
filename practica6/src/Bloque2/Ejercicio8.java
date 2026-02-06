package Bloque2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Ejercicio8 {
    public static void main(String[] args){
           HashMap<String, HashSet<String>> monstruoLoot = new HashMap<>();
           HashSet<String> trasgo = new HashSet<>();
           trasgo.add("Espada Oxidada");
           trasgo.add("Ropaje Viejo");
           trasgo.add("Oreja Duende");
           trasgo.add("Espada Oxidada");
           HashSet<String> dragon = new HashSet<>();
           dragon.add("Escama de Dragón");
           dragon.add("Ojo de Dragón");
           dragon.add("Lanza del Matadragones");
           monstruoLoot.put("trasgo", trasgo);
           monstruoLoot.put("dragon", dragon);
           monstruoLoot.get("dragon").add("Lanza del Matadragones");
           for (String monstruo: monstruoLoot.keySet()){
               System.out.println(monstruo+ ": "+ monstruoLoot.get(monstruo));
           }
    }
}
