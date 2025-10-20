

//Ejercicio 3
/* Crea un array que contenga 5 números. Realiza un programa que te muestre por pantalla
SOLO el más pequeño de ellos. */

public class ejercicio3 {
    public static void main(String[] args){
        //definimos el array de números
        int[] numeros = {7,15,4,5,7};

        //definimos el número minimo al primero para empezar teniendo una referencia
        int min = numeros[0];

        //ahora hacemos un bucle que compruebe si el número que viene en la posición siguiente es mayor que el que ya está definido
        for (int i = 0; i < numeros.length; i++) {
            if (min > numeros[i]) {

                min = numeros[i];

            }
        }
        //ahora fuera del bucle mostramos el número que se ha quedado definido por pantalla
        System.out.println("el numero mínimo es: "+ min);
    }
}
