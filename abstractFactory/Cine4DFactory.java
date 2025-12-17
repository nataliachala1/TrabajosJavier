public class Cine4DFactory implements CineFactory{

    public Ticket crearTicket() {
        return new Ticket4D();
    }

    public Combo crearCombo() {
        return new Combo4D();
    }

    public Articulo crearArticulo() {
        return new Articulo4D();
    }

    public Regalo crearRegalo() {
        return new Regalo4D();
    }

}