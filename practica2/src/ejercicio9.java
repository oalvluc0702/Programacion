import java.util.Scanner;

public class ejercicio9 {
    public static void  main(String[] args){
        //importamos clase Scanner y definimos el array que contendrá los 10 números enteros
        Scanner s= new Scanner(System.in);
        int[] nums = new int[10];

        //ahora metemos los números en el array pidiéndolos por pantalla
        for (int i = 0; i < nums.length ; i++) {
            System.out.println("Dime un número entero por pantalla:");
            nums[i] = s.nextInt();
        }

        //definimos las variables que van a compararse para el máximo y mínimo y les asignamos el primer número y la variable que indicará el número de posición de ambos
        int max = nums[0];
        int min = nums[0];
        int numPos = 0;

        //comparamos los números con el contador, si es mayor que el máximo se sobreescribirá y la posición será el contador + 1
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > max){
              max=nums[j];
              numPos=j+1;
            }
        }
        //mostramos el máximo por pantalla de una manera formateada y su posición
        System.out.printf("El número máximo es %d y su posición es %d%n",max,numPos);

        //asignamos el número de posición a 0 nuevamente para que podamos reutilizar la variable
        numPos=0;

        //hacemos lo mismo pero para los mínimos, esta vez comparando si el número del contador es menor que el mín
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] < min){
                min=nums[k];
                numPos=k+1;
            }
        }
        //ahora imprimimos por pantalla el número mínimo de manera formateada.
        System.out.printf("El numero minimo es %d y su posición es %d",min,numPos);
    }
}
