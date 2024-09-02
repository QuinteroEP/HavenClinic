package puj.web.clinicahaven.entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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
    private String contraseña;

    @OneToMany(mappedBy = "dueño", cascade = CascadeType.ALL)
    private List<mascot> mascotas = new ArrayList<>();

    public List<mascot> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<mascot> mascotas) {
        this.mascotas = mascotas;
    }


    public Cliente(String nombre, long clienteId, int cedula, int celular, String correo, String contraseña) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.clienteId = clienteId;
        this.celular = celular;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public Cliente(String nombre, int cedula, int celular, String correo, String contraseña) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.celular = celular;
        this.correo = correo;
        this.contraseña = contraseña;
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


    public String getcontraseña() {
        return contraseña;
    }


    public void setcontraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public long getId() {
        return clienteId;
    }


    public void setId(long clienteId) {
        this.clienteId = clienteId;
    }
    
    }

