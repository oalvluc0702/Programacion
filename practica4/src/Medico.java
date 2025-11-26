import java.awt.geom.Area;

public class Medico {
    private String dni;
    private int edad;
    private double sueldoBruto;
    private String nombre;
    private String sexo;
    private Areas areas;
    private int fechaInicio;
    private Direccion direccion;
    private Contratos contrato;
    public Medico() {
    }

    public Medico(String dni, int edad, double sueldoBruto, String nombre, String sexo,int fechaInicio, Areas areas, Direccion direccion) {
        this.dni = dni;
        this.edad = edad;
        this.sueldoBruto = sueldoBruto;
        this.nombre = nombre;
        this.sexo = sexo;
        this.areas = areas;
        this.fechaInicio = fechaInicio;
        this.direccion = direccion;
        areas.aumentarMedicos();
        new Contratos(this.fechaInicio,this.areas.getHospital(),this);

    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    public Contratos getContrato(){
        return this.contrato;
    }
    public double getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(double sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Areas getAreas() {
        return areas;
    }

    public int getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(int fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public void setContrato(Contratos contrato){
        this.contrato = contrato;
    }

    public void setAreas(Areas areas) {
        this.areas = areas;
    }
    public double calcularSueldoNeto(double retencion){
        return this.sueldoBruto*retencion;
    }
    public int getAniosAntiguedad(){
        return java.time.Year.now().getValue() - this.fechaInicio;
    }
    public double calcularImpuestosAnuales(double tasaImpositiva){
        return this.sueldoBruto - (this.sueldoBruto*tasaImpositiva);
    }
    public boolean esMayordeEdad(int mayoriaEdad){
        return this.edad >= mayoriaEdad;
    }
    public double  proximoAumento(double porcentajeAumento, int aniosRequeridos){
        if (getAniosAntiguedad() >= aniosRequeridos){
            return this.sueldoBruto + this.sueldoBruto * porcentajeAumento;
        } else {
            System.out.println("No cumple con los años requeridos");
            return sueldoBruto;
        }
    }
    public void cambiarArea(Areas nuevaArea){
        this.areas.disminuirMedicos();
        setAreas(nuevaArea);
        this.areas.aumentarMedicos();
    }

    @Override
    public String toString() {
        return "Medico{" +
                "dni='" + dni + '\'' +
                ", edad=" + edad +
                ", sueldoBruto=" + sueldoBruto +
                ", nombre='" + nombre + '\'' +
                ", sexo='" + sexo + '\'' +
                ", areas=" + areas +
                ", fechaInicio=" + fechaInicio +
                '}';
    }
}
