import java.util.Scanner;

public class ej8 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        String resultado = "";
        System.out.println("Dime un número por favor");
        for (int i = 0; i < 10; i++) {

            String numero = s.nextLine();
            resultado = numero+resultado;
        }
        System.out.println(resultado);
    }
}
