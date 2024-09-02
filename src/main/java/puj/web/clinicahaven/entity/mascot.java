package puj.web.clinicahaven.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class mascot {
<<<<<<< Updated upstream
    private String nombre;
    private int edad;
    private String raza;
    private String url;
    private String genero;

=======
>>>>>>> Stashed changes
    @Id
    @GeneratedValue
    private Long id;

<<<<<<< Updated upstream
=======
    private String nombre;
    private int edad;
    private String raza;
    private String url;
    private String genero;
>>>>>>> Stashed changes
    private String condicion;
    private String descripcion;

    @ManyToOne
    private Cliente dueño;
    
    public mascot(String nombre, int edad, String raza, String url, String genero, Long id, String condicion, String descripcion) {
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.url = url;
        this.genero = genero;
        this.id = id;
        this.condicion = condicion;
        this.descripcion = descripcion;
    }

    public mascot() {
    }

    public mascot(String nombre, int edad, String raza, String url, String genero, String condicion, String descripcion) {
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.url = url;
        this.genero = genero;
        this.condicion = condicion;
        this.descripcion = descripcion;
    }

    public Cliente getDueño() {
        return dueño;
    }

    public void setDueño(Cliente dueño) {
        this.dueño = dueño;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
