package puj.web.clinicahaven.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import puj.web.clinicahaven.entity.Cliente;

@Repository
public interface clienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByCedula(int cedula);
    
    Cliente findByCorreo(String correo);

    Cliente findByContraseña(String pass);
<<<<<<< Updated upstream
    void deleteByCedula(int cedula);   
=======

    void deleteByCedula(int cedula);    
>>>>>>> Stashed changes
}