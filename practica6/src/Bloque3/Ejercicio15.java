package Bloque3;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Ejercicio15 {
    public static void procesarVenta(String item, HashMap<String, PriorityQueue<Puja>> subastas, HashMap<String, Double> saldoJugadores){
        //cogemos las pujas del item
        PriorityQueue<Puja> pujas = subastas.get(item);
        //si es nulo o esta vacío, no tiene pujas y sale del programa
        if (pujas == null || pujas.isEmpty()) {
            System.out.println("No hay pujas para " + item);
            return;
        }
        //mientras haya pujas seguirá el bucle intentando vender el objeto
        while (!pujas.isEmpty()){
            //cogemos la puja mas alta
            Puja masAlta = pujas.poll();
            //seleccionamos el jugador la cantidad y su sueldo
            String jugador = masAlta.getJugador();
            double cantidad = masAlta.getCantidad();
            //si no tiene sueldo le ponemos 0
            double saldoJugador = saldoJugadores.getOrDefault(jugador,0.0);
            //si el sueldo del jugador excede o es igual a la cantidad se le venderá el objeto
            if (saldoJugador >= cantidad){
                saldoJugadores.put(jugador,saldoJugador-cantidad);
                subastas.remove(item);
                System.out.println("La venta ha sido completada, el objeto "+ item+" se eliminará del mercado y será proporcionado al jugador "+jugador);
                return;
            } else {
                System.out.println("Puja descartada del jugador "+jugador+" por que no tiene saldo suficiente");
            }
        }
        System.out.println("Nadie pudo comprar el objeto, la subasta ha sido cancelada");
    }
    public static void pujar(String item, String jugador, double cantidad, HashMap<String, PriorityQueue<Puja>> subastas){
        subastas.putIfAbsent(item,new PriorityQueue<>((a,b) -> Double.compare(b.getCantidad(),a.getCantidad())));
        //añades una nueva puja a la cola de prioridades ordenada al revés del item
        subastas.get(item).add(new Puja(jugador,cantidad));
    }
    public static void main(String[] args){
        HashMap<String, PriorityQueue<Puja>> subastas = new HashMap<>();
        HashMap<String, Double> saldoJugadores = new HashMap<>();
        saldoJugadores.put("Oscar",80.5);
        saldoJugadores.put("Josemi",500.20);
        pujar("Espada","Oscar",40.5,subastas);
        pujar("Espada","Josemi",300.0,subastas);
        pujar("Piedra Filosofal","Oscar",200.0,subastas);
        System.out.println(subastas.toString());
        System.out.println(saldoJugadores.toString());
        procesarVenta("Espada",subastas,saldoJugadores);
        procesarVenta("Piedra Filosofal",subastas,saldoJugadores);
        System.out.println(saldoJugadores.toString());
    }
}
