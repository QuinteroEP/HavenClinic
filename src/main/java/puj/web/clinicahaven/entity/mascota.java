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
}
