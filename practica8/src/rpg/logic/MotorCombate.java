package rpg.logic;


import rpg.model.Personajes;
import rpg.ui.Vista;

public class MotorCombate {
    private Personajes luchador1;
    private Personajes luchador2;
    private Vista vista;

    public MotorCombate(Personajes luchador1, Personajes luchador2, Vista vista) {
        this.luchador1 = luchador1;
        this.luchador2 = luchador2;
        this.vista = vista;
    }

}
