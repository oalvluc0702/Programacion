package clases;

public class Clase {
    private int bonusFuerza = 0;
    private int bonusInteligencia = 0;
    private int bonusDestreza= 0;
    private int bonusVidaMaxima= 0;

    public Clase(int bonusFuerza, int bonusInteligencia, int bonusDestreza, int bonusVidaMaxima) {
        this.bonusFuerza = bonusFuerza;
        this.bonusInteligencia = bonusInteligencia;
        this.bonusDestreza = bonusDestreza;
        this.bonusVidaMaxima = bonusVidaMaxima;
    }

    public int getBonusFuerza() {
        return bonusFuerza;
    }

    public void setBonusFuerza(int bonusFuerza) {
        this.bonusFuerza = bonusFuerza;
    }

    public int getBonusInteligencia() {
        return bonusInteligencia;
    }

    public void setBonusInteligencia(int bonusInteligencia) {
        this.bonusInteligencia = bonusInteligencia;
    }

    public int getBonusDestreza() {
        return bonusDestreza;
    }

    public void setBonusDestreza(int bonusDestreza) {
        this.bonusDestreza = bonusDestreza;
    }

    public int getBonusVidaMaxima() {
        return bonusVidaMaxima;
    }

    public void setBonusVidaMaxima(int bonusVidaMaxima) {
        this.bonusVidaMaxima = bonusVidaMaxima;
    }
}
