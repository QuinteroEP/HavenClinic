package puj.web.clinicahaven.servicio;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import puj.web.clinicahaven.entity.Cliente;
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
    public mascot findById(Long key){
        return repo.findById(key).get();
    }
    
    @Override
    public void deleteById(Long key){
        repo.deleteById(key);
    }

    @Override
    public void update(mascot mascota){
        repo.save(mascota);
    }

    @Override
    public void agregar(mascot mascota){
        repo.save(mascota);
    }
    
    @Override
    public List<mascot> findByDueñoId(Long id){
        return repo.findByDueñoId(id);
    }

    @Override
    public List<mascot> findByDueño(Cliente dueño) {
        return repo.findByDueño(dueño);
    }
}