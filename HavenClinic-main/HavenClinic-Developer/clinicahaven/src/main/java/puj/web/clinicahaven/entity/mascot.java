package puj.web.clinicahaven.entity;



public class mascot {
    private String nombre;
    private int edad;
    private String raza;
    private String url;
    
    public mascot(String nombre, int edad, String raza, String url) {
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
