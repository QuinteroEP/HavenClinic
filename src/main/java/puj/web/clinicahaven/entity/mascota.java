package puj.web.clinicahaven.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class mascota {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private int edad;
    private String raza;
    private String url;
    private String genero;
    private String condicion;
    private String descripcion;
    private boolean enTratamiento;

    @JsonIgnore
    @ManyToOne
    private Cliente dueño;

    @JsonIgnore
    @OneToMany(mappedBy="mascota", cascade = CascadeType.ALL)
    private List<Tratamiento> tratamiento = new ArrayList<>();
    
    public mascota(String nombre, int edad, String raza, String url, String genero, Long id, String condicion, String descripcion) {
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.url = url;
        this.genero = genero;
        this.id = id;
        this.condicion = condicion;
        this.descripcion = descripcion;
        this.enTratamiento = false;
    }

    public mascota(String nombre, int edad, String raza, String url, String genero, String condicion, String descripcion) {
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.url = url;
        this.genero = genero;
        this.condicion = condicion;
        this.descripcion = descripcion;
        this.enTratamiento = false;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return this.raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCondicion() {
        return this.condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEnTratamiento() {
        return this.enTratamiento;
    }

    public boolean getEnTratamiento() {
        return this.enTratamiento;
    }

    public void setEnTratamiento(boolean enTratamiento) {
        this.enTratamiento = enTratamiento;
    }

    public Cliente getDueño() {
        return this.dueño;
    }

    public void setDueño(Cliente dueño) {
        this.dueño = dueño;
    }

    public List<Tratamiento> getTratamiento() {
        return this.tratamiento;
    }

    public void setTratamiento(List<Tratamiento> tratamiento) {
        this.tratamiento = tratamiento;
    }

}
