import java.util.Scanner;

public class actividad1_6 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int y = s.nextInt();
        int suma =x+y;
        int resta = x-y;
        int mult = x*y;
        double divi = (double) x/y;
        System.out.println("la suma es "+suma);
        System.out.println("la suma es "+resta);
        System.out.println("la multiplicación es "+mult);
        System.out.println("la división es "+divi);
    }
}
