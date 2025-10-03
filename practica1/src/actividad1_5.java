import java.util.Scanner;

public class actividad1_5 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        double peseta = s.nextDouble();
        double euro = 0.006;
        double euroF = peseta*euro;
        System.out.println(peseta+" pesetas son "+euroF+" euros");
    }
}
