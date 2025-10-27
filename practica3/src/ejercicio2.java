import java.util.Scanner;

/*Escribe un programa que solicite 20 números enteros. Estos números debemos de
introducirlo en un array de 4 filas por 5 columnas. El programa mostrará las sumas parciales
de filas y en las columnas el mayor número de la columna. La suma total debe aparecer en
la esquina inferior derecha.*/
public class ejercicio2 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int[][] numeros = new int[4][5];
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                    System.out.println("Dime un numero por pantalla: ");
                    numeros[i][j]= s.nextInt();
            }
        }
        int sumaFila = 0;
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                System.out.printf(" %d ",numeros[i][j]);
                sumaFila+=numeros[i][j];
            }
            System.out.printf(" %d%n",sumaFila);
        }
        for (int j = 0; j < 4; j++) { // Solo 5 columnas
            int max = numeros[0][j];
            for (int i = 1; i < 3; i++) { // Solo filas 0 a 3
                if (numeros[i][j] > max) {
                    max = numeros[i][j];
                }
            }
            System.[3][j] = max; // Guardamos el máximo en la última fila
        }

    }
}
