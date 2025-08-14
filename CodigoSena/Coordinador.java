public class Coordinador {
    private String name;
    private Sede sede;

    public Coordinador (String name, Sede sede){
        this.name = name;
        this.sede = sede;
    }
    public void mostrarDatos() {
        System.out.println("Nombre de la regional: " + name);
        System.out.println("Sede: " + sede.getNombre());
    }
}
