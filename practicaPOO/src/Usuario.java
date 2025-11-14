public class Usuario {
    private String nombre;
    private String apellidos;
    private String codPostal;
    private String direccion;
    private String email;
    private String contrasena;

    public Usuario(String nom, String ape, String codP, String direc, String correo, String passwd){
        nombre = nom;
        apellidos = ape;
        codPostal = codP;
        direccion = direc;
        email = correo;
        contrasena = passwd;
    }

    public String getApellidos() {
        return apellidos;
    }

    public  String getCodPostal() {
        return codPostal;
    }

    public  String getNombre() {
        return nombre;
    }

    public  String getDireccion() {
        return direccion;
    }

    public  String getEmail() {
        return email;
    }

    public  String getContrasena() {
        return contrasena;
    }

    public  void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public  void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public  void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public  void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public  void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public  void setEmail(String email) {
        if (email.contains("@")){
            this.email = email;
        } else {
            System.out.println("Error: Email inválido. No contiene @.");
        }
    }
    public boolean checkUsuario(String correo, String passwd){
        if (this.email.equals(correo) && this.contrasena.equals(passwd)){
            return true;
        }
        return false;
    }
    public String toString(){
        return " nombre: "+this.nombre+" apellidos: "+this.apellidos+" direccion: "+this.direccion+" código postal: "+this.codPostal+" email: "+this.email;
    }
}
