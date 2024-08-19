package puj.web.clinicahaven.entity;

public class mascot {
    private String nombre;
    private String edad;
    private String raza;
    private String url;
    private int id;
    
    public mascot(String nombre, String edad, String raza, String url, int id) {
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.url = url;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
