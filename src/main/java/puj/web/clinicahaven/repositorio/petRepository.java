package puj.web.clinicahaven.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import puj.web.clinicahaven.entity.Cliente;
import puj.web.clinicahaven.entity.mascota;

@Repository
public interface petRepository extends JpaRepository<mascota, Long> {
    mascota findPetById(Long id);
    List<mascota> findByNombre(String nombre);

    void deleteById(Long id);

    List<mascota> findByDueño(Cliente dueño);

    @Query("select m from mascota m where m.dueño.id = ?1")
    List<mascota> findByDueñoId(Long id);

    long countByEnTratamiento(boolean enTratamiento);
}
