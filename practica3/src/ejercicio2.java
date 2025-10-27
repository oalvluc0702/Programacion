import java.util.Scanner;

/*Escribe un programa que solicite 20 números enteros. Estos números debemos de
introducirlo en un array de 4 filas por 5 columnas. El programa mostrará las sumas parciales
de filas y en las columnas el mayor número de la columna. La suma total debe aparecer en
la esquina inferior derecha.*/

public class ejercicio2 {
    public static void main(String[] args){

        //definimos la clase Scanner y hacemos un nuevo objeto
        Scanner s = new Scanner(System.in);

        //definimos el array de números que va a hacer de tabla para nuestro programa
        int[][] numeros = new int[4][5];

        //esta variable es la que se encargará de sumar todas las filas posibles en nuestro programa
        int sTotal=0;

        //con un for anidado metemos los números en el array bidimensional
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                    System.out.println("Dime un numero por pantalla: ");
                    numeros[i][j]= s.nextInt();
            }
        }

        //este bucle será el que se encargará de imprimir las filas y la suma de cada una de las filas, sin el máximo de columna ni la suma total de todas las filas
        for (int i = 0; i < numeros.length; i++) {
            //suma fila será la variable que almacene nuestra suma de los valores de la misma fila
            int sumaFila = 0;
            //este bucle imprime los números siguiendo la segunda dimensión de nuestro array
            for (int j = 0; j < numeros[i].length; j++) {
                System.out.printf("|    %d    |",numeros[i][j]);
                //añade el número a sumaFila para luego mostrarlo
                sumaFila+=numeros[i][j];
            }
            //una vez que el bucle ha recorrido el valor de la segunda dimensión para la primera posición de la primera dimensión guarda el valor de la suma de la fila en sTotal para ir sumando todas las filas
            //repite el bucle hasta que haya terminado de recorrer la matriz
            sTotal+=sumaFila;
            //imprimimos la columna del sumatorio de la fila
            System.out.printf("|   %d   ||%n",sumaFila);
        }

        //este bucle se encargará de recorrer el array de otra manera para sacar el número máximo de la columna
        for (int j = 0; j < numeros[0].length; j++) {
            //definimos max al primer número de la columna para tener una referencia a la hora de comparar donde J es el número de columna y 0 es el primer elemento
            int max = numeros[0][j];
            //ahora vamos comparando empezando por el número 1 para que compare el siguiente elemento de la columna, la iteración se repite hasta que acabe los números de la columna
            for (int i = 1; i < numeros.length; i++) {
                //comparamos y si es mayor que max, lo definimos como numero máximo
                if (numeros[i][j] > max) {
                    max = numeros[i][j];
                }
            }
            //cuando ha acabado la comparación de esa columna, imprimos en la tabla ese número guardado en max
            System.out.printf("|    %d    |",max);
        }
        //Como último paso imprimimos el contenido de la variable sTotal que es la suma de todas las filas y ya estaría completa la tabla
        System.out.printf("|   %d   ||",sTotal);
    }
}
