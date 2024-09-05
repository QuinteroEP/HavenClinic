package puj.web.clinicahaven.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import puj.web.clinicahaven.entity.Veterinario;
import puj.web.clinicahaven.repositorio.VeterinarioRepository;
import puj.web.clinicahaven.servicio.VeterinarioService;

@Service
public class VeterinarioImplementation implements VeterinarioService {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Override
    public Veterinario findByEmail(String email) {
        return veterinarioRepository.findByCorreo(email);
    }

    @Override
    public Veterinario save(Veterinario veterinario) {
        return veterinarioRepository.save(veterinario);
    }

    @Override
    public void deleteById(Long id) {
        veterinarioRepository.deleteById(id);
    }
}