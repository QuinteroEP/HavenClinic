package puj.web.clinicahaven.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Tratamiento {
    @Id
    @GeneratedValue
    private Long id;

    private String fecha;
    private String Nombredroga;
    
    private int idVeterinario;
    private int idMascota;

    @JsonIgnore
    @OneToOne
    private Droga droga;



    public Tratamiento(Long id, String fecha, int idVeterinario, int idMascota, Droga droga) {
        this.id = id;
        this.fecha = fecha;
        this.idVeterinario = idVeterinario;
        this.idMascota = idMascota;
    }

    public Tratamiento(String fecha, String Nombredroga) {
        this.fecha = fecha;
        this.Nombredroga = Nombredroga;
    }
    public Tratamiento (String fecha) {
        this.fecha = fecha;
    }

    public Tratamiento() {}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdVeterinario() {
        return this.idVeterinario;
    }

    public void setIdVeterinario(int idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public int getIdMascota() {
        return this.idMascota;
    }

    public void setIdMascota(int idMascota) {
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
