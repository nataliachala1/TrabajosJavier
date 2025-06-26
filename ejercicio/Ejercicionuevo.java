import java.util.Scanner;


public class Ejercicionuevo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[10];

        for(int i = 0; i < 10; i++){
            System.out.println("Ingrese un valor para posición " + (i+1) + ": ");
            numeros[1]=sc.nextInt();
        }
        for(int i = 0; i < 10; i++){
            System.out.println((i));
        }
        sc.close();
    }
    
}
