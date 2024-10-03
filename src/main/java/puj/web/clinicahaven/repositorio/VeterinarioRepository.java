package puj.web.clinicahaven.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import puj.web.clinicahaven.entity.Veterinario;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
    Veterinario findByCorreo(String email);

    Veterinario findByCedula(int cedula);

}