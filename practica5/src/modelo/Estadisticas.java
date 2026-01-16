package modelo;
//Esta es la clase de la que se componen las estadísticas de los personajes
//se compone de fuerza, inteligencia, destreza, la vida máxima, la vida actual, y los usos de las habilidades, que va a ser global del personaje, no de las habilidades.

public class Estadisticas {
    private int fuerza;
    private int inteligencia;
    private int destreza;
    private int vida;
    private int vidaActual;
    private int melee;
    private int curacion;
    private int habilidadDistancia;
    // en el constructor fijaremos el número de usos a los que nos pide la practica, melee 5, curación 3 y habilidad a distancia o definitiva 1.
    public Estadisticas() {
        this.setMelee(5);
        this.setCuracion(3);
        this.setHabilidadDistancia(1);
    }
    //getters y setters
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

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }

    public int getMelee() {
        return melee;
    }

    public void setMelee(int melee) {
        this.melee = melee;
    }

    public int getCuracion() {
        return curacion;
    }

    public void setCuracion(int curacion) {
        this.curacion = curacion;
    }

    public int getHabilidadDistancia() {
        return habilidadDistancia;
    }

    public void setHabilidadDistancia(int habilidadDistancia) {
        this.habilidadDistancia = habilidadDistancia;
    }

    @Override
    public String toString() {
        return "Estadisticas{" +
                "fuerza=" + fuerza +
                ", inteligencia=" + inteligencia +
                ", destreza=" + destreza +
                ", vida=" + vida +
                ", vidaActual=" + vidaActual +
                ", melee=" + melee +
                ", curacion=" + curacion +
                ", habilidadDistancia=" + habilidadDistancia +
                '}';
    }
}
