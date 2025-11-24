import java.util.ArrayList;
import java.util.Scanner;

public class MenuGestor {
    private int creadorHospital = 0;
    private int creadorArea = 0;
    private ArrayList<Hospital> listaHospitales = new ArrayList<>();
    private ArrayList<Areas> listaAreas = new ArrayList<>();
    public MenuGestor() {
    }
    Scanner s = new Scanner(System.in);
    public Direccion crearDireccion(){
        System.out.println("Dime una calle");
        String calle = s.nextLine();
        System.out.println("Dime un numero");
        int numero = s.nextInt();
        System.out.println("Dime un código postal");
        int codPost = s.nextInt();
        System.out.println("Dime una localidad ");
        String localidad = s.nextLine();
        s.nextLine();
        System.out.println("Dime una provincia");
        String provincia = s.nextLine();
        return new Direccion(calle, numero, codPost, localidad, provincia);
    }
    public void crearHospital(String hospitalDado, Direccion direccionDada){
        String cif;
        boolean encontrado;
        do {
            cif = "HOSP" + creadorHospital;
            encontrado = false;
            for (Hospital h : listaHospitales) {
                if (h.getCif().equals(cif)) {
                    encontrado = true;
                    creadorHospital++;
                    break;
                }
            }
        } while (encontrado);
        Hospital hosp = new Hospital(cif, hospitalDado, direccionDada);
        creadorHospital++;
        listaHospitales.add(hosp);
    }
    public Areas crearArea(Hospital hosp, String nombre){
        s.nextLine();
        boolean encontrado;
        do {
            encontrado = false;
            for (Areas a : listaAreas) {
                if (a.getIdentificador() == creadorArea) {
                    encontrado = true;
                    creadorArea++;
                    break;
                }
            }
        } while (encontrado);
        int identificador = creadorArea;
        System.out.println("Dime una planta");
        int planta = s.nextInt();
        return new Areas(nombre,identificador,hosp,planta);
    }
    public void presentacion(){
        boolean salir = false;
        do {
            System.out.println("------------1.Crear Hospital------------");
            System.out.println("------------2.Crear Área------------");
            System.out.println("------------3.Crear Médico------------");
            System.out.println("------------4.Modificar médico------------");
            System.out.println("------------5.Modificar Hospital------------");
            System.out.println("------------6.Calcular antiguedad------------");
            System.out.println("------------7.Calcular sueldo neto------------");
            System.out.println("------------8.Comprobar edad------------");
            System.out.println("------------9.Proporción de Médicos------------");
            System.out.println("------------10.Capacidad de Área------------");
            System.out.println("------------11.Comparar Áreas------------");
            System.out.println("------------12.Contratos por Año------------");

            System.out.println("----------------------------------------");
            System.out.println("------------Elige opción------------");
            int eleccion = s.nextInt();
            s.nextLine();
                switch (eleccion) {
                    case 1:
                        System.out.println("dime el nombre del hospital");
                        String hospitalDado = s.nextLine();
                        Direccion direccionDada = crearDireccion();
                        crearHospital(hospitalDado, direccionDada);
                        break;
                    case 2:
                        if (listaHospitales.isEmpty()){
                            System.out.println("no existen hospitales a los cuales agregar un área");
                        } else {
                            System.out.println("dime el nombre del área a crear");
                            String nomArea = s.nextLine();
                            for (int i = 0; i < listaHospitales.size(); i++) {
                                Hospital hospital = listaHospitales.get(i);
                                System.out.println(i+". Hospital: "+hospital.getCif()+" "+hospital.getNombre());
                            }
                            System.out.println("elige el hospital al que va a pertenecer el área (un número de los que están listados)");
                            int indice = s.nextInt();
                            Hospital hospitalElegido = listaHospitales.get(indice);
                            Areas areaNueva = crearArea(hospitalElegido, nomArea);
                            listaAreas.add(areaNueva);
                        }
                        break;
                    case 3:

                        break;
                }
        } while (!salir);
    }
}
