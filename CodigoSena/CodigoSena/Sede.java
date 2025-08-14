public class Sede {
    private String name;
    private Centro centro;
    private Regional regional;

    public Sede(String name, Centro centro, Regional regional) {
        this.name = name;
        this.centro = centro;
    }

    public String getNombre() {
        return name;
    }
    public Centro getCentro() {
        return centro;
    }

    public Regional getRegional() {
        return regional;
    }

    public void mostrarDatos() {
        System.out.println("Nombre de la sede: " + name);
        centro.mostrarDatos();
        
    }
}
