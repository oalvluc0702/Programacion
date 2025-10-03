import java.util.Scanner;

public class actividad2_1 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        boolean exit = false;

        while(!exit){
            System.out.println("Dime una hora del 0 al 23 (cualquier otra = exit)");

            double horaT = s.nextInt();

            if (horaT >= 6 && horaT <= 12) {
                System.out.println("Buenos días");

            } else if (horaT >= 13 && horaT <= 20) {
                System.out.println("Buenas tardes");

            } else if (horaT >= 21 && horaT <= 23) {
                System.out.println("Buenas noches");

            } else if (horaT >= 0 && horaT <= 5) {
                System.out.println("Buenas noches");

            } else{
                exit = true;
                break;
            }
        }
    }
}
