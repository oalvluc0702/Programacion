package vista;

import modelo.Personaje;
import modelo.habilidades.Habilidades;

public class Combate {
    private Personaje luchador1;
    private Personaje luchador2;
    private Vista vista;
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
    public void inicioCombate(){
        luchador1.resetearStats();
        luchador2.resetearStats();
        while (!haTerminado()) {
            turno(luchador1, luchador2);
            if (haTerminado()) break;
            turno(luchador2, luchador1);
        }
        vista.mostrarMensajeVictoria(luchador1,luchador2);
    }
    public void turno(Personaje luchador, Personaje enemigo){
        luchador.comprobarEstados();
        luchador.aplicarEstados();
        System.out.printf("=====================================%n");
        System.out.printf("TU: %n");
        vista.mostrarPersonaje(luchador);
        System.out.printf("=====================================%n");
        System.out.printf("Enemigo: %n");
        vista.mostrarPersonaje(enemigo);
        vista.mostrarMenuAcciones();
        int opcion = vista.pedirOpcion();
        if (!hayHabilidadUsable(luchador)){
            System.out.println("No hay habilidades usables, se usará atacar como opción");
            opcion = 1;
        }
        switch (opcion){
            case 1:
                luchador.ataqueBasico(enemigo);
                break;
            case 2:
                boolean valido;
                do {
                    System.out.printf("=====================================%n");
                    vista.mostrarHabilidades(luchador);
                    System.out.printf("=====================================%n");
                    System.out.println("elige la habilidad por índice");
                    Habilidades habilidadSeleccionada = luchador.getHabilidades().get(vista.pedirOpcion());
                    valido = comprobarUsos(luchador,habilidadSeleccionada);
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
    public boolean haTerminado(){
        return getLuchador1().getEstadisticas().getVidaActual() <= 0 || getLuchador2().getEstadisticas().getVidaActual() <= 0;
    }
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
    public Boolean hayHabilidadUsable(Personaje personaje){
        if (personaje.getEstadisticas().getMelee() <= 0 && personaje.getEstadisticas().getCuracion() <= 0 && personaje.getEstadisticas().getHabilidadDistancia() <=0){
            return false;
        }
        return true;
    }
}
