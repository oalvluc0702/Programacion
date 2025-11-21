import java.util.ArrayList;

public class Hospital {
    private String cif;
    private String nombre;
    private ArrayList<Areas> areas;


    public Hospital() {
    }

    public Hospital(String cif, String nombre) {
        this.cif = cif;
        this.nombre = nombre;
        this.areas = new ArrayList<>();
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Areas> getAreas() {
        return areas;
    }

    public void agregarArea(Areas areas) {
        this.areas.add(areas);
    }
    public int getNumeroTotalMedicos(){
        int sumaMedicos = 0;
        for (int i = 0; i<this.areas.size(); i++){
            sumaMedicos+=this.areas.get(i).getNumMedicos();
        }
        return sumaMedicos;
    }
    public double getProporcionMedicosArea(Areas areas){
        return (double) areas.getNumMedicos() / (double) (this.getNumeroTotalMedicos());
    }
    public boolean existeArea(int idArea){
        for (int i = 0; i < this.areas.size(); i++) {
            if(this.areas.get(i).getIdentificador() == idArea){
                return true;
            }
        }
        return false;
    }

}

