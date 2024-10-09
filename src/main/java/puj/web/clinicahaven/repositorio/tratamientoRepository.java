package puj.web.clinicahaven.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import puj.web.clinicahaven.entity.Tratamiento;;

@Repository
public interface  tratamientoRepository extends JpaRepository<Tratamiento, Long> {
    
}
