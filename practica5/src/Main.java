import clases.Mago;
import razas.Humano;
import habilidades.*;
public class Main{
    public static void main(String[] args){
        Humano oscar = new Humano("oscar",new Mago());
        System.out.println(oscar.getInteligencia());
        ((iCuracionMedia)oscar.getClase()).curacionMedia(oscar,oscar);
    }
}