public class Direccion {
    private String calle;
    private int numero;
    private int codigoPostal;
    private String localidad;
    private String provincia;

    public Direccion() {
    }
    public Direccion (String calle, int numero, int codigoPostal, String localidad, String provincia){
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "calle: "+this.calle+" numero: "+this.numero+" localidad: "+this.localidad+" provincia: "+this.provincia+" codigo postal: "+this.codigoPostal;
    }
}
