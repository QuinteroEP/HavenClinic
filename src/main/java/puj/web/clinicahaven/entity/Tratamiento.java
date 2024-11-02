package puj.web.clinicahaven.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
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

    public Tratamiento(LocalDate fecha){
        this.fecha = fecha;
    }
}
