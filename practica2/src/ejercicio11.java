import java.util.Arrays;

//Ejercicio 11
/*Escribe un programa java que invierta el orden de los valores de un array. Por invertir el
orden de los valores de un array, me refiero que el último pasa a ser el primero, el
penúltimo el segundo y así sucesivamente. PRUEBA CON UN ARRAY DE TAMAÑO 6. */

public class ejercicio11 {
    public static void main(String[] args){
        //definimos el array nums y un array auxiliar para invertirlo
        int[] nums={1,2,3,4,5,6};
        int[] numAux= new int[6];
        int contador = 0;
        //ahora con un for recorremos el array de manera inversa y guardamos los datos invertidos en el array auxiliar
        for (int i = nums.length; i > 0; i--) {
            numAux[contador]=nums[i-1];
            contador++;
        }
        //sobreescribimos el array nums con el contenido del auxiliar
        for (int k = 0; k < numAux.length; k++) {
            nums[k]=numAux[k];
        }
        //ahora con el metodo Arrays.toString() mostramos por pantalla el array como si fuera un texto para comprobar que se ha invertido.
        System.out.println(Arrays.toString(nums));
    }
}
