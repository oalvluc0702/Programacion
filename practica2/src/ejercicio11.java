import java.util.Arrays;

public class ejercicio11 {
    public static void main(String[] args){
        //definimos el array nums y definimos una variable contador y 2 variables que servirán para controlar los numeros
        int[] nums={1,2,3,4,5,6};
        int contador=0;
        int valoractual;
        int valorfinal;

        //ahora con un for recorremos el array de manera inversa y guardamos como valor actual lo que se supone que vale la primera posición y luego la última con la variable del bucle
        for (int i = nums.length; i > 0; i--) {
            valoractual=nums[contador];
            valorfinal=nums[i-1];
            //ahora sobreescribimos el array invirtiendo los valores del principio y de la cola
            nums[contador]=valoractual;
            nums[i-1]=valorfinal;
            //por cada iteración usaremos este contador para contar por el principio del array
            contador++;
        }
        //ahora con el metodo Arrays.toString() mostramos por pantalla el array como si fuera un texto para comprobar que se ha invertido.
        System.out.println(Arrays.toString(nums));
    }
}
