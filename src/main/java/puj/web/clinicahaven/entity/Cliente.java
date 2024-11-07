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
//@NoArgsConstructor
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


public Cliente() {
    
}
    public UserEntity getUserEntity() {
        return this.userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public long getClienteId() {
        return this.clienteId;
    }

    public void setClienteId(long clienteId) {
        this.clienteId = clienteId;
    }

    public int getCedula() {
        return this.cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCelular() {
        return this.celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return this.contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
 

}

