import java.util.Scanner;

public class actividad1_8 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Dime un día de la semana");
        String dia = s.nextLine();
        String[] dias = {"lunes", "martes", "miercoles","jueves", "viernes", "sabado", "domingo"};
        String[] asignaturas = {"digitalización", "Sistemas informáticos", "Sistemas informáticos", "Sistemas informáticos",
                "programación", "Felicidades no hay clase", "Felicidades no hay clase"};
        for (int i = 0; i < dias.length; i++) {
            if (dia.equals(dias[i]) == true) {
                System.out.println(asignaturas[i]);
                break;
            } else {
                System.out.println("Has escrito mal el día procura no usar mayúsculas ni tildes");
                break;
            }
        }
    }
}
