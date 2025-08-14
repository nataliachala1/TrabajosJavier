public class Horario {
    private String dia;
    private String jornada;

    public Horario(String dia, String jornada) {
        this.dia = dia;
        this.jornada = jornada;
    }

    public String getDia() {
        return dia;
    }

    public String getJornada() {
        return jornada;
    }

    public String toString() {
        return dia + " - " + jornada;
    }
}