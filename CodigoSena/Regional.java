public class Regional {
    private String nombre;

    public Regional(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public void mostrarDatos() {
        System.out.println("Regional: " + nombre);
    }
    @Override
    public String toString() {
        return nombre;
    }
}