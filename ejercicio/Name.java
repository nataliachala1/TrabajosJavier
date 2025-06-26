import java.util.*;


public class Name {
    public static String buscar;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] usuario = new String [10][6];
        int i = 0;
        int bandera = 1 ;
        int op = 0;

        while(bandera == 1 ){
           System.out.println("Seleccione una opción");
           System.out.println("1. Registrar usuario");
           System.out.println("2. Buscar Usuario");
           System.out.println("3. Salir");
           op = sc.nextInt();
           sc.nextLine();

        switch(op) {
                case 1 ->  {
                    if (i >= 10) {
                    System.out.println("Se alcanzo el limite de usuarios registrados");
                    break;
                    }
                    System.out.println("Usuario numero " + (i + 1)); 
                    System.out.println("Ingrese nombre");
                    usuario[i][0] = sc.nextLine();
                    System.out.println("Ingrese su apellido");
                    usuario[i][1] = sc.nextLine();
                    System.out.println("Ingrese su dirección");
                    usuario[i][2] = sc.nextLine();
                    System.out.println("Ingrese su ocupación");
                    usuario[i][3] = sc.nextLine();
                    System.out.println("Ingrese su correo");
                    usuario[i][4] = sc.nextLine();
                    System.out.println("Ingrese su rh");
                    usuario[i][5] = sc.nextLine();
                    System.out.println("Usuario registrado con exito");
                    i++;
                }
                case 2 ->  {
                    if ( i == 0 ) {
                        System.out.println("No hay usuarios registrados");
                        break;
                    }
                    System.out.println("Ingrese el nombre o el correo del usuario a buscar");
                    buscar = sc.nextLine();
                    boolean encontrado = false;

                    for(i = 0; i < 10; i++){
                    if((usuario[i][0]).toLowerCase().equals(buscar) || (usuario[i][4]).toLowerCase().equals(buscar)){
                        System.out.println(usuario[i][0]);
                        System.out.println(usuario[i][1]);
                        System.out.println(usuario[i][2]);
                        System.out.println(usuario[i][3]);
                        System.out.println(usuario[i][4]);
                        System.out.println(usuario[i][5]);
                        encontrado = true;
                        break;
                       }
                    }

                    if(!encontrado) {
                        System.out.println("Usuario no encontrado");
                        break;
                    }
                }
                case 3 ->  {
                    bandera = 0;
                    System.out.println("Saliendo...");
                }
                default -> System.out.println("Opcion no valida");
            }
        }
            sc.close();
    }
}
