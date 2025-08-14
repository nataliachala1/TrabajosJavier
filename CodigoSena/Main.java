import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        int op = 0;
        int flag = 1;

        while (flag == 1) {
            System.out.println("1. Registrar");
            System.err.println("2. Asignar");
            System.out.println("3. Reportes");
            System.out.println("4. Salir");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    sistema.registros();   
                    break;
                case 2:
                    sistema.asignar();
                    break;
                case 3:
                    sistema.reportes();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción invalida");
                    break;
            }
        }
    }
}