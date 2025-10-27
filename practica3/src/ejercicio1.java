public class ejercicio1 {
    public static void main(String[] args){
        //creamos el array bidimensional de numeros usando 9999 como plantilla de casilla en blanco
        double[][] numeros= {{0,30,2,9999,9999,5},{75,9999,9999,9999,0,9999},{9999,9999,-2,9,9999,11}};
        //ahora con un bucle anidado mostramos por pantalla la posición los números comparando si son igual al espacio en blanco o no
        System.out.println("Array  Columna0 Columna1  Columna 2 Columna 3 Columna 4 Columna 5");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("FILA "+i+"|");
            for (int j = 0; j < numeros[i].length; j++) {
            //si no son igual a 9999 significa que es un número, si no es que es un espacio en blanco
                if (numeros[i][j] != 9999){
                    System.out.printf("|  %.0f    |",numeros[i][j]);
                } else{
                    System.out.print("|        |");
                }
            }
            System.out.printf("%n");
        }
    }
}
