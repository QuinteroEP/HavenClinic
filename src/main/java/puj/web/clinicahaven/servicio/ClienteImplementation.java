package puj.web.clinicahaven.servicio;

import java.util.List;

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
    public Cliente findByid(Long id) {
        return repoCliente.findById(id).orElse(null);
    }
    @Override
    public Cliente findByCedula(int cedula) {

        return repoCliente.findByCedula(cedula);
    }

    @Override
    public Cliente findByEmail(String correo) {
        return repoCliente.findByCorreo(correo);
    }
    
    @Override
    public Cliente findByContrasena(String pass) {
        return repoCliente.findByContrasena(pass);
    }
    
    @Override
    public Cliente findByclienteId(Long id){
        return repoCliente.findById(id).orElse(null);
    }

    @Override //override es para sobreescribir un metodo
    public List<Cliente> findAll() {
        
        return repoCliente.findAll();
    }

    @Override
    @Transactional
    public void deleteByCedula(int cedula) {
       
        repoCliente.deleteByCedula(cedula);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {

        repoCliente.deleteById(id);
    }

    @Override
    @Transactional
    public void update(Cliente cliente) {

        Cliente existingCliente = repoCliente.findById(cliente.getId()).orElse(null);
        if (existingCliente != null) {
            existingCliente.setNombre(cliente.getNombre());
            existingCliente.setCelular(cliente.getCelular());
            existingCliente.setCorreo(cliente.getCorreo());
            existingCliente.setcontrasena(cliente.getcontrasena());

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

    @Override
    public List<Cliente>  findClienteByNombre(String nombre) {
        return repoCliente.findByNombre(nombre);
    }
}
