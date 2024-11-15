package puj.web.clinicahaven.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import puj.web.clinicahaven.entity.Veterinario;


@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
    Veterinario findByCorreo(String email);

    Veterinario findByCedula(int cedula);

    List<Veterinario> findByNombre(String nombre);
    
    long countByActivo(boolean activo);

    void deleteByCedula(int cedula);
}