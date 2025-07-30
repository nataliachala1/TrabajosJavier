import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static List<Instructor> instructores = new ArrayList<>();
    static List<Aprendiz> aprendices = new ArrayList<>();
    static List<Ambiente> ambientes = new ArrayList<>();

    public static void main(String[] args) {
        // Datos de ejemplo
        Regional regional = new Regional("Regional Bogotá");
        Centro centro = new Centro("Centro de Tecnología", regional);
        Sede sede = new Sede("Sede Norte", centro);
        LineaFormacion linea1 = new LineaFormacion("Software");
        ProgramaFormacion programa1 = new ProgramaFormacion("ADSO", linea1);
        Horario horario1 = new Horario("Lunes", "Mañana");

        Instructor i1 = new Instructor("Ana Torres", linea1, programa1, sede);
        i1.asignarHorario(horario1);
        instructores.add(i1);

        Aprendiz a1 = new Aprendiz("Carlos López", programa1);
        a1.asignarJornada("Mañana");
        aprendices.add(a1);

        Ambiente amb1 = new Ambiente("Ambiente 101", true, linea1, 30);
        amb1.asignarAprendiz(a1);
        ambientes.add(amb1);

        int opcion;
        do {
            System.out.println("\n===== MENÚ DE REPORTES =====");
            System.out.println("1. Reporte de instructores por sede");
            System.out.println("2. Reporte de aprendices por línea");
            System.out.println("3. Reporte de ambientes por jornada");
            System.out.println("4. Reporte de horarios por jornada");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    reporteInstructoresPorSede();
                    break;
                case 2:
                    reporteAprendicesPorLinea();
                    break;
                case 3:
                    reporteAmbientesPorJornada();
                    break;
                case 4:
                    reporteHorariosPorJornada();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }
d
    public static void reporteInstructoresPorSede() {
        System.out.println("\n--- Instructores por Sede ---");
        for (Instructor i : instructores) {
            System.out.println(i.getNombre() + " - Sede: " + i.sede.getNombre());
        }
    }

    public static void reporteAprendicesPorLinea() {
        System.out.println("\n--- Aprendices por Línea de Formación ---");
        Map<String, Integer> contador = new HashMap<>();
        for (Aprendiz a : aprendices) {
            String linea = a.getPrograma().getLinea().getNombre();
            contador.put(linea, contador.getOrDefault(linea, 0) + 1);
        }
        for (String linea : contador.keySet()) {
            System.out.println(linea + ": " + contador.get(linea) + " aprendices");
        }
    }

    public static void reporteAmbientesPorJornada() {
        System.out.println("\n--- Ambientes por Jornada ---");
        Map<String, Integer> contador = new HashMap<>();
        for (Ambiente amb : ambientes) {
            for (Aprendiz a : amb.getAprendices()) {
                for (String jornada : a.getJornadas()) {
                    contador.put(jornada, contador.getOrDefault(jornada, 0) + 1);
                }
            }
        }
        for (String jornada : contador.keySet()) {
            System.out.println("Jornada " + jornada + ": " + contador.get(jornada) + " aprendices");
        }
    }

    public static void reporteHorariosPorJornada() {
        System.out.println("\n--- Instructores por Jornada ---");
        Map<String, Integer> contador = new HashMap<>();
        for (Instructor i : instructores) {
            for (Horario h : i.horarios) {
                String jornada = h.getJornada();
                contador.put(jornada, contador.getOrDefault(jornada, 0) + 1);
            }
        }
        for (String jornada : contador.keySet()) {
            System.out.println("Jornada " + jornada + ": " + contador.get(jornada) + " instructores");
        }
    }
}