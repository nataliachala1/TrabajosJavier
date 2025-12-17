public class Main {
    public static void main(String[] args) {
        Taquilla taquilla2D = new Taquilla(new Cine2DFactory()); {
        taquilla2D.VenderPaquete();
        }

        System.out.println("--------");

        Taquilla taquillaIMAX = new Taquilla(new CineIMAXFactory());
        taquillaIMAX.VenderPaquete();

        System.out.println("----------");

        Taquilla taquilla4D = new Taquilla(new Cine4DFactory());
        taquilla4D.VenderPaquete();

        System.out.println("-----------");

    }
}
