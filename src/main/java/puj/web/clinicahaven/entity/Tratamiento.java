package puj.web.clinicahaven.entity;

import java.time.LocalDate;

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

    private LocalDate fecha;
    private String Nombredroga;
    
    private Long idVeterinario;
    private Long idMascota;

    @JsonIgnore
    @ManyToOne
    private Droga droga;



    public Tratamiento(Long id, LocalDate fecha, Long idVeterinario, Long idMascota, Droga droga) {
        this.id = id;
        this.fecha = fecha;
        this.idVeterinario = idVeterinario;
        this.idMascota = idMascota;
    }

    public Tratamiento(LocalDate fecha, String Nombredroga) {
        this.fecha = fecha;
        this.Nombredroga = Nombredroga;
    }
    public Tratamiento (LocalDate fecha) {
        this.fecha = fecha;
    }

    public Tratamiento() {}

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

    public Long getIdVeterinario() {
        return this.idVeterinario;
    }

    public void setIdVeterinario(Long idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public Long getIdMascota() {
        return this.idMascota;
    }

    public void setIdMascota(Long idMascota) {
        this.idMascota = idMascota;
    }

    public Droga getDroga() {
        return this.droga;
    }

    public void setDroga(Droga droga) {
        this.droga = droga;
    }

    public String getNombredroga() {
        return Nombredroga;
    }

    public void setNombredroga(String nombredroga) {
        Nombredroga = nombredroga;
    }

}
