import java.util.Scanner;

public class actividad2_8 {
    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        int[] numeros = new int[10];
        System.out.println("Introduce 10 numeros por teclado: ");

        for (int i = 0; i <numeros.length ; i++) {
            numeros[i] = s.nextInt();
        }

        for (int u = 9; u >= 0; u--) {
            System.out.println(numeros[u]);
        }
    }
}
