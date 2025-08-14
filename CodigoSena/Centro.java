public class Centro {
    private String name;
    private Regional regional;

    public Centro(String name, Regional regional) {
        this.name = name;
        this.regional = regional;
    }
    public String getNombre() {
    return name;
    }

    public Regional getRegional() {
    return regional;
    }

    public void mostrarDatos() {
        System.out.println("Nombre del centro: " + name);
        System.out.println("Regional: " + regional.getNombre());
    }
}
