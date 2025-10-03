import java.util.Scanner;

public class actividad2_7 {
    public static void main(String[] args){

        Scanner s = new Scanner(System.in);

        System.out.println("Dime un número y te diré su tabla de multiplicar hasta el 20");

        int num = s.nextInt();

        for (int i = 0; i < 21 ; i++) {
            int resultado = num*i;

            System.out.println(num+" x "+i+" = "+resultado);

        }
    }
}
