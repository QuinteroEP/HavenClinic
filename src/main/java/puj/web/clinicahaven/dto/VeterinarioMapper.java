package puj.web.clinicahaven.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import puj.web.clinicahaven.entity.Veterinario;

@Mapper
public interface VeterinarioMapper {
    VeterinarioMapper INSTANCE = Mappers.getMapper(VeterinarioMapper.class);
    /* lo importante es */
    VeterinarioDTO convert(Veterinario veterinario);
    
}
