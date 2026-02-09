package Bloque3;

import java.util.ArrayList;
import java.util.HashMap;

public class Ejercicio11 {
    public static void transaccion(HashMap<String, ArrayList<String>> ciudadesStock, String ciudad, HashMap<String, Double> itemsPrecio){
        if (ciudadesStock.get(ciudad).size() >= 5){
            System.out.println("Se ha aplicado el impuesto de lujo");
            for (String item : itemsPrecio.keySet()){
                if (ciudadesStock.get(ciudad).contains(item)) {
                    Double montoTotal = itemsPrecio.get(item) * 1.10;
                    System.out.println(item+": "+montoTotal);
                }
            }
        } else {
            for (String item : itemsPrecio.keySet()){
                if (ciudadesStock.get(ciudad).contains(item)) {
                    System.out.println(item + ": " + itemsPrecio.get(item));
                }
            }
        }
    }
    public static void main(String[] args){
        HashMap<String, Double> itemsPrecio = new HashMap<>();
        HashMap<String, ArrayList<String>> ciudadesStock = new HashMap<>();
        itemsPrecio.put("Espada",40.0);
        itemsPrecio.put("Arco",50.0);
        itemsPrecio.put("Poción",10.0);
        itemsPrecio.put("Cuerda",30.0);
        itemsPrecio.put("Escudo",20.0);
        itemsPrecio.put("Poción de Fuerza",70.5);
        ArrayList<String> phandalin = new ArrayList<>();
        phandalin.add("Espada");
        phandalin.add("Arco");
        phandalin.add("Poción");
        phandalin.add("Cuerda");
        phandalin.add("Escudo");
        ciudadesStock.put("Phandalin",phandalin);
        transaccion(ciudadesStock,"Phandalin",itemsPrecio);
    }
}
