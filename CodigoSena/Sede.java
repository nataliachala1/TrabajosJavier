public class Sede {
    private String nombre;
    private Centro centro;

    public Sede(String nombre, Centro centro) {
        this.nombre = nombre;
        this.centro = centro;
    }

    public String getNombre() {
        return nombre;
    }

    public Centro getCentro() {
        return centro;
    }
}