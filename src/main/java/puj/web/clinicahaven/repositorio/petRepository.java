package puj.web.clinicahaven.repositorio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import puj.web.clinicahaven.entity.Cliente;
import puj.web.clinicahaven.entity.mascot;

@Repository
public interface petRepository extends JpaRepository<mascot, Long> {

}
