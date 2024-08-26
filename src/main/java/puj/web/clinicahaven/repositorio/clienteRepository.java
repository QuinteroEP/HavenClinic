package puj.web.clinicahaven.repositorio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import puj.web.clinicahaven.entity.Cliente;

@Repository
public interface clienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByCedula(int cedula);
    Cliente findByCorreo(String correo);
    void deleteByCedula(int cedula);
}