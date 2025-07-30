import java.util.ArrayList;
import java.util.List;

public class Aprendiz {
    private String nombre;
    private ProgramaFormacion programa;
    private List<String> jornadas = new ArrayList<>();

    public Aprendiz(String nombre, ProgramaFormacion programa) {
        this.nombre = nombre;
        this.programa = programa;
    }

    public boolean asignarJornada(String jornada) {
        if (jornadas.contains(jornada)) return true;
        if (jornadas.size() >= 2) return false;
        jornadas.add(jornada);
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public ProgramaFormacion getPrograma() {
        return programa;
    }

    public List<String> getJornadas() {
        return jornadas;
    }
}