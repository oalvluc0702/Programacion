import java.util.Scanner;

public class ejercicio4 {
    public static void main(String[] args){
        //definimos el array de 100 numeros y definimos la variable media, le daremos valor de 0
        int[] array = new int[100];
        double media = 0;

        //en este bucle vamos a meter los números en el array y le sumamos 1 para que meta en la primera posición el número +1
        for (int i = 0; i < array.length; i++) {
            array[i] = i+1;
        }

        //definimos suma con el valor del primer número
        int suma = array[0];

        //vamos sumando todos los números en consecución
        for (int i = 1; i < array.length; i++) {
            suma +=array[i];
        }

        //calculamos la media y mostramos por pantalla todos los números
        media= (double) suma / (double) array.length;
        System.out.println("la suma es "+suma);
        System.out.println("la media es "+media);

    }
}
