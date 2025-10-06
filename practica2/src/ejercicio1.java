import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int[] numeros = new int[10];
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Introduce un valor");
            numeros[i] = s.nextInt();
        }
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("El índice es: "+i+" y el número introducido es: "+numeros[i]);
        }
    }
}
