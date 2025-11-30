import java.lang.reflect.Array;
import java.util.ArrayList;
//----------------------------DEFINICIÓN DE LA CLASE-------------------------------------

public class Hospital {
    private String cif;
    private String nombre;
    private ArrayList<Areas> areas;
    private Direccion direccion;
    private ArrayList<Contratos> contratos;
    public Hospital() {
    }
    //----------------------------CREACIÓN DEL CONSTRUCTOR CON LOS DATOS-------------------------------------
    public Hospital(String cif, String nombre, Direccion direccion) {
        this.cif = cif;
        this.nombre = nombre;
        this.direccion = direccion;
        this.areas = new ArrayList<>();
        this.contratos = new ArrayList<>();
    }
    //----------------------------DEFINICIÓN DE LOS MÉTODOS GET Y SET-------------------------------------
    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
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
    public void agregarContrato(Contratos contratos) {
        this.contratos.add(contratos);
    }
    public int getNumeroTotalMedicos(){
        int sumaMedicos = 0;
        for (int i = 0; i<this.areas.size(); i++){
            sumaMedicos+=this.areas.get(i).getNumMedicos();
        }
        return sumaMedicos;
    }
    public double getProporcionMedicosArea(Areas areas){
        return (double) areas.getNumMedicos() / (double) this.getNumeroTotalMedicos();
    }
    public boolean existeArea(int idArea){
        for (int i = 0; i < this.areas.size(); i++) {
            if(this.areas.get(i).getIdentificador() == idArea){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.cif+" "+this.nombre+" "+this.direccion;
    }
}

