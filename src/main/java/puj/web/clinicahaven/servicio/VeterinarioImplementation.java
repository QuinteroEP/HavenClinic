package puj.web.clinicahaven.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import puj.web.clinicahaven.entity.Role;
import puj.web.clinicahaven.entity.UserEntity;
import puj.web.clinicahaven.entity.Veterinario;
import puj.web.clinicahaven.repositorio.RoleRepository;
import puj.web.clinicahaven.repositorio.UserRepository;
import puj.web.clinicahaven.repositorio.VeterinarioRepository;


@Service
public class VeterinarioImplementation implements VeterinarioService {

    @Autowired
    VeterinarioRepository repoVeterinario;

      @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;


    @Override
    public Veterinario findById(Long id) {
        return repoVeterinario.findById(id).orElse(null);
    }

    @Override
    public Veterinario findVetByCedula(int cedula) {
        return repoVeterinario.findByCedula(cedula);
    }

    @Override
    public Veterinario findByEmail(String correo) {
        return repoVeterinario.findByCorreo(correo);
    }
    @Override
public List<Veterinario> findByNombre(String nombre) {
    return repoVeterinario.findByNombre(nombre);
}

    @Override
    public List<Veterinario> findAll() {
        return repoVeterinario.findAll();
    }

    //no elimina realmente al vet sino que cambia el campo activo
    @Override
    @Transactional
    public void deleteVetByCedula(int cedula) {
     repoVeterinario.deleteByCedula(cedula);

        
    }

  
    //no se usa, pero es para eliminar al veterinario por id
    @Override
    @Transactional
    public void deleteById(Long id) {
        repoVeterinario.deleteById(id);
    }

    

    @Override
    @Transactional
    public Veterinario add(Veterinario veterinario) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(veterinario.getCorreo());
        userEntity.setContrasena(passwordEncoder.encode(veterinario.getContrasena()));
        Role roles = roleRepository.findByName("VETERINARIO").get();
        userEntity.setRoles(List.of(roles));
        userRepository.save(userEntity);

        veterinario.setUserEntity(userEntity);
        return repoVeterinario.save(veterinario);
    }

    //almacena la nueva informacion del veterinario
    @Override
    @Transactional
    public void updateVet(Veterinario veterinario) {
        Veterinario existingVeterinario = repoVeterinario.findById(veterinario.getVetId()).orElse(null);
        if (existingVeterinario != null) {
            existingVeterinario.setNombre(veterinario.getNombre());
            existingVeterinario.setCelular(veterinario.getCelular());
            existingVeterinario.setCorreo(veterinario.getCorreo());
            existingVeterinario.setEspecialidad(veterinario.getEspecialidad());
            existingVeterinario.setContrasena(veterinario.getContrasena());


            repoVeterinario.save(existingVeterinario);
        } else {
            repoVeterinario.save(veterinario);
        }
    }
    
    //cambia el estado del veterinario en lugar de eliminarlo
    @Override
    @Transactional
    public Veterinario cambiarEstado(Veterinario veterinario){
        Veterinario existingVeterinario = repoVeterinario.findByCedula(veterinario.getCedula());
    
        existingVeterinario.setActivo(!existingVeterinario.getActivo());
        return repoVeterinario.saveAndFlush(existingVeterinario);
    }
}