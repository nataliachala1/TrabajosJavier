public class Centro {
    private String nombre;
    private Regional regional;

    public Centro(String nombre, Regional regional) {
        this.nombre = nombre;
        this.regional = regional;
    }

    public String getNombre() {
        return nombre;
    }

    public Regional getRegional() {
        return regional;
    }
}