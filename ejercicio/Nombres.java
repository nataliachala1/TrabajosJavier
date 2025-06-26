import java.util.*;

public class Nombres {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
    String[] nombres = new String[5];
              for(int x = 0; x <= 5; x++){
              System.out.println("Ingrese 5 nombres " +(x+1));
              nombres[x] = sc.nextLine();
        }

        Arrays.sort(nombres);
        for (int i = 0; i < 10; i++){
            System.out.println(nombres[1]);
        }
    }

}