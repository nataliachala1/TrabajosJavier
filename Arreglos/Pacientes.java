class Pacientes {
    public String name, phoneNumber, email, addres, age;

    public Pacientes(String name, String phoneNumber, String email, String addres, String age) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.addres = addres;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Paciente [nombre=" + name + ", teléfono=" + phoneNumber + ", correo=" + email +
                ", dirección=" + addres + ", edad=" + age + "]";
    }
}