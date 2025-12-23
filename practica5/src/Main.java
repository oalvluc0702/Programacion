
import clases.Bardo;
import habilidades.Habilidades;
import razas.Humano;
import razas.Personaje;
public class Main{
    public static void main(String[] args){
        Personaje oscar = new Personaje("oscar",new Bardo(),new Humano());
        System.out.println(oscar.getEstadisticas().toString());
        for (Habilidades habilidades: oscar.getHabilidades()){
            System.out.printf("Nombre: %s | Tipo: %s | Potencia: %d \n",habilidades.getNombre(),habilidades.getTipo(),habilidades.getPotencia());
        }
    }
}