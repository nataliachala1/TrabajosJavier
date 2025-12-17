public class Taquilla {
    private final CineFactory factory;

    public Taquilla(CineFactory factory) {
        this.factory = factory;
    }

    public void VenderPaquete() {
        Ticket ticket = factory.crearTicket();
        Combo combo = factory.crearCombo();
        Articulo articulo = factory.crearArticulo();
        Regalo regalo = factory.crearRegalo();
        System.out.println("Vendiendo: " + ticket.imprimir());
        System.out.println("Incluye: " + combo.describir());
        System.out.println("Incluye: " + articulo.mostrar());
        System.out.println("Incluye: " + regalo.dar());
    }
}
