import java.util.Scanner;

public class ejercicio10 {
    public static void main(String[] args){
        //definimos la clase Scanner y los array de estudiantes y notas
        Scanner s = new Scanner(System.in);
        String[] estudiantes={"Óscar","Mario","Adrián","Paconi","Gorka"};
        double[] notas={10,5,7,9,6.5,};
        //Defino la variable de estudiante solicitado y cual es la posición del último estudiante
        String estudianteSol;
        int ultimoEst= estudiantes.length - 1;

        //Pedimos por teclado el nombre del alumno
        System.out.println("Dime tu nombre de alumno");
        estudianteSol = s.nextLine();

        //Con un bucle vamos recorriendo el bucle de alumnos comprobando si es igual al nombre que nos ha solicitado
        for (int i = 0; i < estudiantes.length; i++) {

            //si lo encuentra muestra el alumno y la nota
            if (estudianteSol.equals(estudiantes[i])) {
                System.out.printf("La nota del alumno %s es: %.2f", estudiantes[i], notas[i]);
                break;
            }
            //si es la última posición y el estudiante no coincide con el campo, va a decirnos que no existe el alumno que ha solicitado
            else if (i == ultimoEst && !estudianteSol.equals(estudiantes[i])) {
                System.out.println("No existe ese alumno solicitado");
                break;
            }
        }
    }
}
