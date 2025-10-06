import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args){
        //declaramos scanner y creamos un array con longitud 10
        Scanner s = new Scanner(System.in);
        int[] numeros = new int[10];
        //un bucle que realiza iteraciones hasta que sea menor que la longitud del array y mete los números dentro del arra
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Introduce un valor");
            numeros[i] = s.nextInt();
        }
        // muestra los números por pantalla junto al índice
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("El índice es: "+i+" y el número introducido es: "+numeros[i]);
        }
    }
}
