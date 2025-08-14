public class LineaFormacion {
    private String nombre;

    public LineaFormacion(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public void mostrarDatos() {
        System.out.println("Linea de formación: " + nombre);
    }
     @Override
    public String toString() {
        return nombre;
    }
}