package Bloque1;


import java.util.HashSet;

public class Ejercicio6 {
    public static void main(String[] args){
        HashSet<String> censoVillanos = new HashSet<>();
        censoVillanos.add("Morgott");
        censoVillanos.add("Morgott");
        censoVillanos.add("Barba negra");
        censoVillanos.add("Pedro sanchez");
        censoVillanos.add("Sauron");
        censoVillanos.remove("Sauron");
        System.out.println(censoVillanos.toString());
    }
}
