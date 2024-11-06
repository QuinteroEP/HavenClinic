
package puj.web.clinicahaven.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import puj.web.clinicahaven.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
    
}
