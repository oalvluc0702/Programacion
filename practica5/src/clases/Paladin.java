package clases;
import habilidades.iCuracionMenor;
import razas.Personaje;

public class Paladin extends Clase implements iCuracionMenor{
    public Paladin(){
        super(2,1,0,115);
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
