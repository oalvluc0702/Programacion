import java.util.Scanner;

public class actividad1_7 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Dime la base");
        double base = s.nextDouble();
        System.out.println("Dime la altura");
        double altura = s.nextDouble();
        double area = base*altura;
        System.out.println("el area del rectángulo "+area+" metros cuadrados");

    }
}
