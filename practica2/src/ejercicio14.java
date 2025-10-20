import java.util.ArrayList;
import java.util.Scanner;

//Ejercicio 14
/*Crea un programa que:
Cree una lista de Strings (ArrayList<String>).
Pida al usuario nombres por teclado hasta que introduzca la palabra "fin".
Luego pida un nombre a buscar y diga si está en la lista o no, mostrando también en
qué posición se encuentra si existe.*/

public class ejercicio14 {
    public static void main(String[] args) {
        //definimos la clase Scanner y el arraylist donde vamos a guardar los nombres y la entrada de datos
        ArrayList<String> lista = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        String entrada;

        //vamos pidiendo nombres hasta que no sea igual a fin la entrada de datos
        do {
            System.out.println("Introduce un nombre (fin = salir)");
            entrada = s.nextLine();

            //Si no es igual a fin entonces añade el nombre a la entrada
            if (!entrada.equals("fin")){
                lista.add(entrada);
            }
        } while (!entrada.equals("fin"));

        //Pedimos por pantalla el nombre a buscar
        System.out.println("dime un nombre a buscar: ");
        String entradaNom= s.nextLine();

        //ahora vemos con el metodo .contains() si existe dentro de nuestro arraylist
        //si lo ha encontrado sacaremos el índice del elemento que ha encontrado, si no, mostraremos que no existe ese elemento en especifico
        if (lista.contains(entradaNom)){
            System.out.printf("El nombre existe y se encuentra en la posición %d",lista.indexOf(entradaNom));
        } else {
            System.out.printf("El nombre %s no existe",entradaNom);
        }
    }
}
