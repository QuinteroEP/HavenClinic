package puj.web.clinicahaven.servicio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import puj.web.clinicahaven.repositorio.clienteRepository;
import puj.web.clinicahaven.entity.Cliente;

// @Service es un decorador que indica que la clase es un servicio para ser inyectada en otros componentes
@Service
public class ClienteImplementation implements ClienteService{

    @Autowired //en este caso se inyecta el repositorio de cliente en el servicio
    clienteRepository repoCliente;


    @Override
    public Cliente findByCedula(int cedula) {
       
        return repoCliente.findByCedula(cedula);
    }
    @Override //override es para sobreescribir un metodo
    public Collection<Cliente> findAll() {
        
        return repoCliente.findAll();
    }

    @Override
    public void deleteByCedula(int cedula) {
       
        repoCliente.deleteByCedula(cedula);
    }

    @Override
    public void update(Cliente cliente) {
     
        repoCliente.update(cliente);
    }

    @Override
    public void add(Cliente cliente) {
     
        repoCliente.agregar(cliente);
    }


}
