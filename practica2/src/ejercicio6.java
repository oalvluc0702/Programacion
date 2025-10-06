import java.util.Scanner;

public class ejercicio6 {
    public static void main(String[] args){
        //definimos la clase Scanner y el array
        Scanner s = new Scanner(System.in);
        int[] nums = new int[10];

        //ahora definimos las variables para contar los números
        int positivo = 0;
        int negativo = 0;
        int ceros = 0;

        //metemos los números en el array
        for (int i = 0; i < nums.length; i++) {
            System.out.println("Dime 10 números:");
            nums[i] = s.nextInt();
        }
        // ahora hacemos una comprobación de los números y vamos contando dependiendo de si son mayores menor o igual a 0
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] > 0){
                positivo++;
            } else if (nums[k] < 0){
                negativo++;
            } else if (nums[k] == 0){
                ceros++;
            }
        }
        System.out.println("Hay "+positivo+" números positivos");
        System.out.println("Hay "+negativo+" números negativos");
        System.out.println("Hay "+ceros+" ceros");
    }
}
