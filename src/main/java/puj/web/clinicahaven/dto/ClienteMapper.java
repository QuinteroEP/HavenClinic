package puj.web.clinicahaven.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import puj.web.clinicahaven.entity.Cliente;

@Mapper
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);
    /* lo importante es */
    ClienteDTO convert(Cliente cliente);
    
}
