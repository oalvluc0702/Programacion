public class Contratos {
    private String fechaCreacion;
    private Hospital hospital;
    private Medico medico;

    public Contratos() {
    }

    public Contratos(String fechaCreacion, Hospital hospital, Medico medico) {
        this.fechaCreacion = fechaCreacion;
        this.hospital = hospital;
        this.medico = medico;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
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
}
