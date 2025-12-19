package clases;

public class Guerrero extends Clase{
    private int bonusFuerza = 3;
    private int bonusVidaMaxima= 120;
    public Guerrero() {

    }

    @Override
    public int getBonusFuerza() {
        return bonusFuerza;
    }

    @Override
    public int getBonusVidaMaxima() {
        return bonusVidaMaxima;
    }
}
