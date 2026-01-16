package vista;

import modelo.Personaje;
import modelo.habilidades.Habilidades;

//esta es la clase que gestiona el combate, recibe 2 objetos de la clase personaje como luchadores y una vista
//la vista es para mostrar diferentes mensajes
public class Combate {
    private Personaje luchador1;
    private Personaje luchador2;
    private Vista vista;

    //constructor - inicia el combate con la función inicioCombate()

    public Combate(Personaje luchador1, Personaje luchador2, Vista vista) {
        this.luchador1 = luchador1;
        this.luchador2 = luchador2;
        this.vista = vista;
        inicioCombate();
    }

    public Personaje getLuchador1() {
        return luchador1;
    }

    public Personaje getLuchador2() {
        return luchador2;
    }

    //Esta es la función que gestiona el combate

    public void inicioCombate(){
        //se reinician las estadísticas de luchador 1 y luchador 2
        luchador1.resetearStats();
        luchador2.resetearStats();
        // aqui empieza un bucle while comprobando si ha terminado el combate o no
        while (!haTerminado()) {
            //se ejecuta el turno del luchador 1
            turno(luchador1, luchador2);
            //comprueba si alguno de los 2 ha muerto
            if (haTerminado()) break;
            //se ejecuta el turno del luchador 2
            turno(luchador2, luchador1);
        }
        // una vez que ha salido del bucle llama a la función de la vista que muestra quien ha ganado
        vista.mostrarMensajeVictoria(luchador1,luchador2);
    }
    //esta es la función que gestiona el turno completo, le pasas el luchador y el personaje que hace de enemigo
    public void turno(Personaje luchador, Personaje enemigo){
        //comprueba y aplica los estados alterados
        luchador.comprobarEstados();
        luchador.aplicarEstados();
        //muestra el luchador y el enemigo haciendo uso de la vista:
        System.out.printf("=====================================%n");
        System.out.printf("TU: %n");
        vista.mostrarPersonaje(luchador);
        System.out.printf("=====================================%n");
        System.out.printf("Enemigo: %n");
        vista.mostrarPersonaje(enemigo);
        //muestra el menú de acciones para ejecutar
        vista.mostrarMenuAcciones();
        int opcion = vista.pedirOpcion();
        //comprueba si hay habilidades usables y si no se usa atacar como opción
        if (!hayHabilidadUsable(luchador)){
            System.out.println("No hay habilidades usables, se usará atacar como opción");
            opcion = 1;
        }

        switch (opcion){
            case 1:
                //usa el ataque basico del personaje con el enemigo como objetivo
                luchador.ataqueBasico(enemigo);
                break;
            case 2:
                //definimos válido para comprobar si la habilidad es válida
                boolean valido;
                //se empieza un bucle que se repetirá si válido es false
                do {
                    //muestra las habilidades del luchador
                    System.out.printf("=====================================%n");
                    vista.mostrarHabilidades(luchador);
                    System.out.printf("=====================================%n");
                    System.out.println("elige la habilidad por índice");
                    //selecciona la habilidad por el índice
                    Habilidades habilidadSeleccionada = luchador.getHabilidades().get(vista.pedirOpcion());
                    //comprueba si le quedan usos y si le quedan usos es válida
                    valido = comprobarUsos(luchador,habilidadSeleccionada);
                    //si es válida la ejecuta dependiendo del tipo que sea la habilidad hace un recibir daño o curar vida
                    if (valido){
                        if (habilidadSeleccionada.getTipo().equals("curación")){
                            luchador.curarVida(habilidadSeleccionada.usarHabilidad(luchador));
                            luchador.disminuirCosto(habilidadSeleccionada.getTipo());
                        }else{
                            enemigo.recibirDanio(habilidadSeleccionada.usarHabilidad(luchador));
                            luchador.disminuirCosto(habilidadSeleccionada.getTipo());
                        }
                    }
                } while (!valido);
            break;
            default:
                System.out.println("no has elegido la opción correcta");
        }
    }
    //determina si el combate ha terminado comprobando si es <= 0 la vida actual de cualquiera de los 2
    public boolean haTerminado(){
        return getLuchador1().getEstadisticas().getVidaActual() <= 0 || getLuchador2().getEstadisticas().getVidaActual() <= 0;
    }
    //comprueba si el personaje tiene usos de ese tipo de habilidad
    public Boolean comprobarUsos(Personaje personaje, Habilidades habilidad){
        String tipo = habilidad.getTipo();
        if (tipo.equals("melee") && personaje.getEstadisticas().getMelee() <= 0){
            return false;
        } else if (tipo.equals("curación") && personaje.getEstadisticas().getCuracion() <=0) {
            return false;
        } else if (tipo.equals("distancia") && personaje.getEstadisticas().getHabilidadDistancia() <=0) {
            return false;
        }
        return true;
    }
    //comprueba si hay habilidades usables comparando que sean <= 0 los usos del personaje
    public Boolean hayHabilidadUsable(Personaje personaje){
        if (personaje.getEstadisticas().getMelee() <= 0 && personaje.getEstadisticas().getCuracion() <= 0 && personaje.getEstadisticas().getHabilidadDistancia() <=0){
            return false;
        }
        return true;
    }
}
