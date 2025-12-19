package clases;

public class Mago extends Clase {
    private int bonusInteligencia = 3;
    private int bonusVidaMaxima= 90;
    public Mago() {
    }

    @Override
    public int getBonusInteligencia() {
        return bonusInteligencia;
    }

    @Override
    public int getBonusVidaMaxima() {
        return bonusVidaMaxima;
    }
}
