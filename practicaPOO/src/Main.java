import java.util.Scanner;

public class Main{
    public static void validarRegistro(Usuario[] listaUsuarios){
        for (int i = 0; i < listaUsuarios.length; i++) {
            if (!listaUsuarios[i].getCodPostal().startsWith("28")){
                System.out.printf("%s bloqueado, código postal no permitido%n",listaUsuarios[i].getNombre());
            } else {
                System.out.println("El usuario "+listaUsuarios[i].getNombre()+" es valido");
            }
        }
    }
    public static void main() {
        Scanner s = new Scanner(System.in);
        Usuario oscar = new Usuario("oscar","Alvarez Lucas","28630","Calle panamá, 8, 2-I","oscarieshungria@gmail.com","1234");
        Usuario mario = new Usuario("Mario","Escribano Cózar","28620","Calle Algar, 5","Mescrico@gmail.com","123456");
        Usuario freezer = new Usuario("Freezer", "Zarbon Dodoria","99999","Planeta Namek, 2","freezerdbz@namek.sol","damelasbolasdedragon123");
        Usuario[] listaUsuarios={oscar,mario,freezer};
        validarRegistro(listaUsuarios);
        String email;
        do {
            System.out.println("dime el correo: ");
            email = s.nextLine();
            if (!email.equals(oscar.getEmail())){
                System.out.println("El correo que debes introducir es: "+oscar.getEmail());
            }
        }while (!email.equals(oscar.getEmail()));
        System.out.println("dime la contraseña para el correo: "+email);
        String passwd = s.nextLine();
        if (oscar.checkUsuario(email,passwd)){
            System.out.println("Sesión iniciada");
        } else {
            System.out.printf("ERROR contraseña incorrecta para %s%n",oscar.getEmail());
        }
        do {
            System.out.println("dime el correo: ");
            email = s.nextLine();
            if (!email.equals(mario.getEmail())){
                System.out.println("El correo que debes introducir es: "+mario.getEmail());
            }
        }while (!email.equals(mario.getEmail()));
        if (mario.checkUsuario(email,passwd)){
            System.out.println("Sesión iniciada para"+mario.getNombre());
        } else {
            System.out.printf("ERROR contraseña incorrecta para %s",mario.getEmail());
        }

    }
}


