/*Crear un programa que cuando se le introduzca números enteros rellene un array de 6 filas
por 10 columnas con números enteros positivos comprendidos entre 0 y 1000 (ambos
incluidos). A continuación, el programa deberá:
-dar la posición del número máximo y mínimo
-la suma total de todas las filas y columnas
-la suma de todas las columnas
-la suma de todas las filas.  */
public class ejercicio5 {
    public static void main(String[] args){
        //definimos primero todas las variables y arrays que vamos a utilizar para hacer los cálculos
        int[][] numeros = new int[6][10];
        int max=0;
        int min=0;
        int posFilaMin=0;
        int posColumnaMin=0;
        int posFilaMax=0;
        int posColumnaMax=0;
        int numActual;
        int sTotal=0;
        int sumaFila;
        int sumaColumna;
        for (int i = 0; i < numeros.length; i++) {
            sumaFila = 0;
            for (int j = 0; j < numeros[i].length; j++) {
                numActual= (int)(Math.random()*1001);
                sTotal+=numActual;
                numeros[i][j] = numActual;
                sumaFila+=numActual;
                if (i == 0 && j == 0){
                    max = numActual;
                    min = numActual;
                }
                if (numActual > max){
                    max = numActual;
                    posFilaMax = i;
                    posColumnaMax= j;
                }
                if (numActual < min){
                    min=numActual;
                    posFilaMin = i;
                    posColumnaMin = j;
                }
            }
            System.out.printf("la suma de la fila %d es %d",i+1,sumaFila);
            System.out.printf("%n");
        }
        for (int j = 0; j < numeros[0].length; j++) {
            sumaColumna=0;
            for (int i = 0; i < numeros.length; i++) {
                sumaColumna+=numeros[i][j];
            }
            System.out.printf("la suma de la columna %d es %d",j+1,sumaColumna);
            System.out.printf("%n");
        }
        System.out.printf("El número máximo es %d y se encuentra en la posición de fila %d columna %d%n",max,posFilaMax+1,posColumnaMax+1);
        System.out.printf("El número mínimo es %d y se encuentra en la posición de fila %d columna %d%n",min,posFilaMin+1,posColumnaMin+1);
        System.out.printf("La suma de todas las filas y columnas en total es %d",sTotal);
    }
}