public class Aprendiz {
    private String nombre;
    private ProgramaFormacion programa;

    public Aprendiz(String nombre, ProgramaFormacion programa) {
        this.nombre = nombre;
        this.programa = programa;
    }
     public String getNombre() {
        return nombre;
    }

    public ProgramaFormacion getPrograma() {
        return programa;
    }
    public void mostrarDatos() {
        System.out.println("Nomre del aprendiz: " + nombre);
        System.out.println("Programa: " + programa);
    }

}