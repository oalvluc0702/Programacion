/*Modifica el programa anterior de tal forma que las sumas parciales y la suma total
aparezcan en la pantalla con un pequeño retraso, dando la impresión de que el ordenador
se queda “pensando” antes de mostrar los números.*/

public class ejercicio4 {
    public static void main(String[] args){

        //definimos el array de números que va a hacer de tabla para nuestro programa
        int[][] numeros = new int[4][5];

        //esta variable es la que se encargará de sumar todas las filas posibles en nuestro programa
        int sTotal=0;
        //con un for anidado metemos los números en el array bidimensional
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                //los números serán aleatorios del 1 al 1999, por lo cual vamos a hacer un Math.random casteado a int para que no devuelva decimal
                //la función será 1 + 1999 para asegurarnos que siempre el número mínimo es 1 y no 0 ya que al castearlo a int si lo dejamos como está da cualquier resultado entre 0 y menor que 1 y lo interpreta siempre como 0
                numeros[i][j]= 1 + (int) (Math.random()*1999);
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

            //imprimimos la columna del sumatorio de la fila con el metodo Thread.sleep para que tenga un retraso de 700 milisegundos al imprimir la fila (0,7 segundos)
            try{Thread.sleep(700);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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

            //hacemos que a la suma total que tenemos de las filas, se les sume las columnas máximas tambien para luego mostrarlo al final
            sTotal+=max;

            //cuando ha acabado la comparación de esa columna, imprimos en la tabla ese número guardado en max
            System.out.printf("|    %d    |",max);
        }

        //Como último paso imprimimos el contenido de la variable sTotal que es la suma de todas las filas y ya estaría completa la tabla
        //al igual que en las filas le añadimos el retraso de 0'7 para simular el delay
        try{Thread.sleep(700);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("|   %d   ||",sTotal);
    }
}