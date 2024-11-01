package puj.web.clinicahaven.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import puj.web.clinicahaven.entity.Droga;

@Repository
public interface drogaRepository extends JpaRepository<Droga, Long>{

    @Query("SELECT d.nombre, d.unidadesVendidas FROM Tratamiento t JOIN t.droga d GROUP BY d.nombre ORDER BY d.unidadesVendidas DESC")
    List<Object[]> findTop3ByOrderByUnidadesVendidasDesc();

    @Query("select d.unidadesDisponibles FROM Tratamiento t JOIN t.droga d")
    Number getQuantity(Long id);

    //@Query("select d FROM Tratamiento t JOIN t.droga d where d.nombre = ?1")
    Droga findByNombre(String nombre);

    @Query("select d FROM Tratamiento t JOIN t.droga d WHERE t.id = ?1")
    Droga findByTratamientoId(Long id);
}