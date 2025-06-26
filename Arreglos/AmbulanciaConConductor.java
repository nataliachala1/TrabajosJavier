public class AmbulanciaConConductor {
    private Ambulance ambulancia;
    private Conductores conductor;

    public AmbulanciaConConductor(Ambulance ambulancia, Conductores conductor) {
        this.ambulancia = ambulancia;
        this.conductor = conductor;
    }

    @Override
    public String toString() {
        return ambulancia + " asignada a " + conductor;
    }
}