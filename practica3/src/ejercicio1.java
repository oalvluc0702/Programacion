/*Define un array de números tipo double de 3 filas por 7 columnas con nombre doub y
asigna los valores según la siguiente tabla. Muestra el contenido de todos los elementos del
array dispuestos en forma de tabla como se muestra en la figura. */

public class ejercicio1 {
    public static void main(String[] args){
        //creamos el array bidimensional de numeros usando 9999 como plantilla de casilla en blanco
        double[][] numeros= {{0,30,2,9999,9999,5},{75,9999,9999,9999,0,9999},{9999,9999,-2,9,9999,11}};
        String[] array={"Array","Columna 0","Columna 1","Columna 2","Columna 3","Columna 4","Columna 5"};
        //ahora con un bucle anidado mostramos por pantalla la posición los números comparando si son igual al espacio en blanco o no

        for (int i = 0; i < numeros.length; i++) {
            if (i == 0){
                for (int j = 0; j < array.length; j++) {
                    System.out.printf("%-8s   ",array[j]);
                }
                System.out.printf("%n");

            }
            System.out.printf("%-6s %d %s","FILA",i,"|");
            for (int j = 0; j < numeros[i].length; j++) {
            //si no son igual a 9999 significa que es un número, si no es que es un espacio en blanco
                if (numeros[i][j] != 9999){
                    //si j es igual a la última iteración del bucle pone una doble raya en vez de 1
                    if (j == numeros[i].length-1) {
                        System.out.printf("|%-10.0f||", numeros[i][j]);
                    } else {
                        System.out.printf("|%-10.0f|", numeros[i][j]);

                    }
                } else{
                    //lo mismo para cuando pone los espaciós en blanco
                    if (j == numeros[i].length-1){
                        System.out.printf("|%-10s||","");

                    } else {
                        System.out.printf("|%-10s|","");

                    }
                }
            }
            System.out.printf("%n");
        }
    }
}
