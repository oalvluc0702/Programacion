import java.util.Scanner;

/*Modifica el programa del Ejercicio 6 para que:
1. Los números NO se repitan (como en el ejercicio anterior).
2. Los números estén comprendidos en un rango dinámico (el usuario introduce el
valor mínimo y máximo).
3. Al final, el programa muestre:
○ La media aritmética de todos los números del array.
○ La posición de todos los números primos que haya en el array.
○ Una representación gráfica en consola de cada fila, donde cada número se
represente con un número de * proporcional a su valor dentro del rango
dado (por ejemplo, si el rango es 10-20 y aparece el 15, se mostrarán 5 *). */
public class ejercicio7 {
    public static boolean esPrimo(int numero){
        if (numero < 2){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void mostrarTabla(int[][] tabla){
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                System.out.printf("|%-10d|",tabla[i][j]);
            }
            System.out.printf("%n");
        }
    }
    public static boolean buscarRepetido(int[][] numeros, int numActual){
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                if (numActual == numeros[i][j]){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        //definimos primero todas las variables y arrays que vamos a utilizar para hacer los cálculos
        Scanner s = new Scanner(System.in);
        int[][] numeros = new int[6][10];
        int max = 0;
        int min = 0;
        int posFilaMin = 0;
        int posColumnaMin = 0;
        int posFilaMax = 0;
        int posColumnaMax = 0;
        int numActual;
        int sTotal = 0;
        int sumaFila;
        int sumaColumna;
        int rangoMax;
        int rangoMin;
        int intentosMaximos=100;
        //cuenta media va a ser la variable que calcule el número de veces que introduce un número
        int cuentaMedia=0;
        do {
            System.out.println("Dime un número entero para el máximo");
         rangoMax= s.nextInt();
            System.out.println("Dime un número entero para el mínimo");
         rangoMin= s.nextInt();
         if (rangoMin > rangoMax){
             System.out.println("El número máximo no puede ser mayor que el número mínimo");
         }
        } while (rangoMax<rangoMin);
        //ahora generamos los elementos y los metemos en la matriz a la vez que vamos haciendo la suma de las filas y la suma del total
        for (int i = 0; i < numeros.length; i++) {
            //Aquí se le hace un reset a la variable suma fila para que en cada iteración del bucle recorriendo numeros cuente la suma de nuevo
            sumaFila = 0;
            //Ahora con este bucle recorremos las filas y comprobamos si se repiten para añadirlas o no
            for (int j = 0; j < numeros[i].length; j++) {
                //Definimos la variable intentos para poder controlar los intentos de comprobación
                int intentos=0;
                //Ahora con un do while ejecutaremos la generación del número aleatorio que se ejecute mientras buscar repetido sea verdadero y los intentos sean menores a los intentos máximos permitidos
                do {
                    numActual = rangoMin + (int) (Math.random() * (rangoMax-rangoMin + 1));
                    intentos++;
                } while (buscarRepetido(numeros, numActual) && intentos < intentosMaximos);
                //si los intentos máximos son menores o igual a los intentos realizados en el bucle significa que ya no quedan valores que meter que no se repitan por lo cual rompe el bucle, no añadiendo más numeros
                if (intentosMaximos <= intentos){
                    break;
                }
                //añadimos al total el número actual
                sTotal += numActual;
                //añadimos al array e incrementamos el valor de la cuenta de números para hacer la media
                numeros[i][j] = numActual;
                cuentaMedia++;
                //y añadido a la suma de la fila
                sumaFila += numActual;
                if (esPrimo(numActual)){
                    System.out.printf("el número primo %d se encuentra en la Fila %d y Columna %d%n",numActual,i+1,j+1);
                }
                //Ahora con este grupo de if vamos a ir comparando cual es el máximo y el mínimo del array
                //con este primer if ponemos que en la primera iteración del bucle ponga el número actual como verdadero y como falso
                if (i == 0 && j == 0) {
                    max = numActual;
                    min = numActual;
                }
                //Ahora aquí si el número que es el actual es mayor que el que ya era máximo, el numero máximo es el número actual
                //Su posición de fila va a ser i y su posición de columna j que son las variables contadoras
                if (numActual > max) {
                    max = numActual;
                    posFilaMax = i;
                    posColumnaMax = j;
                }
                //Aquí haremos lo mismo que arriba pero para los mínimos
                if (numActual < min) {
                    min = numActual;
                    posFilaMin = i;
                    posColumnaMin = j;
                }

            }
            // vamos imprimiendo la suma de cada fila y le vamos a sumar 1 para que no empiece 0 al conteo de fila
            System.out.printf("la suma de la fila %d es %d", i + 1, sumaFila);
            System.out.printf("%n");
        }

        //Ahora vamos a hacer un for recorriendo por columnas en vez de por filas y vamos a ir almacenando la suma de las columnas
        for (int j = 0; j < numeros[0].length; j++) {
            //Aqui hacemos reset a la variable sumaColumna para que cada vez que pase a una columna nueva sumaColumna valga 0 de nuevo
            sumaColumna = 0;
            //Con este for recorremos las columnas sumando los valores a cada vez
            for (int i = 0; i < numeros.length; i++) {
                sumaColumna += numeros[i][j];
            }
            //al igual que en las filas las imprimimos por pantalla sumando 1 al conteo de columna para que no sea 0
            System.out.printf("la suma de la columna %d es %d", j + 1, sumaColumna);
            System.out.printf("%n");
        }
        int media=sTotal/cuentaMedia;
        //Ahora vamos imprimiendo lo que nos pide el ejercicio haciendo uso de las variables que creamos
        //Primero número máximo y posición
        System.out.printf("El número máximo es %d y se encuentra en la posición de fila %d columna %d%n", max, posFilaMax + 1, posColumnaMax + 1);
        //Segundo número mínimo y posición
        System.out.printf("El número mínimo es %d y se encuentra en la posición de fila %d columna %d%n", min, posFilaMin + 1, posColumnaMin + 1);
        //Y por último la suma de todas las filas y columnas, básicamente el array entero
        System.out.printf("La suma de todas las filas y columnas en total es %d%n", sTotal);
        System.out.printf("La media aritmética es: %d%n",media);
        mostrarTabla(numeros);

    }
}

