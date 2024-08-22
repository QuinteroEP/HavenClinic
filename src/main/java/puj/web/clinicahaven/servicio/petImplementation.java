package puj.web.clinicahaven.servicio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import puj.web.clinicahaven.entity.mascot;
import puj.web.clinicahaven.repositorio.petRepository;

@Service
public class petImplementation implements petService{
    @Autowired
    petRepository repo;




    @Override
    public Collection<mascot> findAll() {
        return repo.findAll(); 
    }

    @Override
    public mascot findPet(int key){
        return repo.findPet(key);
    }
    
    @Override
    public void deletePet(int key){
        repo.deletePet(key);
    }

    @Override
    public void update(mascot mascota){
        repo.update(mascota);
    }

    @Override
    public void agregar(mascot mascota){
        repo.agregar(mascota);
    }






}
