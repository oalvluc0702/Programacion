import java.util.Scanner;
/*Escribe un programa que, dada una posición en un tablero de ajedrez, nos diga a qué casillas podría saltar un caballo que se encuentra en esa posición. Como se indica en la fi gura, el caballo se mueve siempre en forma de L. El tablero cuenta con 64 casillas. Las columnas se indican con las letras de la “a” a la “h” y las filas se indican del 1 al 8.*/
public class ejercicio9 {

    //tendremos esta función para mostrar el tablero, que mostrará conjunto, que es un array con los Strings concatenados
    public static void mostrarTablero(String[][] conjunto){
        for (int i = 0; i < conjunto.length; i++) {
            for (int j = 0; j < conjunto[i].length; j++) {
                System.out.printf("%-10s",conjunto[i][j]);
            }
            System.out.printf("%n");
        }
    }
    //Tendremos esta función que servirá para encontrar si ese número de casilla que nos ha dicho existe
    //se le pasara como parámetro conjunto y caballo que es el texto introducido por el usuario
    //si lo encuentra devuelve true y si no lo encuentra false
    public static boolean encontrarNumero(String[][] conjunto, String caballo){
        for (int i = 0; i < conjunto.length; i++) {
            for (int j = 0; j < conjunto[i].length; j++) {
                if (caballo.equalsIgnoreCase(conjunto[i][j])){
                    return true;
                }
            }
        }
        return false;
    }
    //esta función es la que se encarga de calcular los movimientos del caballo y decir si son posibles
    public static void resultado(String caballo, String[][] conjunto){
        //ponemos en un array los posibles movimientos por fila del caballo
        int[] movFila={-2,-1,1,2,2,1,-1,-2};
        //y hacemos otro array al cual atribuimos ese movimiento a la columna por cada fila
        int[] movColumna={1,2,2,1,-1,-2,-2,-1};
        //inicializamos las variables que harán de la posición actual, las ponemos a -1 para asegurarnos que no caiga en 0
        int posFila=-1;
        int posColumna=-1;
        for (int i = 0; i < conjunto.length; i++) {
            for (int j = 0; j < conjunto[i].length; j++) {
                //si encuentra el valor la posición de la fila y la columna serán i y j
                if (caballo.equalsIgnoreCase(conjunto[i][j])){
                     posFila= i;
                     posColumna=j;
                     break;
                }
            }
        }
        //ahora calculamos las posiciones teniendo en cuenta si se sale del tamaño del tablero 8x8
        System.out.print("El caballo puede moverse a las siguientes posiciones ");
        for (int k = 0; k < movFila.length; k++) {
            int posibleFila= posFila+movFila[k];
            int posibleColumna= posColumna+movColumna[k];
            //aquí comparamos que no se pase del tablero, para que solo imprima los posibles
            if (posibleFila >=0 && posibleFila < conjunto.length && posibleColumna >=0 && posibleColumna < conjunto.length){
                System.out.printf("%s ",conjunto[posibleFila][posibleColumna]);
            }
        }
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        //ponemos las filas y columnas
        String[] columnas={"A","B","C","D","E","F","G","H"};
        String[] filas={"8","7","6","5","4","3","2","1",};
        //aquí rellenamos conjunto con la mezcla del String
        String[][] conjunto = new String[8][8];
        for (int i = 0; i < conjunto.length; i++) {
            for (int j = 0; j < conjunto[i].length; j++) {
                String casilla=columnas[j]+filas[i];
                conjunto[i][j]=casilla;
            }
        }
        //mostramos el tablero y preguntamos donde quiere poner el caballo el que ejecuta el código
        mostrarTablero(conjunto);
        System.out.println("Dime la posición donde quieres introducir el caballo");
        String caballo = s.nextLine();
        //si no encuentra ese número entonces me lo va a pedir hasta que haya uno que si sea válido
        while(!encontrarNumero(conjunto,caballo)) {
            System.out.println("Esa posición no es válida, vuelve a pedir");
            caballo = s.nextLine();
        }
        //por último imprime el resultado de la función resultado explicada anteriormente.
        resultado(caballo,conjunto);
    }
}
