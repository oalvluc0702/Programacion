import java.util.Scanner;

public class ejercicio12 {
    public static void main(String[] args){
        //definimos clase Scanner y el array de letras, que he conseguido de la tabla del ministerio por lo cual es real
        Scanner s = new Scanner(System.in);
        String[] letra={"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
        //pide el número por pantalla y lo guarda en una variable para luego operar con el y calcular la letra
        System.out.println("Dime tu número de DNI sin letra");
        int num= s.nextInt();

        //le hacemos el módulo para saber su resto de una división entre 23
        int pos= num % 23;

        //la letra del DNI va a ser igual a la posicion del array letra
        String letraDni=letra[pos];

        //Ahora lo imprimimos por pantalla
        System.out.printf("tu letra de Dni es la %s",letraDni);
    }
}
