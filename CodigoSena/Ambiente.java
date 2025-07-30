import java.util.ArrayList;
import java.util.List;

public class Ambiente {
    private String nombre;
    private boolean especializado;
    private LineaFormacion linea;
    private int capacidad;
    private List<Aprendiz> aprendicesAsignados = new ArrayList<>();

    public Ambiente(String nombre, boolean especializado, LineaFormacion linea, int capacidad) {
        this.nombre = nombre;
        this.especializado = especializado;
        this.linea = linea;
        this.capacidad = capacidad;
    }

    public boolean asignarAprendiz(Aprendiz a) {
        if (!a.getPrograma().getLinea().getNombre().equals(linea.getNombre())) return false;
        if (aprendicesAsignados.size() >= capacidad) return false;
        aprendicesAsignados.add(a);
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public LineaFormacion getLinea() {
        return linea;
    }

    public int getCantidadAprendices() {
        return aprendicesAsignados.size();
    }

    public List<Aprendiz> getAprendices() {
        return aprendicesAsignados;
    }

    public String getInfo() {
        return nombre + " (Línea: " + linea.getNombre() + ", Capacidad: " + capacidad + ", Especializado: " + (especializado ? "Sí" : "No") + ")";
    }
}