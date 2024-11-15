package puj.web.clinicahaven.dto;

import lombok.Data;

@Data
public class ClienteDTO {

    private long clienteId;
    private int cedula;
    private String nombre;
    private int celular;
    private String correo;

    //cliente -> clienteDTO
    
}
