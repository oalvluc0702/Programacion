import java.util.ArrayList;
import java.util.Scanner;

public class ejercicio13 {
    public static void  main(String[] args){
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<>();
        int entrada;
        do {
           System.out.println("Dame un número por teclado ( si es negativo se para )");
            entrada = s.nextInt();
        } while (entrada >= 0);
    }
}
