package clases;

import habilidades.iCuracionMenor;
import razas.Personaje;

public class Guerrero extends Clase implements iCuracionMenor {

    public Guerrero() {
        super(3,0,0,120);
    }

    @Override
    public void curacionMenor(Personaje objetivo, Personaje lanzador) {
        int inteligenciaLanzador = lanzador.getInteligencia();
        int potenciaCuracion=2;
        int psCurados=inteligenciaLanzador*potenciaCuracion;
        int curacionRealizada = objetivo.getVidaActual()+psCurados;
        if (curacionRealizada >= objetivo.getVidaMaxima()){
            objetivo.setVidaActual(objetivo.getVidaMaxima());
        } else {
            objetivo.setVidaActual(curacionRealizada);
        }
    }
}
