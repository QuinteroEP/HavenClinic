package puj.web.clinicahaven.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Veterinario {

    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity userEntity;

    @Id
    @GeneratedValue
    private long vetId;

    private String correo;
    private int cedula;
    private String nombre;
    private int celular;
    private String especialidad;
    @Transient ///no se muestra la contraseña en la tabla 
    private String contrasena;
    private String foto;
    private int numAtenciones;
    private boolean activo;

    @JsonIgnore
    @OneToMany(mappedBy="veterinario", cascade = CascadeType.ALL)
    private List<Tratamiento> tratamiento = new ArrayList<>();


    public Veterinario(long vetId, int cedula, String nombre, int celular, String especialidad, String contrasena, String foto, int numAtenciones, String correo) {
        this.vetId = vetId;
        this.cedula = cedula;
        this.nombre = nombre;
        this.celular = celular;
        this.especialidad = especialidad;
        this.contrasena = contrasena;
        this.foto = foto;
        this.numAtenciones = numAtenciones;
        this.correo = correo;
        this.activo = true;
    }

    public Veterinario(int cedula, String nombre, int celular, String especialidad, String contrasena, String foto, int numAtenciones, String correo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.celular = celular;
        this.especialidad = especialidad;
        this.contrasena = contrasena;
        this.foto = foto;
        this.numAtenciones = numAtenciones;
        this.correo = correo;
        this.activo = true;
    }



    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

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

    public String getContrasena() {
        return this.contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public UserEntity getUserEntity() {
        return this.userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
