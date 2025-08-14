public class Ambiente {
    String numAmbiente;
    String capacidad;
    String especializado;

    public Ambiente(String numAmbiente, String capacidad, String especializado) {
        this.numAmbiente = numAmbiente;
        this.capacidad = capacidad;
        this.especializado = especializado;
    }
    public String getNumAmbiente() {
        return numAmbiente;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public String getEspecializado() {
        return especializado;
    }

    public void mostrarDatos() {
        System.out.println("Número del ambiente: " + numAmbiente);
        System.out.println("Capacidad: " + capacidad);
        System.out.println("Especializado: " + especializado);
    }
}
