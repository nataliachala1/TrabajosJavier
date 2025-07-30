public class ProgramaFormacion {
    private String nombre;
    private LineaFormacion linea;

    public ProgramaFormacion(String nombre, LineaFormacion linea) {
        this.nombre = nombre;
        this.linea = linea;
    }

    public String getNombre() {
        return nombre;
    }

    public LineaFormacion getLinea() {
        return linea;
    }
}