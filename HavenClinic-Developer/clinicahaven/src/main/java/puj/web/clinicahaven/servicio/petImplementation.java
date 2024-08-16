package puj.web.clinicahaven.servicio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import puj.web.clinicahaven.entity.mascot;
import puj.web.clinicahaven.repositorio.petRepository;

public class petImplementation implements petService{
    @Autowired
    petRepository repo;

    @Override
    public Collection<mascot> findAll() {
        return repo.findAll(); 
    }
    
}
