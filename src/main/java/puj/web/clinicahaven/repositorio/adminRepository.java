package puj.web.clinicahaven.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import puj.web.clinicahaven.entity.Admin;

@Repository
public interface adminRepository extends JpaRepository<Admin, Long> {

    
    Admin findByCorreo(String correo);

    Admin findByContrasena(String pass);


}
