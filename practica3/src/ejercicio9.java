import java.util.Scanner;

public class ejercicio9 {
    public static void mostrarTablero(String[][] conjunto){
        for (int i = 0; i < conjunto.length; i++) {
            for (int j = 0; j < conjunto[i].length; j++) {
                System.out.printf("%-10s",conjunto[i][j]);
            }
            System.out.printf("%n");
        }
    }
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
    public static void resultado(String caballo, String[][] conjunto){
        int[] movFila={-2,-1,1,2,2,1,-1,-2};
        int[] movColumna={1,2,2,1,-1,-2,-2,-1};
        int posFila=-1;
        int posColumna=-1;
        for (int i = 0; i < conjunto.length; i++) {
            for (int j = 0; j < conjunto[i].length; j++) {
                if (caballo.equalsIgnoreCase(conjunto[i][j])){
                     posFila= i;
                     posColumna=j;
                     break;
                }
            }
        }
        System.out.print("El caballo puede moverse a las siguientes posiciones ");
        for (int k = 0; k < movFila.length; k++) {
            int posibleFila= posFila+movFila[k];
            int posibleColumna= posColumna+movColumna[k];
            if (posibleFila >=0 && posibleFila < conjunto.length && posibleColumna >=0 && posibleColumna < conjunto.length){
                System.out.printf("%s ",conjunto[posibleFila][posibleColumna]);
            }
        }
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[] columnas={"A","B","C","D","E","F","G","H"};
        String[] filas={"8","7","6","5","4","3","2","1",};
        String[][] conjunto = new String[8][8];
        for (int i = 0; i < conjunto.length; i++) {
            for (int j = 0; j < conjunto[i].length; j++) {
                String casilla=columnas[j]+filas[i];
                conjunto[i][j]=casilla;
            }
        }
        mostrarTablero(conjunto);
        System.out.println("Dime la posición donde quieres introducir el caballo");
        String caballo = s.nextLine();
        while(!encontrarNumero(conjunto,caballo)) {
            System.out.println("Esa posición no es válida, vuelve a pedir");
            caballo = s.nextLine();
        }
        resultado(caballo,conjunto);
    }
}
