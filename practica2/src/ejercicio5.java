import java.util.Scanner;

public class ejercicio5 {
    public static void main (String[] args){

        //definimos la clase Scanner
        Scanner s = new Scanner(System.in);

        //preguntamos el número por pantalla y lo guardamos en una variable y lo definimos como el tamaño de reserva en el array
        System.out.println("dime el tamaño del array");
        int tamaño = s.nextInt();
        int[] nums = new int[tamaño];

        //ahora hacemos el calculo del número aleatorio y lo vamos metiendo en las posiciones con un bucle mostrándolo por pantalla
        for (int i = 0; i < nums.length; i++) {
            nums[i]= (int) (Math.random()*10);
            System.out.println("El índice del número es: "+i+" el número aleatorio es: "+nums[i]);
        }
    }
}
