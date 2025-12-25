package modelo;

public class Dado {
    public Dado() {
    }
    public int tirar(int caras){
        return (int) (Math.random() * caras) + 1;
    }
    public int tirarVarios(int cantidad, int caras ){
        int total = 0;
        for (int i = 0; i < cantidad; i++) {
            total += tirar(caras);
        }
        return total;
    }
}
