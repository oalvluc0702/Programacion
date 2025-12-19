package razas;
import clases.Clase;

public class Personaje {
    private String nombre;
    private Clase clase;
    private int fuerza;
    private int inteligencia;
    private int destreza;
    private int vidaMaxima;
    private int vidaActual;
 ;

    public Personaje(String nombre, Clase clase, int fuerza, int inteligencia, int destreza, int vidaMaxima) {
        this.nombre = nombre;
        this.clase = clase;
        this.fuerza = fuerza + clase.getBonusFuerza();
        this.inteligencia = inteligencia + clase.getBonusInteligencia();
        this.destreza = destreza + clase.getBonusDestreza();
        this.vidaMaxima = vidaMaxima + clase.getBonusVidaMaxima();
        this.vidaActual = vidaMaxima;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }

}
