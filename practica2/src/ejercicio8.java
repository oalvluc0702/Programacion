import java.util.Scanner;

public class ejercicio8 {
    public static void main(String[] args){
        int tamañoAlt;
        Scanner s = new Scanner(System.in);
        boolean positivo = false;
        do {
            System.out.println("dime un número de personas que vas a medir");
            tamañoAlt = s.nextInt();
            if (tamañoAlt >= 0){
                positivo=true;
            } else{
                System.out.println("El número debe ser positivo");
            }
        } while (!positivo);

        double[] alt = new double[tamañoAlt];
        double sumaAlt = 0;
        for (int i = 0; i < alt.length; i++) {
            System.out.println("Dime una altura formato x.xx");
            alt[i] = s.nextDouble();
            sumaAlt += alt[i];
        }
        double media = (double)

    }
}
