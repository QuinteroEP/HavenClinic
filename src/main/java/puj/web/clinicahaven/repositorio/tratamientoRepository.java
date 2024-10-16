package puj.web.clinicahaven.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import puj.web.clinicahaven.entity.Tratamiento;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
public interface tratamientoRepository extends JpaRepository<Tratamiento, Long> {

    long countByFechaBetween(LocalDate startDate, LocalDate endDate);

    @Query("SELECT t.droga.nombre, COUNT(t) FROM Tratamiento t WHERE t.fecha BETWEEN :startDate AND :endDate GROUP BY t.droga.nombre")
    Map<String, Long> countTratamientosPorMedicamento(LocalDate startDate, LocalDate endDate);

    @Query("SELECT SUM(t.droga.precioVenta) FROM Tratamiento t")
    double sumVentasTotales();

    @Query("SELECT SUM(t.droga.precioVenta - t.droga.precioCompra) FROM Tratamiento t")
    double sumGananciasTotales();

}