import java.util.Scanner;

public class ejercicio10Bi {
    public static void main(String[] args){
        //Definimos la clase Scanner y el array bidimensional con el que residen los datos
        Scanner s = new Scanner(System.in);
        String[][] estudianteNota= {{"Óscar","10"},{"Gorka","10"},{"Mario","7"}};

        //guardamos el estudiante que pide por pantalla en una variable
        System.out.println("dime un el nombre del alumno");
        String estudianteSol = s.nextLine();
        //guardamos la ultima posicion del array en una variable
        int ultimoEst = estudianteNota.length -1;
        //ahora recorremos el array bidimensional comparando si los los nombres son iguales que la entrada
        for (int i = 0; i < estudianteNota.length; i++) {
            if (estudianteSol.equals(estudianteNota[i][0])){
                System.out.printf("La nota del alumno %s es: %s",estudianteNota[i][0],estudianteNota[i][1]);
                break;
            }
            //si no lo encuentra en la ultima iteración te muestra por pantalla un texto explicativo
            else if (i == ultimoEst && !estudianteSol.equals(estudianteNota[i][0])) {
                System.out.println("No existe el alumno solicitado");
            }
        }
    }
}
