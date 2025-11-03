import java.util.Scanner;

/*Realizar el juego de la “Búsqueda del tesoro” donde si te acercas al tesoro te va avisando de
que hay un tesoro cerca pero agregando que tenemos dos posibles tesoros en el juego y
uno de ellos es un impostor */
public class ejercicio8 {
    public static void mostrarTablero(int[][] tablero){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == 0){
                    System.out.printf("%-6s","⛱");
                }

                if (tablero[i][j] == 1){
                    System.out.printf("%-6s","☠");
                }
                if (tablero[i][j] == 2){
                    System.out.printf("%-6s","\uD83D\uDCB0");
                }
                if (tablero[i][j] == 3){
                    System.out.printf("%-6s","\uD83E\uDD9C");
                }
            }
            System.out.printf("%n");
        }
    }
    public static void mostrarTableroParcial(int[][] tablero){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == 0 || tablero[i][j] == 1 || tablero[i][j] == 2  ){
                    System.out.printf("%-6s","⛱");
                }
                if (tablero[i][j] == 3){
                    System.out.printf("%-6s","\uD83E\uDD9C");
                }
            }
            System.out.printf("%n");
        }
    }
    public static boolean esValido(int posActualY, int posActualX, int[][]tablero){
        if (posActualX >= 0 && posActualX < tablero.length && posActualY >= 0 && posActualY <tablero[0].length){
            return true;
        }
        return false;
    }
    public static boolean acabarPartida(int[][] tablero, int posActualY, int posActualX){
        int posicion = tablero[posActualY][posActualX];
        if (posicion == 1 || posicion == 2){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int x = (int) (Math.random() * 5);
        int y = (int) (Math.random() * 5);
        int posXFalso = x;
        int posYFalso = y;
        int[][] tablero = new int[5][5];
        tablero[y][x] = 1;
        Scanner s = new Scanner(System.in);
        do {
            x = (int) (Math.random() * 5);
            y = (int) (Math.random() * 5);
        } while (tablero[y][x] == 1);
        int posXTesoro = x;
        int posYTesoro = y;
        tablero[y][x] = 2;
        System.out.println("Dime una posición donde quieras empezar en la fila del 0 al 4");
        int posActualX = s.nextInt();
        System.out.println("Dime una posición donde quieras empezar en la columna del 0 al 4");
        int posActualY = s.nextInt();

        int posicionInicial = tablero[posActualY][posActualX];
        if (posicionInicial == 1) {
            mostrarTablero(tablero);
            System.out.println("☠ ¡Empezaste sobre el tesoro falso! Has perdido.");
            return;
        } else if (posicionInicial == 2) {
            mostrarTablero(tablero);
            System.out.println("💰 ¡Empezaste sobre el tesoro verdadero! ¡Has ganado!");
            return;
        }
        tablero[posActualY][posActualX] = 3;
        int distancia=Math.abs((posXTesoro-posActualX)+(posYTesoro-posActualY));
        int distanciaFalso=Math.abs((posXFalso-posActualX)+(posYFalso-posActualY));
        if (distancia <=2 || distanciaFalso <=2){
            System.out.println("estas cerca... Pero ten cuidado podría ser un cofre falso");
        } else {
            System.out.println("Aún estás muy lejos del cofre");
        }
        mostrarTableroParcial(tablero);
        do {
            System.out.println("dime para donde te quieres mover: 1=arriba, 2=abajo, 3=izquierda, 4=derecha");
            int movimiento = s.nextInt();
            int posActualYAnterior = posActualY;
            int posActualXAnterior = posActualX;
            switch (movimiento) {
                case 1:
                    if (esValido(posActualY - 1, posActualX, tablero)) {
                        posActualY = posActualY - 1;
                    } else {
                        System.out.println("Ese valor está fuera del tablero, vuelve a intentarlo");
                    }
                    break;
                case 2:
                    if (esValido(posActualY + 1, posActualX, tablero)) {
                        posActualY = posActualY + 1;
                    } else {
                        System.out.println("Ese valor está fuera del tablero, vuelve a intentarlo");
                    }
                    break;
                case 3:
                    if (esValido(posActualY, posActualX - 1, tablero)) {
                        posActualX = posActualX - 1;
                    } else {
                        System.out.println("Ese valor está fuera del tablero, vuelve a intentarlo");
                    }
                    break;
                case 4:
                    if (esValido(posActualY, posActualX + 1, tablero)) {
                        posActualX = posActualX + 1;
                    } else {
                        System.out.println("Ese valor está fuera del tablero, vuelve a intentarlo");
                    }
                    break;
                default:
                    System.out.println("Tiene que ser 1-4");
                }
                    int posicionDestino = tablero[posActualY][posActualX];
                    if (posicionDestino == 1) {
                        mostrarTablero(tablero);
                        System.out.println("☠ Te has encontrado con un tesoro falso, Has perdido");
                    } else if (posicionDestino == 2) {
                        mostrarTablero(tablero);
                        System.out.println("💰 HAS ENCONTRADO EL TESORO!!! FELICIDADES HAS GANADO!!!!");
                    } else {
                        tablero[posActualYAnterior][posActualXAnterior] = 0;
                        tablero[posActualY][posActualX] = 3;
                        mostrarTableroParcial(tablero);
                        distancia=Math.abs((posXTesoro-posActualX)+(posYTesoro-posActualY));
                        distanciaFalso=Math.abs((posXFalso-posActualX)+(posYFalso-posActualY));
                        if (distancia <=2 || distanciaFalso <=2){
                            System.out.println("estas cerca... Pero ten cuidado podría ser un cofre falso");
                        } else {
                            System.out.println("Aún estás muy lejos del cofre");
                        }
                    }
        } while (!acabarPartida(tablero, posActualY, posActualX));
    }
}

