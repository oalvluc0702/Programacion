import java.util.Scanner;

public class actividad2_3 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        System.out.println("Dime el primer número entero");
        int primer = s.nextInt();

        System.out.println("Dime el segundo número entero");
        int segun = s.nextInt();

        System.out.println("Dime el tercer número entero");
        int tercer = s.nextInt();


            if (primer < segun && segun > tercer){
                System.out.println("Numeros ordenados de mayor a menor:");
                System.out.println(segun);

                if (primer < tercer){
                    System.out.println(tercer);
                    System.out.println(primer);

                } else {
                    System.out.println(primer);
                    System.out.println(tercer);

                }


            } else if (primer > segun && primer > tercer) {
                System.out.println("Numeros ordenados de mayor a menor:");
                System.out.println(primer);

                if (segun < tercer){
                    System.out.println(tercer);
                    System.out.println(segun);

                } else {
                    System.out.println(segun);
                    System.out.println(tercer);

                }

            } else if (primer < tercer && segun < tercer) {
                System.out.println("Numeros ordenados de mayor a menor:");
                System.out.println(tercer);

                if ( segun < primer ){
                    System.out.println(primer);
                    System.out.println(segun);

                } else {
                    System.out.println(segun);
                    System.out.println(primer);

                }

            }
        }
    }