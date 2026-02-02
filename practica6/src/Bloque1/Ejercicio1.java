package Bloque1;

import java.util.ArrayList;

public class Ejercicio1 {
    public static void main(String[] args){
        ArrayList<String> eventos = new ArrayList<>();
        eventos.add("Pocion usada");
        eventos.add("paladin muerto");
        eventos.add("gremio creado");
        eventos.add("personaje creado");
        eventos.add("Óscar ataca a Mario");
        System.out.println(eventos.get(2));
    }
}
