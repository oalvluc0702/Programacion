import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuGestor {
    private int creadorHospital = 0;
    private int creadorArea = 0;
    private ArrayList<Hospital> listaHospitales = new ArrayList<>();
    private ArrayList<Areas> listaAreas = new ArrayList<>();
    private ArrayList<Medico> listaMedicos = new ArrayList<>();
    private ArrayList<Contratos> listaContratos = new ArrayList<>();
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
        s.nextLine();
        System.out.println("Dime una localidad ");
        String localidad = s.nextLine();
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

    public Medico crearMedico(Direccion direccion){
        System.out.println("Dime el dni del médico");
        String dni = s.nextLine();
        System.out.println("Dime la edad del médico");
        int edad = s.nextInt();
        s.nextLine();
        System.out.println("Dime el sueldo bruto del médico");
        double sueldoBruto = s.nextDouble();
        s.nextLine();
        System.out.println("Dime el nombre del médico");
        String nombre = s.nextLine();
        System.out.println("Dime el sexo del médico");
        String sexo = s.nextLine();
        int fechaInicio = Year.now().getValue();
        for (int i = 0; i < listaAreas.size(); i++) {
            Areas area = listaAreas.get(i);
            System.out.println(i+". area: "+area.getIdentificador()+" "+area.getNombre()+" del hospital con identificador: "+area.getCifHospital());
        }
        System.out.println("Selecciona el área al que quieras que se asigne el médico");
        int eleccion = s.nextInt();
        Areas area = listaAreas.get(eleccion);
        return new Medico(dni, edad, sueldoBruto, nombre, sexo, fechaInicio, area, direccion);
    }

    public void modificarMedico(String dni){
        Medico medicoBuscado = null;
        for (Medico med : listaMedicos){
            if (med.getDni().equals(dni)){
                medicoBuscado = med;
            }
        }
        if (medicoBuscado == null){
            System.out.println("no hay ningún médico con ese dni");
        } else {
            System.out.println("dime que quieres hacer");
            System.out.println("--------------------------------");
            System.out.println("a) Cambiar sueldo bruto");
            System.out.println("b) cambiar dirección");
            System.out.println("a) Cambiar área de trabajo");
            String eleccion = s.nextLine();
            switch (eleccion){
                case "a":
                    System.out.println("dime el nuevo sueldo bruto a cambiar");
                    double nuevoSueldoBruto = s.nextDouble();
                    medicoBuscado.setSueldoBruto(nuevoSueldoBruto);
                    break;
                case "b":
                    Direccion direccionNueva = crearDireccion();
                    medicoBuscado.setDireccion(direccionNueva);
                case "c":
                    for (int i = 0; i < listaAreas.size(); i++) {
                        Areas areas = listaAreas.get(i);
                        System.out.println(i+".- area: "+areas.getNombre()+" del hospital: "+areas.getHospital().getNombre());
                    }
                    System.out.println("Selecciona el area al cual quieres cambiar al médico");
                    int eleccionCase = s.nextInt();
                    Areas areaSeleccionada = listaAreas.get(eleccionCase);
                    medicoBuscado.cambiarArea(areaSeleccionada);
            }
        }

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
            System.out.println("------------13.Salir------------------------");
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
                        if (listaAreas.isEmpty()){
                            System.out.println("no existen áreas para asignar a un médico, si quiere crear un médico primero cree un área");

                        } else {
                            Direccion direccionMedico = crearDireccion();
                            Medico medico = crearMedico(direccionMedico);
                            Contratos contrato = new Contratos(Year.now().getValue(), medico.getAreas().getHospital(),medico);
                            listaMedicos.add(medico);
                            listaContratos.add(contrato);
                        }
                        break;
                    case 4:
                        if (listaMedicos.isEmpty()){
                            System.out.println("no hay medicos creados");
                        } else {
                            System.out.println("dime un dni");
                            String dni = s.nextLine();
                            modificarMedico(dni);
                        }
                        break;
                    case 13:
                        salir=true;
                        break;
                }
        } while (!salir);
    }
}
