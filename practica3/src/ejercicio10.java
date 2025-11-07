import java.util.Scanner;

public class ejercicio10 {
    //aquí tendremos la función sencilla para mostrar el tablero, teniendo en cuenta lo que tiene que mostrar dependiendo del valor dentro del array
    public static void mostrarTablero(int[][] tablero){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                //si es 0 muestra las blancas, si es 1 las cruces y lo que no sea ni 0 ni 1 lo muestra como un guion bajo
                if (tablero[i][j] == 0){
                    System.out.printf("%-10s","O");
                } else if (tablero[i][j] == 1){
                    System.out.printf("%-10s","X");
                } else {
                    System.out.printf("%-10s","_");
                }

            }
            System.out.printf("%n");
        }
    }
    //con esta función comprobamos si es empate o no, para ello comprueba si existe un número 99
    //el número 99 representa los espacios en blanco de mi tres en raya
    public static boolean empate(int[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if(tablero[i][j] == 99) {
                    return false;
                }
            }
        }
        return true;
    }
    //aqui está nuestra función que sirve para controlar quien gana en la partida y cuando se acaba.
    public static boolean acabarPartida(int[][] tablero){
        //vamos a comprobar quien gana calculando el sumatorio de las filas
        for (int i = 0; i < tablero.length; i++) {
            int sumaFila = 0;
            for (int j = 0; j < tablero[i].length; j++) {
               int numeroActual=tablero[i][j];
                sumaFila+=numeroActual;
            }
            //si la suma de la fila es igual a 0 gana el jugador blanco, si es 3 gana el jugador 2
            if (sumaFila == 0){
               System.out.println("Ha ganado el jugador 1");
               return true;
            } else if (sumaFila == 3) {
                System.out.println("Ha ganado el jugador 2");
                return true;
            }
        }
        //haremos lo mismo para las columnas
        for (int j = 0; j < tablero[0].length; j++) {
            int sumaColumna = 0;
            for (int i = 0; i < tablero.length; i++) {
                int valorActual = tablero[i][j];
                sumaColumna+=valorActual;
            }
            if (sumaColumna == 0){
                System.out.println("Ha ganado el jugador 1");
                return true;
            } else if (sumaColumna == 3) {
                System.out.println("Ha ganado el jugador 2");
                return true;
            }
        }
        //para las diagonales haremos 2 variables que sumen las diagonales
        int diagonal1= tablero[0][0]+tablero[1][1]+tablero[2][2];
        int diagonal2= tablero[0][2]+tablero[1][1]+tablero[2][0];
        //haremos la comprobación también con las diagonales
        if (diagonal1 == 0 || diagonal2 == 0 ){
            System.out.println("Ha ganado el jugador 1");
            return true;
        } else if(diagonal2 == 3 || diagonal1 == 3){
            System.out.println("Ha ganado el jugador 2");
            return true;
        }
        //aquí llamaremos a la función empate para ver si aparte de que no ha ganado nadie, alomejor es que hay un empate
        if(empate(tablero)){
            System.out.println("Ha habido empate");
            return true;
        }
        //si ninguna de estas condiciones se han cumplido significa que la partida continua
        return false;
    }
    public static void main(String[] args) {
        //definimos el booleano del turno de jugador1
        Scanner s = new Scanner(System.in);
        boolean turnoJugador1 = true;
        //creamos el tablero
        int[][] tablero = new int[3][3];
        //lo rellenamos de 99 (nuestros espacios en blanco)
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j]=99;
            }
        }
        //ahora ya nos metemos con la partida
        do {
            //definimos fila y columna para saber donde meter el dato
            int fila;
            int columna;
            //si el turno del jugador1 es verdadero significa que le toca al jugador1 y se efectuará su trozo de código
            if (turnoJugador1){
                System.out.println("Te toca jugador 1:");
                do {
                    //al número que nos de le restamos 1, para que coincida con el array y porque queremos que el jugador introduzca del 1 al 3
                    System.out.println("Dime un número de fila 1-3");
                    fila = s.nextInt() -1;
                    //esto se repetira hasta que sea un número del 1 al 3
                } while (fila<0 || fila > 2);
                //exactamente lo mismo con las columnas
                do {
                    System.out.println("Dime un número de columna 1-3");
                    columna = s.nextInt()-1;
                } while(columna<0 || columna > 2);
                //si el número de fila y columna coincide con que el contenido es 99 entonces insertará el número que le corresponde
                if (tablero[fila][columna] == 99){
                    //si esta condición es verdadera se acaba el turno del jugador 1 y se vuelve falso y se inserta el número que le corresponde en el tablero
                    turnoJugador1=false;
                    tablero[fila][columna]=0;
                    mostrarTablero(tablero);
                    //si acabar partid es verdadero romperemos el bucle y mostraremos el ganador con la función porque si no se hace así, se efectuaría el turno del jugador 2
                    if (acabarPartida(tablero)){
                        break;
                    }
                    //si no es igual a 99 significa que un jugador ya ha colocado ahí una ficha
                }else {
                    System.out.println("esa casilla está ocupada, prueba otra vez");
                }
            }
            //si el turno de jugador es false entonces le toca al jugador 2 y se hará lo mismo pero cambiando el valor 0 por el 1
            if (!turnoJugador1){
                System.out.println("Te toca jugador 2:");
                do {
                    System.out.println("Dime un número de fila 1-3");
                    fila = s.nextInt() -1;
                } while (fila<0 || fila > 2);
                do {
                    System.out.println("Dime un número de columna 1-3");
                    columna = s.nextInt()-1;
                } while(columna<0 || columna > 2);
                if (tablero[fila][columna] == 99){
                    tablero[fila][columna]=1;
                    //aquí no haría falta añadir la función acabar partida porque ya lo comprueba al final del do while
                    turnoJugador1=true;
                    mostrarTablero(tablero);
                }else {
                    System.out.println("esa casilla está ocupada, prueba otra vez");
                }
            }
        }while (!acabarPartida(tablero));
    }
}
