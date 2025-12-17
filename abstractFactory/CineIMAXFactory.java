public class CineIMAXFactory implements CineFactory {
    
    public Ticket crearTicket() {
        return new TicketIMAX();
    }

    public Combo crearCombo() {
        return new ComboIMAX();
    }

    public Articulo crearArticulo() {
        return new ArticuloIMAX();
    }

    public Regalo crearRegalo() {
        return new RegaloIMAX();
    }
}