package puj.web.clinicahaven.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import puj.web.clinicahaven.entity.Cliente;
import puj.web.clinicahaven.entity.Role;
import puj.web.clinicahaven.entity.UserEntity;
import puj.web.clinicahaven.repositorio.RoleRepository;
import puj.web.clinicahaven.repositorio.UserRepository;
import puj.web.clinicahaven.repositorio.clienteRepository;

// @Service es un decorador que indica que la clase es un servicio para ser inyectada en otros componentes
@Service
public class ClienteImplementation implements ClienteService{

    @Autowired //en este caso se inyecta el repositorio de cliente en el servicio
    clienteRepository repoCliente;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;

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

        Cliente existingCliente = repoCliente.findById(cliente.getClienteId()).orElse(null);
        if (existingCliente != null) {
            existingCliente.setNombre(cliente.getNombre());
            existingCliente.setCelular(cliente.getCelular());
            existingCliente.setCorreo(cliente.getCorreo());
            existingCliente.setContrasena(cliente.getContrasena());

            repoCliente.save(existingCliente);
        } else {
            repoCliente.save(cliente);
        }
    }

@Override
@Transactional
public void add(Cliente cliente) {
    UserEntity userEntity = new UserEntity();
    userEntity.setUsername(cliente.getCorreo());
    userEntity.setContrasena(passwordEncoder.encode(cliente.getContrasena()));
    Role roles = roleRepository.findByName("CLIENTE").get();
    userEntity.setRoles(List.of(roles));
    userRepository.save(userEntity);

    cliente.setUserEntity(userEntity);
    repoCliente.save(cliente);
}

    @Override
    public List<Cliente>  findClienteByNombre(String nombre) {
        return repoCliente.findByNombre(nombre);
    }

    //que paso con cliente service? .-.
    
    @Override
    @Transactional
    public void delete(Cliente cliente) {
        //System.out.println("Cliente a eliminar: " + cliente);
        if (cliente.getUserEntity() != null) {
            // Eliminar las referencias en la tabla user_roles
            UserEntity userEntity = cliente.getUserEntity();
            System.out.println("UserEntity: " + userEntity);    
            userEntity.getRoles().clear();
            userRepository.save(userEntity);
    
            // Ahora eliminar el UserEntity
            userRepository.delete(userEntity);
        }
        System.out.println("Cliente eliminado con éxito del repo");
        repoCliente.delete(cliente);
    }
}
