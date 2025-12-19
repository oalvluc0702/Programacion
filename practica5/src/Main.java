import clases.Mago;
import razas.Humano;

public class Main{
    public static void main(String[] args){
        Humano oscar = new Humano("oscar",new Mago());
        System.out.println(oscar.getInteligencia());
    }
}