package puj.web.clinicahaven.servicio;

import puj.web.clinicahaven.entity.Veterinario;

public interface VeterinarioService {
    Veterinario findByEmail(String email);
    Veterinario save(Veterinario veterinario);
    void deleteById(Long id);
}