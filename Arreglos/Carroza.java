class Carroza {
    private String identidad;

    public Carroza(String identidad) {
        this.identidad = identidad;
    }

    @Override
    public String toString() {
        return "Carroza [placa=" + identidad + "]";
    }
}