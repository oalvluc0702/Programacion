import java.util.ArrayList;
import java.util.Scanner;

//Ejercicio 15
/*Crea un programa que:
Cree una lista de enteros (ArrayList<Integer>).
Pida al usuario 10 números enteros y los añada a la lista.
Elimine los valores duplicados manteniendo solo el primero que apareció.
Ordene la lista de menor a mayor y la muestre por pantalla. */

public class ejercicio15 {
    public static void main(String[] args){
        //Primero definimos la Clase Scanner y el Array list con la que vamos a trabajar los números
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<>();

        //con este bucle metemos los números introducidos por pantalla en la lista
        for (int i = 0; i <= 9; i++) {
            System.out.println("Dime un número por pantalla");
            int num = s.nextInt();
            lista.add(num);
        }
        //con este bucle anidado vamos recorriendo los elementos de la lista comparando si son iguales que los posteriores
        //si encuentra alguno entonces elimina el elemento de la lista y retrocede un índice para seguir recorriendo la lista sin pasarse del índice
        for (int k = 0; k < lista.size(); k++) {
            for (int l = 1; l < lista.size(); l++) {
                if (lista.get(k).equals(lista.get(l)) && k != l){
                    lista.remove(l);
                    l--;
                }
            }
        }
        //con el metodo .sort() le pasamos el parametro null que es para dejar el comparador al orden natural (menor a mayor)
        lista.sort(null);
        //mostramos la lista por pantalla
        System.out.println(lista);
    }
}
