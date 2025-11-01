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
    //esta función encuentra si el número es un número primo y devuelve un true or false
    public static boolean esPrimo(int numero){
        //si el número es menor de 2 el número no es primo y devuelve false
        if (numero < 2){
            return false;
        }
        //ahora hacemos un bucle para ir comparando hasta que i sea menor que la raiz cuadrada del número encontrado, porque si un número por debajo de la raíz cuadrada de ese número es divisor del número encontrado significa que tiene un divisor menor.
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            //si el módulo de i es igual a 0 es porque ha encontrado un divisor aparte que no sea el mismo y 1, por eso empezamos en 2, por lo cual nos devolvería que no es primo
            if (numero % i == 0){
                return false;
            }
        }
        //si no ha pasado ninguna de estas comprobaciones, significa que el número es primo
        return true;
    }
    //esta es la función que se encarga de mostrar la tabla
    public static void mostrarTabla(int[][] tabla){
        //la función recorre el array haciendo print por cada número reservando 10 espacios
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                System.out.printf("|%-10d|",tabla[i][j]);
            }
            System.out.printf("%n");
        }
    }
    //esta función te devuelve verdadero o falso dependiendo de si ha encontrado un número que esté repetido
    public static boolean buscarRepetido(int[][] numeros, int numActual){
        //va comparando el array con el número actual que se le pasa por parametro y si es igual devolverá verdadero, si el número no ha pasado las comprobaciones entonces devuelve falso
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                if (numActual == numeros[i][j]){
                    return true;
                }
            }
        }
        return false;
    }
    //esta función es la que se encarga de imprimir los asteriscos, y en mi opinión la que tiene más complejidad.
    //le pasas 3 parametros, eel array, el rango mínimo y el rango máximo
    public static void imprimirAsterisco(int[][] tabla, int minimo, int maximo){
        //definimos un número máximo de asteriscos que queremos imprimir, para que la tabla no se vea tan fea por pantalla
        int maximosAsteriscos= 10;
        //reserva es la reserva de espacios que va a hacer en el print
        int reserva=maximosAsteriscos+2;
        //ahora con un for recorremos el array
        for (int i = 0; i < tabla.length; i++) {
            //imprimimos fila y a continuación los asteriscos
            System.out.printf("%-4d: ",i+1);
            for (int j = 0; j < tabla[i].length; j++) {
                //ahora vamos a calcular la cantidad de asteriscos que vamos a poner, la variable se tiene que resetear en cada iteración así que la definimos aquí
                //ahora con la fórmula matemática numero-minimo * maximo de asteriscos / (maximo-minimo) tendríamos algo tal que así, si el maximo es 20 y el mínimo es 10 y el número que ha salido es 15 sería:
                //15-10 = 5 esto se redondea por si acaso tuviéramos el array de double, 5*10 = 50, 50/ (20-10) = 50 / 10 = 5 Por lo cual se pondrían 5 asteriscos, y esta fórmula funciona para todos los números
                //El casteo de la última operación se pone double por si acaso el mínimo es 0 y el máximo es 10 y por lo cual la división sería 0 y no imprimiría ningún asterisco
                int asteriscos= (int) (Math.round(tabla[i][j] - minimo) * maximosAsteriscos / (double) (maximo-minimo));
                //definimos el string imprimir para concatenar los asteriscos
                String imprimir="";
                //con este bucle vamos concatenando los asteriscos a la string para luego mostrarlos
                for (int k = 0; k < asteriscos; k++) {
                    imprimir+="*";
                }
                //aquí simplemente imprimimos el string imprimir con todos los asteriscos dentro con la reserva de espacios dinámica, si cambiáramos el número de asteriscos se ampliaría o disminuiría esta reserva
                System.out.printf("%-"+reserva+"s",imprimir);
            }
            System.out.printf("%n");
        }
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
                //aquí vamos a comprobar si el número introducido es primo, si es primo lo imprimimos por pantalla
                if (esPrimo(numActual)){
                    System.out.printf("se ha encontrado un número primo, este es: %d se encuentra en la Fila %d y Columna %d%n",numActual,i+1,j+1);
                }
                //Ahora con este grupo de if vamos a ir comparando cuál es el máximo y el mínimo del array
                //con este primer if ponemos que en la primera iteración del bucle ponga el número actual como verdadero y como falso
                if (i == 0 && j == 0) {
                    max = numActual;
                    min = numActual;
                }
                //Ahora aquí si el número que es el actual es mayor que el que ya era máximo, el número máximo es el número actual
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

        }
        System.out.printf("%n");
        //vamos a definir cuál será la media de la matriz, que será dividiendo todos los números entre el número de veces que ha insertado número
        int media=sTotal/cuentaMedia;
        //Ahora vamos imprimiendo lo que nos pide el ejercicio haciendo uso de las variables que creamos
        //Primero número máximo y posición
        System.out.printf("El número máximo es %d y se encuentra en la posición de fila %d columna %d%n", max, posFilaMax + 1, posColumnaMax + 1);
        //Segundo número mínimo y posición
        System.out.printf("El número mínimo es %d y se encuentra en la posición de fila %d columna %d%n", min, posFilaMin + 1, posColumnaMin + 1);
        //la suma de todas las filas y columnas, básicamente el array entero
        System.out.printf("La suma de todas las filas y columnas en total es %d%n", sTotal);
        //mostramos la media aritmética
        System.out.printf("La media aritmética es: %d%n",media);
        //aquí llamamos a la función mostrarTabla que es la que se encarga de imprimir la tabla, para que sepamos como está estructurada
        mostrarTabla(numeros);
        //añadimos un salto de línea y llamaremos a nuestra función para imprimir los asteriscos en proporción al rango introducido
        System.out.printf("%n");
        //Llamamos a la función imprimirAsterisco para que nos imprima los asteriscos a base de los parámetros dados.
        imprimirAsterisco(numeros,rangoMin,rangoMax);
    }
}