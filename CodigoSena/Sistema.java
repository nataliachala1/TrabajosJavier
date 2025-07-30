package CodigoSena;

import java.util.ArrayList;
import java.util.Scanner;

public class Registrar {
    static Scanner sc = new Scanner(System.in);

    ArrayList<Regional> regionales;
    ArrayList<Centro> centros;
    ArrayList<Sede> sedes;
    ArrayList<Ambiente> ambientes;

    public Registrar() {
        regionales = new ArrayList<>();
        centros = new ArrayList<>();
        sedes = new ArrayList<>();
        ambientes = new ArrayList<>();
    }

    public void registrarSede() {
        System.out.println("Ingrese el nombre de la regional:");
        String nombreRegional = sc.nextLine();
        Regional regional = new Regional(nombreRegional);
        regionales.add(regional);

        System.out.println("Ingrese el nombre del centro:");
        String nombreCentro = sc.nextLine();
        Centro centro = new Centro(nombreCentro, regional);
        centros.add(centro);

        System.out.println("Ingrese el nombre de la sede:");
        String nombreSede = sc.nextLine();
        Sede sede = new Sede(nombreSede, centro);
        sedes.add(sede);

        System.out.println("Ingrese la cantidad de ambientes que hay en la sede");
        int cantidadAm = sc.nextInt();

        System.out.println("Datos registrados exitosamente:");
        sede.mostrarDatos();
    }
    public void registrarAmbiente() {
        System.out.println("Ingrese el numero de ambiente");
        int numAmbiente = Integer.parseInt(sc.nextLine());
        System.out.println("Ingrese la capacidad que tiene el ambiente");
        Ambiente ambiente = new Ambiente(numAmbiente);
    }
}
