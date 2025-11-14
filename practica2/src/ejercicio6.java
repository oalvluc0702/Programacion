import java.util.Scanner;

// Ejercicio 6
/* Programa Java que guarda en un array 10 números enteros que se leen por teclado. A
continuación se recorre el array y calcula cuántos números son positivos, cuántos negativos
y cuántos ceros. */

public class ejercicio6 {
    public static void main(String[] args){
        //definimos la clase Scanner y el array
        Scanner s = new Scanner(System.in);
        int[] nums = new int[10];

        //ahora definimos las variables para contar los números
        int pares = 0;
        int impares = 0;

        //metemos los números en el array
        for (int i = 0; i < nums.length; i++) {
            System.out.println("Dime 10 números:");
            nums[i] = s.nextInt();
        }
        // ahora hacemos una comprobación de los números y vamos contando dependiendo de si son mayores menor o igual a 0
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] % 2 == 0){
                pares++;
            } else {
                impares++;
            }
        }
        System.out.println("Hay "+pares+" números positivos");
        System.out.println("Hay "+impares+" números negativos");
        //System.out.println("Hay "+ceros+" ceros");
    }
}
