public class SolicitarAmbulance {
    private Ambulance ambulancia;
    private Clinica clinica;

    public SolicitarAmbulance(Ambulance ambulancia, Clinica clinica) {
        this.ambulancia = ambulancia;
        this.clinica = clinica;
    }

    @Override
    public String toString() {
        return ambulancia + " Solicitada en la  " + clinica;
    }
}
