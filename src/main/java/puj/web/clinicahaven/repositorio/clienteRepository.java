package puj.web.clinicahaven.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import puj.web.clinicahaven.entity.Cliente;

@Repository
public interface clienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByCedula(int cedula);
    List<Cliente>  findByNombre(String nombre);
    
    Cliente findByCorreo(String correo);

    Cliente findByContrasena(String pass);

    Cliente findByclienteId(Long id);

    void deleteByCedula(int cedula);
}