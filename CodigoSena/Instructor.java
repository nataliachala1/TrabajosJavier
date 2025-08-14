import java.util.*;

public class Instructor {
    private String nombre;
    private LineaFormacion linea;
    private ProgramaFormacion programa;
    private Sede sede;
    public List<Horario> horarios = new ArrayList<>();

    public Instructor(String nombre, LineaFormacion linea, ProgramaFormacion programa, Sede sede) {
        this.nombre = nombre;
        this.linea = linea;
        this.programa = programa;
        this.sede = sede;
    }

    public boolean asignarHorario(Horario horario) {
        if (horarios.size() >= 1) return false;
        horarios.add(horario);
        return true;
    }

    public String getNombre() {
        return nombre;
    }
    public LineaFormacion getLinea() {
        return linea;
    }

    public ProgramaFormacion getPrograma() {
        return programa;
    }

    public Sede getSede() {
        return sede;
    }

    public String getInfo() {
        return nombre + " - Línea: " + linea.getNombre() + ", Programa: " + programa.getNombre();
    }
}