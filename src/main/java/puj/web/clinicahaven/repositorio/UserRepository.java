package puj.web.clinicahaven.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import puj.web.clinicahaven.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    
    Optional <UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username);      

}
