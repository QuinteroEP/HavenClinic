package puj.web.clinicahaven.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Tratamiento {
    @Id
    @GeneratedValue
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fecha;


    @ManyToOne
    @JsonIgnore
    private mascota mascota;

    @ManyToOne
    @JsonIgnore
    private Veterinario veterinario;

    @ManyToOne
    @JsonIgnore
    private Droga droga;

    public Tratamiento(){

    }

    public Tratamiento(LocalDate fecha){
        this.fecha = fecha;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public mascota getMascota() {
        return this.mascota;
    }

    public void setMascota(mascota mascota) {
        this.mascota = mascota;
    }

    public Veterinario getVeterinario() {
        return this.veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public Droga getDroga() {
        return this.droga;
    }

    public void setDroga(Droga droga) {
        this.droga = droga;
    }
}
