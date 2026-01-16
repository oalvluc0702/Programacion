package modelo;
import modelo.clases.Clase;
import modelo.estadosAlterados.Estados;
import modelo.habilidades.Habilidades;
import modelo.razas.Raza;

import java.util.ArrayList;
//Esta es la clase que gestiona como va a ser un personaje, un personaje va a tener un nombre, una clase,
//una raza, unas estadísticas, una lista de habilidades y una lista de estados alterados
public class Personaje {
    private String nombre;
    private Clase clase;
    private Raza raza;
    private Estadisticas estadisticas;
    private ArrayList<Habilidades> habilidades;
    private ArrayList<Estados> estados;
    //constructor - solo le pasamos nombre, clase y raza, ya que el resto de atributos se rellenerán de x forma usando los metodos de la raza y la clase
    public Personaje(String nombre, Clase clase, Raza raza) {
        this.nombre = nombre;
        this.clase = clase;
        this.raza = raza;
        //aqui generamos la lista de estados alterados, por ahora vacía
        this.estados = new ArrayList<>();
        //creamos un conjunto de estadísticas a priori vacías
        this.estadisticas = new Estadisticas();
        //con el metodo de la raza establecemos las estadísticas base pasándole las estadísticas de este objeto
        raza.establecerEstadisticasBase(this.estadisticas);
        //creamos la lista de habilidades vacía
        this.habilidades = new ArrayList<>();
        //con el metodo de la clase agregar bonificaciónClase pasándole este objeto personaje añadirá los modificadores referentes a la clase
        this.clase.agregarBonificacionClase(this);
        //y ahora agrega a la lista de habilidades del personaje las habilidades que le corresponden por clase
        this.clase.agregarHabilidad(this);
    }

    //getters y setters
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

    //Función que se encarga de que el personaje reciba daño sin que su vida baje de 0
    public void recibirDanio(int danio){
        int vidaActual = this.getEstadisticas().getVidaActual() - danio;
        //aquí se hace la comprobación para poner 0 si su vida es menor que 0 y en caso contrario pondrá el valor restado
        int vidaFinal = (vidaActual < 0) ? 0 : vidaActual;
        this.getEstadisticas().setVidaActual(vidaFinal);
    }
    //Función que se encarga de curar vida al personaje, si el total de la cantidad curada supera a la vida máxima se pondrá ese valor
    //si no se pondrá el monto de la cantidad curada
    public void curarVida(int cura){
        int vidaActual = this.getEstadisticas().getVidaActual() + cura;
        //aquí se realiza la comprobación
        int vidaFinal = (vidaActual > this.getEstadisticas().getVida()) ? this.getEstadisticas().getVida() : vidaActual;
        this.getEstadisticas().setVidaActual(vidaFinal);
    }
    //disminuye el tipo de costo sin que baje de 0 según el tipo que le pases
    public void disminuirCosto(String tipo){
        switch (tipo) {
            //si el tipo de la habilidad es melee
            case "melee" -> {
                int numeroMelee = this.getEstadisticas().getMelee() - 1;
                int melee = (numeroMelee < 0) ? 0 : numeroMelee;
                this.getEstadisticas().setMelee(melee);
            }
            //si es curación
            case "curación" -> {
                int numeroCuracion = this.getEstadisticas().getCuracion() - 1;
                int curacion = (numeroCuracion < 0) ? 0 : numeroCuracion;
                this.getEstadisticas().setCuracion(curacion);
            }
            //si es distancia, aunque sea una habilidad "ultimate" tambien la categorizamos a distancia por comodidad
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

        //se crea una lista con los estados a eliminar utilizando la función haFinalizado de la clase Estados
        //si ha finalizado se agrega a la lista
        ArrayList<Estados> estadosAEliminar = new ArrayList<>();
        for (Estados estados: this.getEstados()){
            if (estados.haFinalizado()){
                estadosAEliminar.add(estados);
            }
        }
        //ahora recorremos la lista de estados a eliminar llamando a la funcion finalizaEstado para eliminar ese estado de la lista
        //de estados alterados que posee el personaje
        for (Estados estadosEliminar: estadosAEliminar){
            this.finalizaEstado(estadosEliminar);
        }
    }
    //recorre los estados alterados utilizando la función del estado aplicarEfecto para aplicar todos los efectos
    public void aplicarEstados(){
        for (Estados estado: this.getEstados()){
            estado.aplicarEfecto(this);
            //cuando se aplica un estado lo suyo es que tambien disminuya su duración
            estado.disminuirDuracion();
        }
    }
    //resetea las stats de los personajes para utilizarlo en combate y que se puedan hacer combates con los mismos personajes sin
    //mantener los cambios del combate anterior
    public void resetearStats(){
        this.getEstadisticas().setMelee(5);
        this.getEstadisticas().setCuracion(3);
        this.getEstadisticas().setHabilidadDistancia(1);
        this.getEstadisticas().setVidaActual(this.getEstadisticas().getVida());
    }
    //función que sirve para ejecutar un ataque básico en el combate más adelante
    public void ataqueBasico(Personaje enemigo){
        Dado dado = new Dado();
        int danio = dado.tirar(10) + this.getEstadisticas().getFuerza();
        enemigo.recibirDanio(danio);
        System.out.println("Le has causado a tu enemigo: "+ danio+" puntos de salud");
    }
}
