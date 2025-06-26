public class CarrozaConConductor {
    private Carroza carroza;
    private Conductores conductor;

    public CarrozaConConductor(Carroza carroza, Conductores conductor) {
        this.carroza = carroza;
        this.conductor = conductor;
    }

    @Override
    public String toString() {
        return carroza + " asignada a " + conductor;
    }
}
