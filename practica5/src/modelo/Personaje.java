package modelo;
import modelo.clases.Clase;
import modelo.estadosAlterados.Estados;
import modelo.habilidades.Habilidades;
import modelo.razas.Raza;

import java.util.ArrayList;

public class Personaje {
    private String nombre;
    private Clase clase;
    private Raza raza;
    private Estadisticas estadisticas;
    private ArrayList<Habilidades> habilidades;
    private ArrayList<Estados> estados;
    public Personaje(String nombre, Clase clase, Raza raza) {
        this.nombre = nombre;
        this.clase = clase;
        this.raza = raza;
        this.estados = new ArrayList<>();
        this.estadisticas = new Estadisticas();
        raza.establecerEstadisticasBase(this.estadisticas);
        this.habilidades = new ArrayList<>();
        this.clase.agregarBonificacionClase(this);
        this.clase.agregarHabilidad(this);
    }

    public ArrayList<Estados> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<Estados> estados) {
        this.estados = estados;
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

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public Estadisticas getEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(Estadisticas estadisticas) {
        this.estadisticas = estadisticas;
    }

    public ArrayList<Habilidades> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<Habilidades> habilidades) {
        this.habilidades = habilidades;
    }
    public void recibirDanio(int danio){
        int vidaActual = this.getEstadisticas().getVidaActual() - danio;
        int vidaFinal = (vidaActual < 0) ? 0 : vidaActual;
        this.getEstadisticas().setVidaActual(vidaFinal);
    }
    public void curarVida(int cura){
        int vidaActual = this.getEstadisticas().getVidaActual() + cura;
        int vidaFinal = (vidaActual > this.getEstadisticas().getVida()) ? this.getEstadisticas().getVida() : vidaActual;
        this.getEstadisticas().setVidaActual(vidaFinal);
    }
    //disminuye el tipo de costo sin que baje de 0 según el tipo que le pases
    public void disminuirCosto(String tipo){
        switch (tipo) {
            case "melee" -> {
                int numeroMelee = this.getEstadisticas().getMelee() - 1;
                int melee = (numeroMelee < 0) ? 0 : numeroMelee;
                this.getEstadisticas().setMelee(melee);
            }
            case "curación" -> {
                int numeroCuracion = this.getEstadisticas().getCuracion() - 1;
                int curacion = (numeroCuracion < 0) ? 0 : numeroCuracion;
                this.getEstadisticas().setCuracion(curacion);
            }
            case "distancia" -> {
                int numeroDistancia = this.getEstadisticas().getHabilidadDistancia() - 1;
                int distancia = (numeroDistancia < 0) ? 0 : numeroDistancia;
                this.getEstadisticas().setHabilidadDistancia(distancia);
            }
        }
    }
    //añade un estado alterado a la lista de estados de personaje
    public void agregarEstado(Estados estado){
        this.getEstados().add(estado);
    }
    //finaliza el estado quitandolo de la lista
    public void finalizaEstado(Estados estado){
        this.getEstados().remove(estado);
    }
    //Comprueba los estados alterados y si han acabado los elimina con la funcion finalizaEstado
    public void comprobarEstados(){
        ArrayList<Estados> estadosAEliminar = new ArrayList<>();
        for (Estados estados: this.getEstados()){
            if (estados.haFinalizado()){
                estadosAEliminar.add(estados);
            }
        }
        for (Estados estadosEliminar: estadosAEliminar){
            this.finalizaEstado(estadosEliminar);
        }
    }
    public void aplicarEstados(){
        for (Estados estado: this.getEstados()){
            estado.aplicarEfecto(this);
            estado.disminuirDuracion();
        }
    }
    public void resetearStats(){
        this.getEstadisticas().setMelee(5);
        this.getEstadisticas().setCuracion(3);
        this.getEstadisticas().setHabilidadDistancia(1);
        this.getEstadisticas().setVidaActual(this.getEstadisticas().getVida());
    }
    public void ataqueBasico(Personaje enemigo){
        Dado dado = new Dado();
        int danio = dado.tirar(10) + this.getEstadisticas().getFuerza();
        enemigo.recibirDanio(danio);
        System.out.println("Le has causado a tu enemigo: "+ danio+" puntos de salud");
    }
}
