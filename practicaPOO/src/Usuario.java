public class Usuario {
    private  String nombre;
    private  String apellidos;
    private  String codPostal;
    private  String direccion;
    private  String email;
    private  String contrasena;

    public Usuario(String nom, String ape, String codP, String direc, String correo, String passwd){
        nombre = nom;
        apellidos = ape;
        codPostal = codP;
        direccion = direc;
        email = correo;
        contrasena = passwd;
    }

    public static String getApellidos() {
        return apellidos;
    }

    public static String getCodPostal() {
        return codPostal;
    }

    public static String getNombre() {
        return nombre;
    }

    public static String getDireccion() {
        return direccion;
    }

    public static String getEmail() {
        return email;
    }

    public static String getContrasena() {
        return contrasena;
    }

    public static void setNombre(String nombre) {
        Usuario.nombre = nombre;
    }

    public static void setApellidos(String apellidos) {
        Usuario.apellidos = apellidos;
    }

    public static void setCodPostal(String codPostal) {
        Usuario.codPostal = codPostal;
    }

    public static void setContrasena(String contrasena) {
        Usuario.contrasena = contrasena;
    }

    public static void setDireccion(String direccion) {
        Usuario.direccion = direccion;
    }

    public static void setEmail(String email) {
        if (email.contains("@")){
            Usuario.email =
        }
    }
}
