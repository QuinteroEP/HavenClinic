package puj.web.clinicahaven.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Veterinario {
    @Id
    @GeneratedValue
    private long vetId;

    private int cedula;
    private String nombre;
    private int celular;
    private String especialidad;
    private String contraseña;
    private String foto;
    private int numAtenciones;

    @OneToMany(mappedBy="idVeterinario", cascade = CascadeType.ALL)
    private List<Tratamiento> tratamiento = new ArrayList<>();


    public Veterinario(long vetId, int cedula, String nombre, int celular, String especialidad, String contraseña, String foto, int numAtenciones) {
        this.vetId = vetId;
        this.cedula = cedula;
        this.nombre = nombre;
        this.celular = celular;
        this.especialidad = especialidad;
        this.contraseña = contraseña;
        this.foto = foto;
        this.numAtenciones = numAtenciones;
    }

    public Veterinario(int cedula, String nombre, int celular, String especialidad, String contraseña, String foto, int numAtenciones) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.celular = celular;
        this.especialidad = especialidad;
        this.contraseña = contraseña;
        this.foto = foto;
        this.numAtenciones = numAtenciones;
    }

    public Veterinario() {}


    public long getVetId() {
        return this.vetId;
    }

    public void setVetId(long vetId) {
        this.vetId = vetId;
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

    public String getEspecialidad() {
        return this.especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getContraseña() {
        return this.contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getFoto() {
        return this.foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getNumAtenciones() {
        return this.numAtenciones;
    }

    public void setNumAtenciones(int numAtenciones) {
        this.numAtenciones = numAtenciones;
    }

    public List<Tratamiento> getTratamiento() {
        return this.tratamiento;
    }

    public void setTratamiento( List<Tratamiento> tratamiento) {
        this.tratamiento = tratamiento;
    }


}