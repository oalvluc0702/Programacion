import org.w3c.dom.ls.LSOutput;

public class Areas {
    private String nombre;
    private int identificador;
    private Hospital hospital;
    private int numMedicos;
    private int planta;

    public Areas() {
    }

    public Areas(String nombre, int identificador, Hospital hospital, int planta) {
        this.nombre = nombre;
        this.identificador = identificador;
        this.hospital = hospital;
        this.planta = planta;
        this.numMedicos = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public Hospital getCifHospital() {
        return hospital;
    }

    public void setCifHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public int getNumMedicos() {
        return numMedicos;
    }

    public void setNumMedicos(int numMedicos) {
        this.numMedicos = numMedicos;
    }
    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }
    public void aumentarMedicos(){
        numMedicos++;
    }
    public void disminuirMedicos(){
        numMedicos--;
    }
    public String compararMedicos(Areas otraArea){
        int diferenciaAreas;
        if (otraArea.numMedicos > this.numMedicos){
            return "El área "+otraArea.getNombre()+" tiene más médicos que el área "+this.getNombre();
        } else if (otraArea.numMedicos < this.numMedicos){
            return "El área "+otraArea.getNombre()+" tiene menos médicos que el área "+this.getNombre();
        } else {
            return "Los dos áreas tienen los mismos médicos";
        }
    }
    public int calcularCapacidadRestante( int capacidadMaxima){
        return capacidadMaxima-this.numMedicos;
    }

    @Override
    public String toString() {
        return "Areas{" +
                "nombre='" + nombre + '\'' +
                ", identificador=" + identificador +
                ", hospital=" + hospital +
                ", numMedicos=" + numMedicos +
                ", planta=" + planta +
                '}';
    }
}
