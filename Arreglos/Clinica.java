public class Clinica {

    public String name;
    public int distance;
    public Clinica ( String name, int distance){
        this.name = name;
        this.distance = distance;
    }
     @Override
    public String toString() {
        return "Clinica [nombre=" + name +" distancia="+ distance +"]";
    }
}
