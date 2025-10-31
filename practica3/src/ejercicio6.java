
public class ejercicio6 {
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
        int intentosMaximos=100;
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
                    numActual = 20 + (int) (Math.random() * 21);
                    intentos++;
                } while (buscarRepetido(numeros, numActual) && intentos < intentosMaximos);
                //si los intentos máximos son menores o igual a los intentos realizados en el bucle significa que ya no quedan valores que meter que no se repitan por lo cual rompe el bucle, no añadiendo más numeros
                if (intentosMaximos <= intentos){
                    break;
                }
                //añadimos al total el número actual
                sTotal += numActual;
                //añadimos al array
                numeros[i][j] = numActual;
                //y añadido a la suma de la fila
                sumaFila += numActual;
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
        //Ahora vamos imprimiendo lo que nos pide el ejercicio haciendo uso de las variables que creamos
        //Primero número máximo y posición
        System.out.printf("El número máximo es %d y se encuentra en la posición de fila %d columna %d%n", max, posFilaMax + 1, posColumnaMax + 1);
        //Segundo número mínimo y posición
        System.out.printf("El número mínimo es %d y se encuentra en la posición de fila %d columna %d%n", min, posFilaMin + 1, posColumnaMin + 1);
        //Y por último la suma de todas las filas y columnas, básicamente el array entero
        System.out.printf("La suma de todas las filas y columnas en total es %d", sTotal);
    }
}

