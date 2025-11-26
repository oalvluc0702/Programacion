public class Contratos {
    private int fechaCreacion;
    private Hospital hospital;
    private Medico medico;

    public Contratos() {
    }

    public Contratos(int fechaCreacion, Hospital hospital, Medico medico) {
        this.fechaCreacion = fechaCreacion;
        this.hospital = hospital;
        this.medico = medico;
        this.hospital.agregarContrato(this);
    }

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
    public boolean esDeAnio(int anio){
        return this.getFechaCreacion() == anio;
    }
    //debido a que no vamos a usar el time entonces no voy a hacer el cálculo de vigencia en torno a los días, si referente a los años.
    public int aniosDesdeCreacion(){
        return java.time.Year.now().getValue() - this.fechaCreacion;
    }

}
