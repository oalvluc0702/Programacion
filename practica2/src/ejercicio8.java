import java.util.Scanner;

//Ejercicio 8
/* Programa Java para leer la altura de N personas y calcular la altura media. Calcular cuántas
personas tienen una altura superior a la media y cuántas tienen una altura inferior a la
media. El valor de N se pide por teclado y debe ser entero positivo. */

public class ejercicio8 {
    public static void main(String[] args){
        //definimos la variable que va a guardar el tamaño del array alt y el scanner
        int tamañoAlt;
        Scanner s = new Scanner(System.in);
        //creamos la variable de control de nuestro bucle while que va a pedir datos por pantalla hasta que los datos sean positivos
        boolean positivo = false;
        do {
            System.out.println("dime un número de personas que vas a medir");
            tamañoAlt = s.nextInt();
            //si es mayor o igual que 0 es positivo por lo cual cambiaremos positivo a true
            if (tamañoAlt >= 0){
                positivo=true;
            } else{
                System.out.println("El número debe ser positivo");
            }
        } while (!positivo);
        //creamos el array con el tamaño del dato introducido por pantalla
        double[] alt = new double[tamañoAlt];

        //creamos nuestra variable que almacenará la suma de las alturas para después hacer la media
        double sumaAlt = 0;

        //un bucle que recorre el array alt metiendo los datos que le vamos introduciendo por teclado
        for (int i = 0; i < alt.length; i++) {
            System.out.println("Dime una altura formato x,xx");
            alt[i] = s.nextDouble();
            sumaAlt += alt[i];
        }

        //calculamos la media con el tamaño del array que van a ser todas nuestras alturas y la suma de todas ellas
        double media = (double) sumaAlt / (double) alt.length;

        //creamos las dos variables que van a controlar cuantos por debajo y por encima de la media vamos a tener
        int inferior = 0;
        int superior = 0;
        //Con un bucle recorriendo al estilo foreach vamos comparando si son mayores o menores que esa media
        for (double v : alt) {
            if (v < media) {
                inferior++;
            } else if (v > media) {
                superior++;
            }
        }
        // ya por ultimo sacamos los datos por pantalla formateados con un printf.
        System.out.printf("La media es %.2f CM y hay %d personas que son superiores a la media y %d personas inferiores a la media",media,superior,inferior);
    }
}
