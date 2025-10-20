import java.util.ArrayList;
import java.util.Scanner;

//Ejercicio 13
/*Crea un programa que:
Cree una lista de enteros (ArrayList<Integer>).
Pida números por teclado hasta que el usuario introduzca un número negativo (ese
no se añade).
Muestre por pantalla todos los números de la lista y la suma total de los mismos. */

public class ejercicio13 {
    public static void  main(String[] args){
        //definimos la variable escaner y el arraylist de enteros
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<>();
        //definimos la variable de entrada que será la que alojará lo que entra por teclado
        int entrada;
        //en un bucle while repetimos que pida un número por pantalla hasta que sea negativo y si es positivo que lo añada a la lista de array.
        do {
           System.out.println("Dame un número por teclado ( si es negativo se para )");
            entrada = s.nextInt();
            if (entrada >= 0){
                lista.add(entrada);
            }
        } while (entrada >= 0);

        //definimos la variable suma y recorremos el array list sumando los elementos
        int suma= 0;
        for (int integer : lista) {
            suma += integer;
        }
        //formateamos el output y pasamos el array a string para mostrarlo
        String output = lista.toString();
        //ahora mostramos lo que pide el ejercicio por pantalla
        System.out.printf("El array que se ha almacenado es: %s%n",output);
        System.out.printf("La suma de los números en el ArrayList es: %d",suma);

    }
}
