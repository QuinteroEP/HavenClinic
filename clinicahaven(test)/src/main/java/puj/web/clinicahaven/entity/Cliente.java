package puj.web.clinicahaven.entity;

public class Cliente {
    private String nombre;
    private int cedula;
    private int celular;
    private String correo;
    
    
    private String contraseña;


    public Cliente(String nombre, int cedula, int celular, String correo, String contraseña) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.celular = celular;
        this.correo = correo;
        this.contraseña = contraseña;
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

