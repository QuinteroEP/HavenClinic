package puj.web.clinicahaven.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import puj.web.clinicahaven.entity.Droga;

import java.util.List;

@Repository
public interface drogaRepository extends JpaRepository<Droga, Long>{

    @Query("SELECT d.nombre, d.unidadesVendidas FROM Tratamiento t JOIN t.droga d GROUP BY d.nombre ORDER BY d.unidadesVendidas DESC")
    List<Object[]> findTop3ByOrderByUnidadesVendidasDesc();
}
