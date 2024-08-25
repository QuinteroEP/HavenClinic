package puj.web.clinicahaven.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @Column(unique = true, nullable = false)
    private int cedula;
    private String nombre;
    private int celular;
    private String correo;
    private String contraseña;

    @OneToMany(mappedBy = "dueño", cascade = CascadeType.ALL)
    private List<mascot> mascotas = new ArrayList<>();


    public Cliente(String nombre, int cedula, int celular, String correo, String contraseña) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.celular = celular;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public Cliente(String nombre, int celular, String correo, String contraseña) {
        this.nombre = nombre;
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


    
    }

