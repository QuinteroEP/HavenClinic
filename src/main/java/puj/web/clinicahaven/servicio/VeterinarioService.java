package puj.web.clinicahaven.servicio;

import java.util.List;
import puj.web.clinicahaven.entity.Veterinario;

public interface veterinarioService {
    List<Veterinario> findAll();
    Veterinario findById(Long id);
    Veterinario findByEmail(String email);
    Veterinario findByCedula(int cedula);
    void add(Veterinario veterinario); // Declarar el método add
    void updateVet(Veterinario veterinario); // Declarar el método update
    void deleteById(Long id);
}