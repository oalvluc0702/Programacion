import modelo.clases.Picaro;
import modelo.clases.Sacerdote;
import modelo.habilidades.Habilidades;
import modelo.razas.Humano;
import modelo.Personaje;
public class Main{
    public static void main(String[] args){
        Personaje oscar = new Personaje("oscar",new Picaro(),new Humano());
        Personaje maria = new Personaje("maria",new Sacerdote(),new Humano());
        System.out.println(oscar.getEstadisticas().toString());
        System.out.println(maria.getEstadisticas().toString());
        for (Habilidades habilidades: oscar.getHabilidades()){
            System.out.printf("Nombre: %s | Tipo: %s | Potencia: %d \n",habilidades.getNombre(),habilidades.getTipo(),habilidades.getPotencia());
        }
        for (Habilidades habilidades: maria.getHabilidades()){
            System.out.printf("Nombre: %s | Tipo: %s | Potencia: %d \n",habilidades.getNombre(),habilidades.getTipo(),habilidades.getPotencia());
        }
        for (Habilidades habilidades: oscar.getHabilidades()){
            if (habilidades.getNombre().equals("Golpe")){
                habilidades.usarHabilidad(oscar, maria);
            }
        }
        System.out.println(maria.getEstadisticas().toString());
        System.out.println(oscar.getEstadisticas().toString());
    }
}
