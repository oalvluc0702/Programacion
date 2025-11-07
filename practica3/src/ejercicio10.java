import java.util.Scanner;

public class ejercicio10 {
    public static void mostrarTablero(int[][] tablero){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
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
    public static boolean acabarPartida(int[][] tablero){
        for (int i = 0; i < tablero.length; i++) {
            int sumaFila = 0;
            for (int j = 0; j < tablero[i].length; j++) {
               int numeroActual=tablero[i][j];
                sumaFila+=numeroActual;
            }
            if (sumaFila == 0){
               System.out.println("Ha ganado el jugador 1");
               return true;
            } else if (sumaFila == 3) {
                System.out.println("Ha ganado el jugador 2");
                return true;
            }
        }
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
        int diagonal1= tablero[0][0]+tablero[1][1]+tablero[2][2];
        int diagonal2= tablero[0][2]+tablero[1][1]+tablero[2][0];
        if (diagonal1 == 0 || diagonal2 == 0 ){
            System.out.println("Ha ganado el jugador 1");
            return true;
        } else if(diagonal2 == 3 || diagonal1 == 3){
            System.out.println("Ha ganado el jugador 2");
            return true;
        }
        if(empate(tablero)){
            System.out.println("Ha habido empate");
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean turnoJugador1 = true;
        int[][] tablero = new int[3][3];
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j]=99;
            }
        }
        do {
            int fila;
            int columna;
            if (turnoJugador1){
                System.out.println("Te toca jugador 1:");
                do {
                    System.out.println("Dime un número de fila 1-3");
                    fila = s.nextInt() -1;
                } while (fila<0 || fila > 2);
                do {
                    System.out.println("Dime un número de columna 1-3");
                    columna = s.nextInt()-1;
                } while(columna<0 || columna > 2);
                if (tablero[fila][columna] == 99){
                    turnoJugador1=false;
                    tablero[fila][columna]=0;
                    mostrarTablero(tablero);
                    if (acabarPartida(tablero)){
                        break;
                    }
                }else {
                    System.out.println("esa casilla está ocupada, prueba otra vez");
                }
            }
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
                    turnoJugador1=true;
                    mostrarTablero(tablero);
                }else {
                    System.out.println("esa casilla está ocupada, prueba otra vez");
                }
            }
        }while (!acabarPartida(tablero));
    }
}
