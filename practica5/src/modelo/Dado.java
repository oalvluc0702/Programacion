package modelo;
//Esta clase es la que se encarga de crear un dado para realizar las tiradas aleatorias
public class Dado {

    //constructor

    public Dado() {
    }
    //Esta función se encarga de hacer una tirada con el número de caras que le pasas
    public int tirar(int caras){
        return (int) (Math.random() * caras) + 1;
    }
    //utiliza la función tirar para hacer varias tiradas segun la cantidad de tiradas que le pases y el número de caras.
    public int tirarVarios(int cantidad, int caras ){
        int total = 0;
        for (int i = 0; i < cantidad; i++) {
            total += tirar(caras);
        }
        return total;
    }
}
