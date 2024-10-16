package puj.web.clinicahaven.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import puj.web.clinicahaven.entity.Veterinario;
import puj.web.clinicahaven.repositorio.VeterinarioRepository;


@Service
public class VeterinarioImplementation implements VeterinarioService {

    @Autowired
    private VeterinarioRepository repoVeterinario;

    @Override
    public Veterinario findById(Long id) {
        return repoVeterinario.findById(id).orElse(null);
    }

    @Override
    public Veterinario findByCedula(int cedula) {
        return repoVeterinario.findByCedula(cedula);
    }

    @Override
    public Veterinario findByEmail(String correo) {
        return repoVeterinario.findByCorreo(correo);
    }

    @Override
    public List<Veterinario> findAll() {
        return repoVeterinario.findAll();
    }

    //no se usa, se usa el de cedula
    @Override
    @Transactional
    public void deleteById(Long id) {
        repoVeterinario.deleteById(id);
    }

    //elimina al vet por cedula
    @Override
    @Transactional
    public void deleteByCedula(int cedula) {
        repoVeterinario.deleteByCedula(cedula);
    }

    @Override
    @Transactional
    public void add(Veterinario veterinario) {
        repoVeterinario.save(veterinario);
    }

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
}