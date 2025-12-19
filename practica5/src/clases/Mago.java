package clases;

import habilidades.iCuracionMedia;
import razas.Personaje;

public class Mago extends Clase implements iCuracionMedia {
    public Mago() {
        super(0,3,0,90);
    }
    @Override
    public void curacionMedia(Personaje objetivo, Personaje lanzador) {
        int inteligenciaLanzador = lanzador.getInteligencia();
        int potenciaCuracion=4;
        int psCurados=inteligenciaLanzador*potenciaCuracion;
        int curacionRealizada = objetivo.getVidaActual()+psCurados;
        if (curacionRealizada >= objetivo.getVidaMaxima()){
            objetivo.setVidaActual(objetivo.getVidaMaxima());
        } else {
            objetivo.setVidaActual(curacionRealizada);
        }
    }
}
