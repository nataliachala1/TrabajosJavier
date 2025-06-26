class Muertos {
    private String name;
    private String phoneNumber;
    private String email;
    private String addres;
    private String age;

    public Muertos(String name, String phoneNumber, String email, String addres, String age) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.addres = addres;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Fallecido [nombre=" + name + ", teléfono=" + phoneNumber + ", correo=" + email +
                ", dirección=" + addres + ", edad=" + age + "]";
    }
}