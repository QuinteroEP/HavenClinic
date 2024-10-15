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

@Entity
public class Cliente {

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


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getCedula() {
        return cedula;
    }


    public void setCedula(int cedula) {
        this.cedula = cedula;
    }


    public int getCelular() {
        return celular;
    }


    public void setCelular(int celular) {
        this.celular = celular;
    }


    public String getCorreo() {
        return correo;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public String getcontrasena() {
        return contrasena;
    }


    public void setcontrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public long getId() {
        return clienteId;
    }


    public void setId(long clienteId) {
        this.clienteId = clienteId;
    }
    
    }

