import java.util.Scanner;

/*Realizar el juego de la “Búsqueda del tesoro” donde si te acercas al tesoro te va avisando de
que hay un tesoro cerca pero agregando que tenemos dos posibles tesoros en el juego y
uno de ellos es un impostor */
public class ejercicio8 {

    //Este es la función que se va a encargar de mostrar el tablero completo
    public static void mostrarTablero(int[][] tablero){
        for (int i = 0; i < tablero.length; i++) {
            //el número 0 equivale a espacio en blanco, el número 1 equivale a tesoro falso y el 2 equivale a tesoro verdadero
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
    //esta es la función que te muestra tu posición y con el tesoro tapado, tanto el falso como el verdadero
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
    //esta función es la función que comprueba si la posición inicial y la posición de inicio sean válidas
    public static boolean esValido(int posActualY, int posActualX, int[][]tablero){
        //comparamos que las posiciones no sean ni menores ni mayores que la longitud del tablero
        if (posActualX >= 0 && posActualX < tablero.length && posActualY >= 0 && posActualY <tablero[0].length){
            return true;
        }
        return false;
    }
    //esta función va a comprobar que la posición concuerde con la siguiente posición y si encuentra un tesoro falso o verdadero acaba la partida
    public static boolean acabarPartida(int[][] tablero, int posActualY, int posActualX){
        int posicion = tablero[posActualY][posActualX];
        //si la posición es igual a tesoro verdadero o tesoro falso entonces devolvemos que acabar partida sea verdadero
        if (posicion == 1 || posicion == 2){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        //definimos todas las variables que vamos a usar
        // las casillas es el tablero principalmente
        int casillas = 10;
        //intentos va a contar el número de intentos totales que te ha costado encontrar el tesoro, o perdido por el tesoro falso
        int intentos = 0;
        //calculamos aleatoriamente donde van a caer los tesoros
        int x = (int) (Math.random() * casillas);
        int y = (int) (Math.random() * casillas);
        int posXFalso = x;
        int posYFalso = y;
        //creamos el tablero y metemos el tesoro falso
        int[][] tablero = new int[casillas][casillas];
        tablero[y][x] = 1;
        Scanner s = new Scanner(System.in);
        //ahora vamos a calcular el tesoro verdadero, que no puede caer en la misma casilla que el tesoro falso
        do {
            x = (int) (Math.random() * casillas);
            y = (int) (Math.random() * casillas);
        } while (tablero[y][x] == 1);
        int posXTesoro = x;
        int posYTesoro = y;
        //guardamos el tesoro verdadero
        tablero[y][x] = 2;
        //ahora vamos a pedir donde quieres empezar a jugar
        System.out.println("Dime una posición donde quieras empezar en la fila del 0 al 9");
        int posActualX = s.nextInt();
        System.out.println("Dime una posición donde quieras empezar en la columna del 0 al 9");
        int posActualY = s.nextInt();
        //con la función esvalido, validamos que la posición donde vamos a empezar entre en el tablero, si no entra vamos a repetir la pregunta
        while (!esValido(posActualY,posActualX,tablero)){
            System.out.println("esa posición no es válida vuelve a intentarlos");
            System.out.println("Dime una posición donde quieras empezar en la fila del 0 al 9");
            posActualX = s.nextInt();
            System.out.println("Dime una posición donde quieras empezar en la columna del 0 al 9");
            posActualY = s.nextInt();
        }
        //comprobamos si por casualidad hemos caído en alguno de los 2 tesoros
        int posicionInicial = tablero[posActualY][posActualX];
        if (posicionInicial == 1) {
            mostrarTablero(tablero);
            System.out.printf("%s has tardado: %d","☠ ¡Empezaste sobre el tesoro falso! Has perdido.",intentos);
            return;
        } else if (posicionInicial == 2) {
            mostrarTablero(tablero);
            System.out.printf("%s has tardado: %d","💰 ¡Empezaste sobre el tesoro verdadero! ¡Has ganado!", intentos);
            return;
        }
        //si no hemos caído vamos a guardar con valor de 3 a nuestro personaje, que en este caso es un lorito
        tablero[posActualY][posActualX] = 3;
        // ahora vamos a calcular las distancias que hay entre el tesoro falso y el tesoro normal para decir si está cerca
        //el metodo Math.abs() nos permite abstraer de negativos y positivos, por lo cual restando la posición del tesoro con la actual en X y sumarla con la misma resta pero en Y
        //Ganamos la distancia real que tenemos del tesoro (tuve que buscar esta fórmula en internet pero es bastante sencilla)
        int distancia = Math.abs(posXTesoro - posActualX) + Math.abs(posYTesoro - posActualY);
        int distanciaFalso = Math.abs(posXFalso - posActualX) + Math.abs(posYFalso - posActualY);
        //Si la distancia es menor o igual que 1 significa que estamos cerca del tesoro, si no pues estaremos lejos
        if (distancia <=1 || distanciaFalso <=1){
            System.out.println("estas cerca... Pero ten cuidado podría ser un cofre falso");
        } else {
            System.out.println("Aún estás muy lejos del cofre");
        }
        //aqui mostramos el tablero para saber donde estamos
        mostrarTableroParcial(tablero);
        //este do while se encarga del movimiento del loro
        do {
            //nos pregunta para donde nos vamos a mover y le tenemos que dar un número
            System.out.println("dime para donde te quieres mover: 1=arriba, 2=abajo, 3=izquierda, 4=derecha");
            int movimiento = s.nextInt();
            //lo registramos y guardamos la posición que ya teníamos
            int posActualYAnterior = posActualY;
            int posActualXAnterior = posActualX;
            //con este switch case hacemos los movimientos
            switch (movimiento) {
                //para cada movimiento vamos a comprobar si ese movimiento que se quiere hacer es válido con la función que ya tenemos hecha
                case 1:
                    if (esValido(posActualY - 1, posActualX, tablero)) {
                        //si es válido hacemos la operación
                        posActualY = posActualY - 1;
                    } else {
                        //si no es válido mostraremos un mensaje de error y se repetirá al final
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
                //ahora comprobamos la posición de destino y dependiendo de lo que contenga esa posición mostraremos su mensaje pertinente
                    int posicionDestino = tablero[posActualY][posActualX];
            //si el contenido de posicionDestino es igual a 1 perderemos, si es igual a 2 ganaremos y si no seguiremos moviendonos
                    if (posicionDestino == 1) {
                        intentos++;
                        mostrarTablero(tablero);
                        System.out.println("☠ Te has encontrado con un tesoro falso, Has perdido");
                        System.out.printf("has tardado: %d intentos",intentos);
                    } else if (posicionDestino == 2) {
                        intentos++;
                        mostrarTablero(tablero);
                        System.out.println("💰 HAS ENCONTRADO EL TESORO!!! FELICIDADES HAS GANADO!!!!");
                        System.out.printf("has tardado: %d intentos",intentos);
                    } else {
                        //si no es ni 1 ni 2 incrementamos los intentos ponemos el valor de 0 en las posicion anterior y cambiaremos la posición por el 3, que es el lorito
                        intentos++;
                        tablero[posActualYAnterior][posActualXAnterior] = 0;
                        tablero[posActualY][posActualX] = 3;
                        mostrarTableroParcial(tablero);
                        //volvemos a calcular la distancia y hacemos la misma comprobación de antes, el cálculo de la distancia, podría ser una función perfectamente.
                        distancia = Math.abs(posXTesoro - posActualX) + Math.abs(posYTesoro - posActualY);
                        distanciaFalso = Math.abs(posXFalso - posActualX) + Math.abs(posYFalso - posActualY);
                        if (distancia <=1 || distanciaFalso <=1){
                            System.out.println("estas cerca... Pero ten cuidado podría ser un cofre falso");
                        } else {
                            System.out.println("Aún estás muy lejos del cofre");
                        }
                    }
                    //este bucle se repite mientras que acabar partida sea false
        } while (!acabarPartida(tablero, posActualY, posActualX));
    }
}

