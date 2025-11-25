import java.awt.geom.Area;
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
    Direccion direccion1 = new Direccion("Calle panamá",8,11630,"Arcos de la frontera","Provincia");
    Hospital h1 = new Hospital("HOSP0","Maria Zambrano", direccion1);
    Areas a1 = new Areas("medicina",0,h1,2);
    Medico m1 = new Medico("32913620E",22,2400,"Óscar Álvarez Lucas","hombre",2015,a1,direccion1);
    public MenuGestor() {
    }
    Scanner s = new Scanner(System.in);
    public Medico buscarMedico(String dni){
        for (Medico listaMedico : listaMedicos) {
            if (listaMedico.getDni().equals(dni)) {
                return listaMedico;
            }
        }
        return null;
    }
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
    public void modificarHospital(){
        for (int i = 0; i < listaHospitales.size(); i++) {
            Hospital hospital = listaHospitales.get(i);
            System.out.println(i+".- CIF: "+hospital.getCif()+" nombre: "+hospital.getNombre());
        }
        System.out.println("Elige un hospital: ");
        int eleccion = s.nextInt();
        s.nextLine(); //limpia el buffer del int para que no salte el salto de línea
        Hospital hospitalSeleccionado = listaHospitales.get(eleccion);
        System.out.println("Dime que quieres hacer");
        System.out.println("1.- Modificar nombre");
        System.out.println("2.- Modificar dirección");
        System.out.println("3.- Cancelar operación");
        String seleccion = s.nextLine();
        switch (seleccion){
            case "1":
                System.out.println("Dime el nombre que quieres asignar al hospital");
                String nombre = s.nextLine();
                hospitalSeleccionado.setNombre(nombre);
                break;
            case "2":
                Direccion nuevaDireccion = crearDireccion();
                hospitalSeleccionado.setDireccion(nuevaDireccion);
                break;
            case "3":
                break;
            default:
                System.out.println("Debe seleccionar una opción");
                break;
        }
    }
    public void calcularAntiguedad(){
        System.out.println("dime un dni");
        String dni = s.nextLine();
        Medico medicoEncontrado = buscarMedico(dni);
        if (medicoEncontrado == null){
            System.out.println("no existe ningún médico con ese DNI");
        }else {
            System.out.println("Los años de antigüedad del médico: "+medicoEncontrado.getNombre()+" son: "+ medicoEncontrado.getAniosAntiguedad());
        }
    }
    public void calcularSueldoNeto(){
        double retencion;
        System.out.println("dime un dni para calcular sueldo neto");
        String dni = s.nextLine();
        Medico medicoEncontrado = buscarMedico(dni);
        if (medicoEncontrado == null){
            System.out.println("no existe ningún médico con ese DNI");
        }else{
            do {
                System.out.println("dime el porcentaje de retención en numero con decimales ej: 0,4");
                retencion = s.nextDouble();
                s.nextLine(); // limpieza del buffer del double
                if (retencion < 0){
                    System.out.println("Has introducido un valor negativo, tiene que ser positivo");
                }
            } while (retencion <0);
            System.out.println("El sueldo neto del médico: "+medicoEncontrado.getNombre()+ " es: "+medicoEncontrado.calcularSueldoNeto(retencion)+ "€");
        }
    }
    public void comprobarEdad(){
        System.out.println("dime un dni para comprobar edad");
        String dni = s.nextLine();
        Medico medicoEncontrado = buscarMedico(dni);
        if (medicoEncontrado == null){
            System.out.println("no existe el médico");
        } else {
            System.out.println("introduce la edad mínima de tu país para ser mayor de edad");
            int edadMinima = s.nextInt();
            if (medicoEncontrado.esMayordeEdad(edadMinima)){
                System.out.println("Es mayor de edad");
            } else {
                System.out.println("Es menor de edad");
            }
        }

    }
    public void calcularProporcionMedicos(){
        Areas areaSeleccionada = null;
        Hospital hospitalSeleccionado= null;
        System.out.println("Dime el cif del Hospital del que quieres seleccionar el área");
        String cifHospital = s.nextLine();
        for (int i = 0; i < listaHospitales.size(); i++) {
            if (listaHospitales.get(i).getCif().equals(cifHospital)){
                hospitalSeleccionado = listaHospitales.get(i);
            }
        }
        for (int i = 0; i < listaAreas.size(); i++) {
            Areas areas = listaAreas.get(i);
            if (areas.getHospital().getCif().equals(cifHospital)){
                System.out.printf("| %-3s | %-25s |%n",i,"ID: "+areas.getIdentificador());
            }
        }
        System.out.println("Ahora dime el id del área, escribe el valor al lado de ID");
        int id = s.nextInt();
        for (int i = 0; i < listaAreas.size(); i++) {
            if (listaAreas.get(i).getIdentificador() == id){
                areaSeleccionada = listaAreas.get(i);
            }
        }
        if (hospitalSeleccionado == null || areaSeleccionada == null){
            System.out.println("Tienes que haber seleccionado un hospital o área");
        } else{
            System.out.println("El hospital: "+hospitalSeleccionado.getNombre()+ " tiene una proporción de médicos en el area del: "+hospitalSeleccionado.getProporcionMedicosArea(areaSeleccionada));
        }
    }
    public void presentacion(){
        listaHospitales.add(h1);
        listaAreas.add(a1);
        h1.agregarArea(a1);
        listaMedicos.add(m1);

        boolean salir = false;
        do {
            System.out.println("+---------------------------------+");
            System.out.printf("| %-3s | %-25s |%n", "1", "Crear Hospital");
            System.out.printf("| %-3s | %-25s |%n", "2", "Crear Area");
            System.out.printf("| %-3s | %-25s |%n", "3", "Crear Médico");
            System.out.printf("| %-3s | %-25s |%n", "4", "Modificar Médico");
            System.out.printf("| %-3s | %-25s |%n", "5", "Modificar Hospital");
            System.out.printf("| %-3s | %-25s |%n", "6", "Calcular antigüedad");
            System.out.printf("| %-3s | %-25s |%n", "7", "Calcular sueldo neto");
            System.out.printf("| %-3s | %-25s |%n", "8", "Comprobar edad");
            System.out.printf("| %-3s | %-25s |%n", "9", "Proporción de Médicos");
            System.out.printf("| %-3s | %-25s |%n", "10", "Capacidad de Área");
            System.out.printf("| %-3s | %-25s |%n", "11", "Comparar Áreas");
            System.out.printf("| %-3s | %-25s |%n", "12", "Contratos por Año");
            System.out.printf("| %-3s | %-25s |%n", "13", "Salir");
            System.out.println("+---------------------------------+");
            System.out.printf("| %-3s | %-25s |%n", "", "Elige opción");
            System.out.println("+---------------------------------+");

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
                            hospitalElegido.agregarArea(areaNueva);
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
                    case 5:
                        if (listaHospitales.isEmpty()){
                            System.out.println("no hay hospitales creados");
                        } else {
                            modificarHospital();
                        }
                        break;
                    case 6:
                        if (listaMedicos.isEmpty()){
                            System.out.println("no existen médicos para calcular su antiguedad, crea algún médico");
                        }else {
                            calcularAntiguedad();
                        }
                        break;
                    case 7:
                        if (listaMedicos.isEmpty()){
                            System.out.println("no existen médicos");
                        } else {
                            calcularSueldoNeto();
                        }
                        break;
                    case 8:
                        if (listaMedicos.isEmpty()){
                            System.out.println("no existen médicos");
                        } else {
                            comprobarEdad();
                        }
                        break;
                    case 9:
                            if (listaHospitales.isEmpty() || listaAreas.isEmpty()){
                                System.out.println("no hay hospitales o áreas creadas, asegurese de que hay tanto hospitales como áreas creadas");
                            } else {
                                calcularProporcionMedicos();
                            }
                            break;
                    case 13:
                        salir=true;
                        break;
                    default:
                        System.out.println("debe seleccionar una de las opciones disponibles:");
                }
        } while (!salir);
    }
}
