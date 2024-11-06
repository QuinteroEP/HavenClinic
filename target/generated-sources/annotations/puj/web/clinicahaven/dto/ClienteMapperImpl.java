package puj.web.clinicahaven.dto;

import javax.annotation.processing.Generated;
import puj.web.clinicahaven.entity.Cliente;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-06T14:57:01-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.40.0.z20241023-1306, environment: Java 17.0.13 (Eclipse Adoptium)"
)
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public ClienteDTO convert(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setCedula( cliente.getCedula() );
        clienteDTO.setCelular( cliente.getCelular() );
        clienteDTO.setClienteId( cliente.getClienteId() );
        clienteDTO.setCorreo( cliente.getCorreo() );
        clienteDTO.setNombre( cliente.getNombre() );

        return clienteDTO;
    }
}
