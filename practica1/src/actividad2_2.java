import java.util.Scanner;

public class actividad2_2 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Dime un numero del 1 al 7");
        int dia = s.nextInt();
        int diaF = dia - 1;
        String[] dias = {"lunes", "martes", "miercoles","jueves", "viernes", "sabado", "domingo"};
        for (int i = 0; i < dias.length; i++){
            if (diaF == i) {
                System.out.println("Ese dia corresponde a " + dias[i]);
                break;
            } else if (diaF < 1 || diaF > 7){
                System.out.println("Has escrito mal el día procura no usar mayúsculas ni tildes");
                break;
            }
        }
    }
}
