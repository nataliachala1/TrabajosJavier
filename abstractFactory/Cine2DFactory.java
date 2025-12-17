public class Cine2DFactory implements CineFactory {
    
    public Ticket crearTicket() {
        return new Ticket2D();
    }

    public Combo crearCombo() {
        return new Combo2D();
    }

    public Articulo crearArticulo(){
        return new Articulo2D();
    }

    public Regalo crearRegalo() {
        return new Regalo2D();
    }
}
