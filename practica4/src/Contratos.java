//----------------------------DEFINICIÓN DE LA CLASE-------------------------------------
public class Contratos {
    private int fechaCreacion;
    private Hospital hospital;
    private Medico medico;

    //------------------------------CONSTRUCTORES UNO VACÍO Y OTRO CON DATOS-----------------------------
    public Contratos() {
    }

    public Contratos(int fechaCreacion, Hospital hospital, Medico medico) {
        this.fechaCreacion = fechaCreacion;
        this.hospital = hospital;
        this.medico = medico;
        // AQUÍ AGREGA EL CONTRATO CREADO AL HOSPITAL REFERENCIADO
        this.hospital.agregarContrato(this);
    }
    //--------------------------------CREACIÓN DE LOS MÉTODOS GET Y SET----------------------------
    public int getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(int fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    //---------------------------------------------FUNCIONALIDADES-----------------------------------------

    // recibe un año y devuelve verdadero o falso si coincide con la fecha de creación del objeto
    public boolean esDeAnio(int anio){
        return this.getFechaCreacion() == anio;
    }
    //devuelve el lapso de tiempo utilizando el valor del año actual y calcula la diferencia con la fecha de creación
    public int aniosDesdeCreacion(){
        return java.time.Year.now().getValue() - this.fechaCreacion;
    }

}
