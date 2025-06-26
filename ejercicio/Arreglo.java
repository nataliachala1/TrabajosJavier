import java.util.Arrays;
import java.util.Scanner;

public class Arreglo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arreglo = new int[10];

        for(int x = 0; x <= 10; x++){
            System.out.println("Digite el valor " +(x+1));
            arreglo[x] = sc.nextInt();
        }

        Arrays.sort(arreglo);
        for (int i = 0; i < 10; i++) {
            System.out.println(arreglo[i]);
        }

        


    }
}