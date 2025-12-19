package clases;

import habilidades.iCuracionMayor;
import razas.Personaje;

public class Druida extends Clase implements iCuracionMayor {
    public Druida() {
        super(2,1,1,100);
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
