package puj.web.clinicahaven.servicio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import puj.web.clinicahaven.entity.Cliente;
import puj.web.clinicahaven.repositorio.clienteRepository;

// @Service es un decorador que indica que la clase es un servicio para ser inyectada en otros componentes
@Service
public class ClienteImplementation implements ClienteService{

    @Autowired //en este caso se inyecta el repositorio de cliente en el servicio
    clienteRepository repoCliente;

    @Override
    public Cliente findByCedula(int cedula) {

        return repoCliente.findByCedula(cedula);
    }

    @Override
    public Cliente findByEmail(String correo) {
        return repoCliente.findByCorreo(correo);
    }
    
    @Override
    public Cliente findByContraseña(String pass) {
        return repoCliente.findByContraseña(pass);
    }

    @Override //override es para sobreescribir un metodo
    public Collection<Cliente> findAll() {
        
        return repoCliente.findAll();
    }

    @Override
    @Transactional
    public void deleteByCedula(int cedula) {
       
        repoCliente.deleteByCedula(cedula);
    }

    @Override
    @Transactional
    public void update(Cliente cliente) {

        Cliente existingCliente = repoCliente.findById(cliente.getId()).orElse(null);
        if (existingCliente != null) {
            existingCliente.setNombre(cliente.getNombre());
            existingCliente.setCelular(cliente.getCelular());
            existingCliente.setCorreo(cliente.getCorreo());

            repoCliente.save(existingCliente);
        } else {
            repoCliente.save(cliente);
        }
    }

    @Override
    @Transactional
    public void add(Cliente cliente) {
     
        repoCliente.save(cliente);
    }
}
