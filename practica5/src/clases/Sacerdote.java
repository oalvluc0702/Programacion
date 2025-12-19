package clases;

import habilidades.*;
import razas.Personaje;

public class Sacerdote extends Clase implements iCuracionMayor {
    public Sacerdote() {
        super(0,3,0,95);
    }
    @Override
    public void curacionMayor(Personaje objetivo, Personaje lanzador) {
        int inteligenciaLanzador = lanzador.getInteligencia();
        int potenciaCuracion=8;
        int psCurados=inteligenciaLanzador*potenciaCuracion;
        int curacionRealizada = objetivo.getVidaActual()+psCurados;
        if (curacionRealizada >= objetivo.getVidaMaxima()){
            objetivo.setVidaActual(objetivo.getVidaMaxima());
        } else {
            objetivo.setVidaActual(curacionRealizada);
        }
    }
}
