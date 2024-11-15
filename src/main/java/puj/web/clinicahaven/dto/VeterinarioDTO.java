package puj.web.clinicahaven.dto;

import lombok.Data;

@Data
public class VeterinarioDTO {

    private Long id;
    private String correo;
    private int cedula;
    private String nombre;
    private int celular;
    private String especialidad;
    private String foto;
    //private int numAtenciones;
    private boolean activo;

    //veterinario ->veterinarioDTO
}
