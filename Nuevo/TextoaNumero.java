import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class TextoaNumero {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int [][] matriz = new int[3][3];
        Random random = new Random();

         System.out.println("Ingrese un numero para generar numeros aleatorios");
         String num = sc.nextLine();
         int num1 = Integer.parseInt(num);
         System.out.println(num1);
        if(num1 <= 0 ){
                System.out.println("Error,el número no puede ser negativo");
                return;
        }
        System.out.println("Ingrese un numero");
        String num2 = sc.nextLine();
        int num3 = Integer.parseInt(num2);
        System.out.println(num3);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j]=random.nextInt(num1);
                System.out.println(matriz[i][j]);  
            }  
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}