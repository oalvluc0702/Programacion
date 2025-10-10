import java.util.Scanner;

public class ejercicio10Bi {
    public static void main(String[] args){
        //Definimos la clase Scanner y el array bidimensional con el que vamos a guardar los datos
        Scanner s = new Scanner(System.in);
        String[][] estudianteNota= {{"Óscar","10"},{"Gorka","10"},{"Mario","7"},{"",""}};

        //Ahora pedimos los datos y los almacenamos en el array bidimensional.
        System.out.println("dime un el nombre del alumno");
        estudianteNota[3][0] = s.nextLine();

        System.out.println("Dime la nota de programación");
        estudianteNota[3][1]  = s.nextLine();

        //ahora imprimimos por pantalla el alumno más su nota.
        System.out.printf("El alumno %s tiene nota: %s",estudianteNota[3][0],estudianteNota[3][1]);
    }
}
