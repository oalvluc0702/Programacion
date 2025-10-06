import java.util.Scanner;

public class ejercicio7 {
    public static void main(String[] args){
        //definimos la clase Scanner y el array
        Scanner s = new Scanner(System.in);
        int[] nums = new int[10];

        //ahora definimos las variables para contar los números
        int positivo = 0;
        int negativo = 0;

        //metemos los números en el array
        for (int i = 0; i < nums.length; i++) {
            System.out.println("Dime 10 números:");
            nums[i] = s.nextInt();
        }
        // ahora hacemos una comprobación de los números y vamos contando dependiendo de si son mayores o menor que 0
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] > 0){
                positivo++;
            } else if (nums[k] < 0){
                negativo++;
            }
        }

        //definimos los arrays con la longitud de los números que hemos calculado que eran positivos y negativos
        int[] numPos = new int[positivo];
        int[] numNeg= new int[negativo];

        //definimos un contador tanto para numeros negativos como para positivos para tener la referencia de donde guardarlos en el array de cada uno
        int contP = 0;
        int contN = 0;
        //recorremos el array de numeros para ver cuales son los positivos y los metemos en los arrays usando los contadores que hemos definido para cada uno
        for (int l = 0; l < nums.length; l++) {
            if (nums[l] >= 0){
                numPos[contP] = nums[l];
            } else if (nums[l] < 0){
                numNeg[contN] = nums[l];
            }
        }

        //definimos las variables de las sumas de positivos y negativos
        int sumaPos = 0;
        int sumaNeg = 0;
        //hacemos la suma y la media para los positivos recorriendo el array de positivos
        for (int m = 0; m < numPos.length; m++) {
            sumaPos += numPos[m];
        }
        double mediaPos = (double) sumaPos / (double) numPos.length;

        //hacemos la suma y la media recorriendo el array de negativos
        for (int n = 0; n < numNeg.length; n++) {
            sumaNeg += numNeg[n];
        }
        double mediaNeg = (double) sumaNeg / (double) numNeg.length;

        //y ahora simplemente lo mostramos por pantalla
        System.out.println("hay "+positivo+" Numeros positivos y la media de los introducidos es: "+mediaPos);
        System.out.println("hay "+negativo+" Numeros negativos y la media de los introducidos es: "+mediaNeg);
    }
}
