package puj.web.clinicahaven.dto;

import javax.annotation.processing.Generated;
import puj.web.clinicahaven.entity.Veterinario;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-11T17:21:43-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.40.0.z20241023-1306, environment: Java 17.0.13 (Eclipse Adoptium)"
)
public class VeterinarioMapperImpl implements VeterinarioMapper {

    @Override
    public VeterinarioDTO convert(Veterinario veterinario) {
        if ( veterinario == null ) {
            return null;
        }

        VeterinarioDTO veterinarioDTO = new VeterinarioDTO();

        veterinarioDTO.setActivo( veterinario.getActivo() );
        veterinarioDTO.setCedula( veterinario.getCedula() );
        veterinarioDTO.setCelular( veterinario.getCelular() );
        veterinarioDTO.setCorreo( veterinario.getCorreo() );
        veterinarioDTO.setEspecialidad( veterinario.getEspecialidad() );
        veterinarioDTO.setFoto( veterinario.getFoto() );
        veterinarioDTO.setNombre( veterinario.getNombre() );

        return veterinarioDTO;
    }
}
