package CodigoSena;

public class Coordinador {
    private String name;
    Sede sede;

    public Coordinador (String name, Sede sede){
        this.name = name;
        this.sede = sede;
    }
     public void mostrarDatos() {
        System.out.println("Nombre de la regional: " + name);
        System.out.println("Sede: " + sede);
    }
}
