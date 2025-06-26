class Conductores {
    private String nombre;
    private String telefono;
    private String correo;

    public Conductores(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Conductor [nombre=" + nombre + ", teléfono=" + telefono + ", correo=" + correo + "]";
    }
}
