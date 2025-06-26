import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static int i = 0;
    public static int j;
    static List<Ambulance> ambulance = new ArrayList<>();
    static List<Carroza> carroza = new ArrayList<>(); 
    static List<Conductores> conductores = new ArrayList<>(); 
    static List<Pacientes> pacientes = new ArrayList<>(); 
    static List<Muertos> fallecidos = new ArrayList<>();
    static List<AmbulanciaConConductor> ambulanciasConConductores = new ArrayList<>();
    static List<CarrozaConConductor> carrozasConConductores = new ArrayList<>();
    static List<Clinica> clinica = new ArrayList<>();
    static List<SolicitarAmbulance> solicitar = new ArrayList<>();


    public static void main(String[] args) {

        int bandera = 1;
        int op = 0;

        while (bandera == 1) {
            System.out.println("Ingrese una opción");
            System.out.println("1. Registrar una ambulancia");
            System.out.println("2. Registrar un carroza");
            System.out.println("3. Registrar un conductor");
            System.out.println("4. Registrar un paciente");
            System.out.println("5. Asignar conductor a ambulancia");
            System.out.println("6. Asignar conductor a carroza");
            System.out.println("7. Mostrar pacientes fallecidos");
            System.out.println("8. Registrar clinica");
            System.out.println("9. Solicitar ambulancia");
            System.out.println("10. Salir");
            op = sc.nextInt();
            sc.nextLine();

        switch (op) {
            case 1:
                registerAmbulance();
                break;
            case 2:
                registerCarroza();
                break;
            case 3:
                registerConductor();
                break;
            case 4:
                registerPaciente();
                break;
            case 5:
                asignarConductorA();
                break;
            case 6:
                asignarConductorC();
                break;
            case 7:
                mostrarFallecidos();
                break;
            case 8:
                registrarClinica();
                break;
            case 9: 
                solicitarAmbulance();
                break;
            case 10:
                bandera = 0;
                    System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no valida");
                break;
        }
        } 

    }
    public static void registerAmbulance(){
        System.out.println("Puedes registrar 10 ambulancias");
        System.out.println("¿cuantas ambulancias desea registrar?");
            j = sc.nextInt();
            sc.nextLine();
            if(j > 10){
                System.out.println("Solo puedes registrar 10 ambulancias");
                return;
            }
        for(i = 0; i < j; i++){
        System.out.println("Ambulancia numero " + (i + 1)); 
        System.out.println("Ingrese la placa de la ambulancia");
        String placa = sc.nextLine();
        ambulance.add(new Ambulance(placa));
        System.out.println("Ambulancia registrada.");
        }
    }
    public static void registerCarroza(){
        for(i = 0; i < 1; i++){
        System.out.print("Ingrese la placa de la carroza: ");
        String identidad = sc.nextLine();
        carroza.add(new Carroza(identidad));
        System.out.println("Carroza registrada.");
        }

    }
    public static void registerConductor(){
        System.out.println("Puedes registrar 10 conductores");
        System.out.println("¿cuantos conductores desea registrar?");
            j = sc.nextInt();
            sc.nextLine();
            if(j > 10){
                System.out.println("Solo puedes registrar 10 conductores");
                return;
            }
        for(i = 0; i < j; i++){
        System.out.println("Conductor numero " + (i + 1)); 
        System.out.print("Nombre del conductor: ");
        String nombre = sc.nextLine();
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();
        System.out.print("Correo: ");
        String correo = sc.nextLine();
        conductores.add(new Conductores(nombre, telefono, correo));
        System.out.println("Conductor registrado.");
        }
        
    }
    public static void registerPaciente(){
        System.out.println("Puedes registrar 100 pacientes");
        System.out.println("¿cuantos pacientes desea registrar?");
            j = sc.nextInt();
            sc.nextLine();
            if(j > 100){
                System.out.println("Solo puedes registrar 100 pacientes");
                return;
            }
        for(i = 0; i < j; i++){
        System.out.println("Paciente numero " + (i + 1)); 
        System.out.print("Nombre del paciente: ");
        String nombre = sc.nextLine();
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();
        System.out.print("Correo: ");
        String correo = sc.nextLine();
        System.out.print("Dirección: ");
        String direccion = sc.nextLine();
        System.out.print("Edad: ");
        String edad = sc.nextLine();
        pacientes.add(new Pacientes(nombre, telefono, correo, direccion, edad));
        System.out.println("Paciente registrado.");
        }
    }
     public static void registrarClinica(){
            System.out.print("Solo puede registrar 3 clinicas");
            System.out.print("¿Cuantas clinicas desea registrar?");
            j = sc.nextInt();
            if( j > 3){
                System.out.println("Solo puede registrar 3 clinicas");
            }
            for( i = 0; i < j; i++){
                System.out.println("Clinica numero " + (i + 1)); 
                System.out.println("Ingrese el nombre de la clínica: ");
                String name = sc.nextLine();
                System.out.println("Ingrese la distancia de la clinica en km");
                int distance = sc.nextInt();
                clinica.add(new Clinica(name, distance));
                System.out.println("Clinica registrada." );
            }
    }
    public static void asignarConductorA() {
        if (ambulance.isEmpty() || conductores.isEmpty()) {
            System.out.println("Debe haber al menos una ambulancia y un conductor.");
            return;
        }

        System.out.println("Seleccione una ambulancia:");
        for ( i = 0; i < ambulance.size(); i++) {
            System.out.println(i + ". " + ambulance.get(i));
        }
        int amb = Integer.parseInt(sc.nextLine()); 

        System.out.println("Seleccione un conductor:");
        for ( i = 0; i < conductores.size(); i++) {
            System.out.println(i + ". " + conductores.get(i));
        }
        int cond = Integer.parseInt(sc.nextLine());

        AmbulanciaConConductor asignacion = new AmbulanciaConConductor(ambulance.get(amb), conductores.get(cond));
        ambulanciasConConductores.add(asignacion);
        System.out.println("Asignación realizada: " + asignacion);
    }

    public static void asignarConductorC() {
        if (carroza.isEmpty() || conductores.isEmpty()) {
            System.out.println("Debe haber al menos una carroza y un conductor.");
            return;
        }

        System.out.println("Seleccione una carroza:");
        for ( i = 0; i < carroza.size(); i++) {
            System.out.println(i + ". " + carroza.get(i));
        }
        int carIndex = Integer.parseInt(sc.nextLine());

        System.out.println("Seleccione un conductor:");
        for ( i = 0; i < conductores.size(); i++) {
            System.out.println(i + ". " + conductores.get(i));
        }
        int condIndex = Integer.parseInt(sc.nextLine());

        CarrozaConConductor asignacion = new CarrozaConConductor(carroza.get(carIndex), conductores.get(condIndex));
        carrozasConConductores.add(asignacion);
        System.out.println("Asignación realizada: " + asignacion);
    }

    public static void mostrarFallecidos(){
         if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }

        System.out.println("Pacientes registrados:");
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println(i + ". " + pacientes.get(i));
        }

        System.out.print("¿Cuántos pacientes fallecieron? ");
        int cantidad = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingrese el número del paciente fallecido: ");
            int index = Integer.parseInt(sc.nextLine());

            Pacientes p = pacientes.get(index);
            fallecidos.add(new Muertos(p.name, p.phoneNumber, p.email, p.addres, p.age));
        }

        System.out.println("Lista de pacientes fallecidos:");
        for (Muertos m : fallecidos) {
            System.out.println(m);
        }
    }
    public static void solicitarAmbulance(){
        if (ambulance.isEmpty() || clinica.isEmpty()) {
            System.out.println("Debe haber al menos una ambulancia y una clinica registrada.");
            return;
        } 
        System.out.println("Solicitar ambulancia");
        System.out.println("Seleccione una ambulancia:");
        for (int i = 0; i < ambulance.size(); i++) {
            System.out.println(i + ". " + ambulance.get(i));
        }
        int amb = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese el nombre de la clinica de la cual solicita la ambulancia:");
        for (int i = 0; i < clinica.size(); i++) {
            System.out.println(i + ". " + clinica.get(i));
        }
        int clin = Integer.parseInt(sc.nextLine());

        solicitar.add(new SolicitarAmbulance(ambulance.get(amb), clinica.get(clin)));
        System.out.println("Solicitud realizada: " + solicitar);
    }
}