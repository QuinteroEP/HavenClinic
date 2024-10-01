package puj.web.clinicahaven.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import puj.web.clinicahaven.entity.Droga;

@Repository
public interface csvRepository extends JpaRepository<Droga, Long>{
    
}
