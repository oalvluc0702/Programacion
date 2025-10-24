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
        //Ahora vamos a crear el algoritmo de ordenación para la lista, primero definimos las variables que controlan que se compara
        int valorActual=0;
        int valorFuturo=0;
        //Ahora un bucle que vaya recorriendo un array hasta que el contador sea la longitud de la lista -1 indice
        for (int i = 0; i < lista.size()-1; i++) {
            //ponemos que el valoractual sea el elemento del contador de la lista
            valorActual=lista.get(i);
            //el valor futuro es el elemento del contador de la lista + 1 indice para que compare el que viene
            valorFuturo=lista.get(i+1);
            //si el valor actual es mayor que el valor futuro se añade el valor futuro a la lista y elimina el índice del que estaba comparando
            if (valorActual > valorFuturo){
                lista.add(valorActual);
                lista.remove(i);
                //ahora reiniciamos el valor del bucle para que vuelva a comparar desde el principio ponemos -1 porque al acabar el bucle el propio bucle añade 1 al contador
                i=-1;
            }
        }
        //Mostramos por pantalla la lista ordenada
        System.out.println(lista);
    }
}

