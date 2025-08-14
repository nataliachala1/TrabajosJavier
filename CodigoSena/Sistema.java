import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    static Scanner sc = new Scanner(System.in);

    ArrayList<Regional> regionales;
    ArrayList<Centro> centros;
    ArrayList<Sede> sedes;
    ArrayList<Ambiente> ambientes;
    ArrayList<LineaFormacion> lineas;
    ArrayList<ProgramaFormacion> programas;
    ArrayList<Coordinador> coordinadores;
    ArrayList<Instructor> instructores;
    ArrayList<Aprendiz> aprendices;


    public Sistema() {
        regionales = new ArrayList<>();
        centros = new ArrayList<>();
        sedes = new ArrayList<>();
        ambientes = new ArrayList<>();
        lineas = new ArrayList<>();
        programas = new ArrayList<>();
        coordinadores = new ArrayList<>();
        instructores = new ArrayList<>();
        aprendices = new ArrayList<>();
    }

    public void registros() {
        int op = 0;
        System.out.println("¿Que desea registrar?");
        System.out.println("1. Registrar sede");
        System.out.println("2. Registrar linea de formación");
        System.out.println("3. Registrar programa de formación");
        System.out.println("4. Registrar ambiente");
        System.out.println("5. Registrar coordinador");
        System.out.println("6. Registrar instructor");
        System.out.println("7. Registrar aprendiz");
        op = sc.nextInt();
        sc.nextLine();

        switch (op) {
            case 1:
                System.out.println("Ingrese el nombre de la regional:");
                String nombre = sc.nextLine();
                Regional regional = new Regional(nombre);
                regionales.add(regional);

                System.out.println("Ingrese el nombre del centro:");
                String nombreCentro = sc.nextLine();
                Centro centro = new Centro(nombreCentro, regional);
                centros.add(centro);

                System.out.println("Ingrese el nombre de la sede:");
                String nombreSede = sc.nextLine();
                Sede sede = new Sede(nombreSede, centro, regional);
                sedes.add(sede);

                System.out.println("Ingrese la cantidad de ambientes que hay en la sede");
                int cantidadAm = sc.nextInt();

                System.out.println("Datos registrados exitosamente:");
                sede.mostrarDatos();
                break;
            case 2:
                System.out.println("Ingrese la linea que desea registrar");
                String lineaF = sc.nextLine();
                LineaFormacion linea = new LineaFormacion(lineaF);
                lineas.add(linea);
                break;
            case 3:
                if (lineas.isEmpty()) {
                    System.out.println("No hay líneas de formación registradas. Registre una primero.");
                    return;
                }

                System.out.println("Seleccione la línea de formación para el programa:");
                for (int i = 0; i < lineas.size(); i++) {
                    System.out.println((i + 1) + ". " + lineas.get(i).getNombre());
                }

                int opcionLinea = Integer.parseInt(sc.nextLine());
                if (opcionLinea < 1 || opcionLinea > lineas.size()) {
                    System.out.println("Opción inválida.");
                    return;
                }

                LineaFormacion lineaSeleccionada = lineas.get(opcionLinea - 1);

                System.out.println("Ingrese el nombre del programa de formación:");
                String nombrePrograma = sc.nextLine();

                ProgramaFormacion nuevoPrograma = new ProgramaFormacion(nombrePrograma, lineaSeleccionada);
                programas.add(nuevoPrograma);

                System.out.println("Programa registrado exitosamente:");
                nuevoPrograma.mostrarDatos();
                break;
            case 4:
                System.out.println("Ingrese el número del ambiente:");
                String numAmbiente = sc.nextLine();

                System.out.println("Ingrese la capacidad que tiene el ambiente:");
                String capacidad = sc.nextLine();

                System.out.println("¿Es un ambiente especializado? (Sí/No):");
                String especializado = sc.nextLine();

                Ambiente ambiente = new Ambiente(numAmbiente, capacidad, especializado);
                ambientes.add(ambiente);

                System.out.println("Ambiente registrado exitosamente:");
                ambiente.mostrarDatos();
                break;
            case 5:
                System.out.println("Ingrese el nombre");
                String name = sc.nextLine();

                System.out.println("Ingrese la sede a la que pertenece:");
                String nombreSedeCoordinador = sc.nextLine();
                Sede sedeEncontrada = null;

                for (Sede s : sedes) {
                     if (s.getNombre().equalsIgnoreCase(nombreSedeCoordinador)) {
                    sedeEncontrada = s;
                break;
                }
                }
                    if (sedeEncontrada == null) {
                    System.out.println("Sede no encontrada. Registre la sede primero.");
                    return;
                    }

                Coordinador coordinador = new Coordinador(name, sedeEncontrada);
                coordinadores.add(coordinador);
                System.out.println("Coordinador registrado exitosamente.");
                break;
            case 6:
                if (lineas.isEmpty() || programas.isEmpty() || sedes.isEmpty()) {
                System.out.println("Debe tener líneas, programas y sedes registradas primero.");
                return;
                }
                System.out.println("Ingrese el nombre del instructor:");
                String nombreInstructor = sc.nextLine();

                System.out.println("Seleccione la línea de formación:");
                for (int i = 0; i < lineas.size(); i++) {
                System.out.println((i + 1) + ". " + lineas.get(i).getNombre());
                }
                int opLinea = sc.nextInt();
                sc.nextLine();
                LineaFormacion lineaInst = lineas.get(opLinea - 1);

                System.out.println("Seleccione el programa de formación:");
                for (int i = 0; i < programas.size(); i++) {
                System.out.println((i + 1) + ". " + programas.get(i).getNombre());
                }
                int opProg = sc.nextInt();
                sc.nextLine();
                ProgramaFormacion progInst = programas.get(opProg - 1);

                System.out.println("Seleccione la sede:");
                for (int i = 0; i < sedes.size(); i++) {
                System.out.println((i + 1) + ". " + sedes.get(i).getNombre());
                }
                int opSede = sc.nextInt();
                sc.nextLine();
                Sede sedeInst = sedes.get(opSede - 1);

                Instructor instructor = new Instructor(nombreInstructor, lineaInst, progInst, sedeInst);
                instructores.add(instructor);
                System.out.println("Instructor registrado exitosamente.");
                break;
            case 7:
                 if (programas.isEmpty()) {
                System.out.println("Debe tener programas registrados primero.");
                return;
                }
                System.out.println("Ingrese el nombre del aprendiz:");
                String nombreAprendiz = sc.nextLine();

                System.out.println("Seleccione el programa de formación:");
                for (int i = 0; i < programas.size(); i++) {
                System.out.println((i + 1) + ". " + programas.get(i).getNombre());
                }
                int opProgramaAprendiz = sc.nextInt();
                sc.nextLine();
                ProgramaFormacion progAprendiz = programas.get(opProgramaAprendiz - 1);

                Aprendiz aprendiz = new Aprendiz(nombreAprendiz, progAprendiz);
                aprendices.add(aprendiz);
                System.out.println("Aprendiz registrado exitosamente.");
                break;
            default:
            System.out.println("Opción incorrecta");
                break;
        }
    }
    public void asignar() {
        int op = 0;
        System.out.println("¿Que desea asignar?");
        System.out.println("1. Asignar ambiente a la linea");
        System.out.println("2. Asignar instructor a la linea");
        System.out.println("3. Asignar instructor al coordinador");
        System.out.println("4. Asignar instructor al ambiente");
        System.out.println("5. Asignar horario al instructor");
        System.out.println("6. Asignar horario al aprendiz");
        op = sc.nextInt();
        sc.nextLine();

        switch (op) {
        case 1: // Asignar ambiente a la línea
            if (ambientes.isEmpty() || lineas.isEmpty()) {
                System.out.println("Debe registrar ambientes y líneas primero.");
                return;
            }
            System.out.println("Seleccione el ambiente:");
            for (int i = 0; i < ambientes.size(); i++) {
                System.out.println((i + 1) + ". Ambiente " + ambientes.get(i).numAmbiente);
            }
            int opAmb = sc.nextInt();
            sc.nextLine();

            System.out.println("Seleccione la línea:");
            for (int i = 0; i < lineas.size(); i++) {
                System.out.println((i + 1) + ". " + lineas.get(i).getNombre());
            }
            int opLin = sc.nextInt();
            sc.nextLine();

            System.out.println("Ambiente asignado a la línea exitosamente.");
            break;

        case 2: // Asignar instructor a la línea
            if (instructores.isEmpty() || lineas.isEmpty()) {
                System.out.println("Debe registrar instructores y líneas primero.");
                return;
            }
            System.out.println("Seleccione el instructor:");
            for (int i = 0; i < instructores.size(); i++) {
                System.out.println((i + 1) + ". " + instructores.get(i).getNombre());
            }
            int opInst = sc.nextInt();
            sc.nextLine();

            System.out.println("Seleccione la línea:");
            for (int i = 0; i < lineas.size(); i++) {
                System.out.println((i + 1) + ". " + lineas.get(i).getNombre());
            }
            int opLin2 = sc.nextInt();
            sc.nextLine();

            System.out.println("Instructor asignado a la línea exitosamente.");
            break;

        case 3: // Asignar instructor al coordinador
            if (instructores.isEmpty() || coordinadores.isEmpty()) {
                System.out.println("Debe registrar instructores y coordinadores primero.");
                return;
            }
            System.out.println("Seleccione el instructor:");
            for (int i = 0; i < instructores.size(); i++) {
                System.out.println((i + 1) + ". " + instructores.get(i).getNombre());
            }
            int opInstC = sc.nextInt();
            sc.nextLine();

            System.out.println("Seleccione el coordinador:");
            for (int i = 0; i < coordinadores.size(); i++) {
                System.out.println((i + 1) + ". " + coordinadores.get(i).toString());
            }
            int opCoord = sc.nextInt();
            sc.nextLine();

            System.out.println("Instructor asignado al coordinador exitosamente.");
            break;

        case 4: // Asignar instructor al ambiente
            if (instructores.isEmpty() || ambientes.isEmpty()) {
                System.out.println("Debe registrar instructores y ambientes primero.");
                return;
            }
            System.out.println("Seleccione el instructor:");
            for (int i = 0; i < instructores.size(); i++) {
                System.out.println((i + 1) + ". " + instructores.get(i).getNombre());
            }
            int opInstA = sc.nextInt();
            sc.nextLine();

            System.out.println("Seleccione el ambiente:");
            for (int i = 0; i < ambientes.size(); i++) {
                System.out.println((i + 1) + ". Ambiente " + ambientes.get(i).numAmbiente);
            }
            int opAmbA = sc.nextInt();
            sc.nextLine();

            System.out.println("Instructor asignado al ambiente exitosamente.");
            break;

        case 5: // Asignar horario al instructor
            if (instructores.isEmpty()) {
                System.out.println("Debe registrar instructores primero.");
                return;
            }
            System.out.println("Seleccione el instructor:");
            for (int i = 0; i < instructores.size(); i++) {
                System.out.println((i + 1) + ". " + instructores.get(i).getNombre());
            }
            int opInstH = sc.nextInt();
            sc.nextLine();

            System.out.println("Ingrese el día:");
            String dia = sc.nextLine();
            System.out.println("Ingrese la jornada:");
            String jornada = sc.nextLine();
            Horario horario = new Horario(dia, jornada);

            if (instructores.get(opInstH - 1).asignarHorario(horario)) {
                System.out.println("Horario asignado exitosamente.");
            } else {
                System.out.println("El instructor ya tiene un horario asignado.");
            }
            break;

        case 6: // Asignar horario al aprendiz
            if (aprendices.isEmpty()) {
                System.out.println("Debe registrar aprendices primero.");
                return;
            }
            System.out.println("Seleccione el aprendiz:");
            for (int i = 0; i < aprendices.size(); i++) {
                System.out.println((i + 1) + ". " + aprendices.get(i).toString());
            }
            int opAprH = sc.nextInt();
            sc.nextLine();

            System.out.println("Ingrese el día:");
            String diaA = sc.nextLine();
            System.out.println("Ingrese la jornada:");
            String jornadaA = sc.nextLine();

            System.out.println("Horario asignado al aprendiz exitosamente.");
            break;

        default:
            System.out.println("Opción incorrecta.");
            break;
    }
    }
    public void reportes() { 
        int op = 0;
        System.out.println("Eliga el reporte que desea ver");
        System.out.println("1. Reporte de los instructores");
        System.out.println("2. Reporte de los aprendices");
        System.out.println("3. Reporte de los ambientes");
        System.out.println("4. Reporte de horario");
        op = sc.nextInt();
        sc.nextLine();

        switch(op) {
        case 1:
            System.out.println("----- Reporte de Instructores -----");
            if (instructores.isEmpty()) {
                System.out.println("No hay instructores registrados.");
            } else {
                for (Instructor inst : instructores) {
                    System.out.println("Nombre: " + inst.getNombre());
                    System.out.println("Programa: " + inst.getPrograma().getNombre());
                    System.out.println("Línea: " + inst.getLinea().getNombre());
                    System.out.println("Sede: " + inst.getSede().getNombre());
                    System.out.println("---------------------------");
                }
            }
            break;

        case 2:
            System.out.println("----- Reporte de Aprendices -----");
            if (aprendices.isEmpty()) {
                System.out.println("No hay aprendices registrados.");
            } else {
                for (Aprendiz ap : aprendices) {
                    System.out.println("Nombre: " + ap.getNombre());
                    System.out.println("Programa: " + ap.getPrograma().getNombre());
                    System.out.println("---------------------------");
                }
            }
            break;

        case 3:
            System.out.println("----- Reporte de Ambientes -----");
            if (ambientes.isEmpty()) {
                System.out.println("No hay ambientes registrados.");
            } else {
                for (Ambiente am : ambientes) {
                    System.out.println("Número de ambiente: " + am.getNumAmbiente());
                    System.out.println("Capacidad: " + am.getCapacidad());
                    System.out.println("Especializado: " + am.getEspecializado());
                    System.out.println("---------------------------");
                }
            }
            break;

        case 4:
            System.out.println("----- Reporte de Programas de Formación -----");
            if (programas.isEmpty()) {
                System.out.println("No hay programas registrados.");
            } else {
                for (ProgramaFormacion prog : programas) {
                    System.out.println("Programa: " + prog.getNombre());
                    System.out.println("Línea: " + prog.getLinea().getNombre());
                    System.out.println("---------------------------");
                }
            }
            break;

        case 5:
            System.out.println("----- Reporte de Sedes y Regionales -----");
            if (sedes.isEmpty()) {
                System.out.println("No hay sedes registradas.");
            } else {
                for (Sede s : sedes) {
                    System.out.println("Sede: " + s.getNombre());
                    System.out.println("Centro: " + s.getCentro().getNombre());
                    System.out.println("Regional: " + s.getRegional().getNombre());
                    System.out.println("---------------------------");
                }
            }
            break;

        default:
            System.out.println("Opción incorrecta.");
            break;
        }

    }
}
