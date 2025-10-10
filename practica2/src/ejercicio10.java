import java.util.Scanner;

public class ejercicio10 {
    public static void main(String[] args){
        //definimos la clase Scanner y los array de estudiantes y notass
        Scanner s = new Scanner(System.in);
        String[] estudiantes={"Óscar","Mario","Adrián","Paconi","Gorka"," "};
        double[] notas={10,5,7,9,6.5,0};

        //Pedimos por pantalla el nombre del alumno y la nota en la posición placeholder.
        System.out.println("Dime tu nombre de alumno");
        estudiantes[5] = s.nextLine();
        System.out.println("Dime tu nota en programación");
        notas[5] = s.nextDouble();

        //Imprimimos por pantalla la nota del alumno y su nombre

        System.out.printf("La nota del alumno %s es: %.2f",estudiantes[5],notas[5]);
    }
}
