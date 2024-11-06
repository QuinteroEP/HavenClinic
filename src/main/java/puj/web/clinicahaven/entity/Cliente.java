package puj.web.clinicahaven.entity;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cliente {

    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity userEntity;

    @Id
    @GeneratedValue
    private long clienteId;


    private int cedula;
    private String nombre;
    private int celular;
    private String correo;
    private String contrasena;

    @JsonIgnore
    @OneToMany(mappedBy = "dueño",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<mascota> mascotas = new ArrayList<>();

    public List<mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<mascota> mascotas) {
        this.mascotas = mascotas;
    }


    public Cliente(String nombre, long clienteId, int cedula, int celular, String correo, String contrasena) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.clienteId = clienteId;
        this.celular = celular;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public Cliente(String nombre, int cedula, int celular, String correo, String contrasena) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.celular = celular;
        this.correo = correo;
        this.contrasena = contrasena;
    }    
}

