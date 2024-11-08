package puj.web.clinicahaven.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import puj.web.clinicahaven.entity.Cliente;
import puj.web.clinicahaven.entity.mascota;
import puj.web.clinicahaven.repositorio.petRepository;

@Service
public class petImplementation implements petService{
    @Autowired
    petRepository repo;

    @Override
    public List<mascota> findAll() {
        return repo.findAll(); 
    }

    @Override
    public mascota findById(Long key){
        return repo.findById(key).get();
    }
    
    @Override
    @Transactional
    public void deleteById(Long id){
        repo.deleteById(id);
    }

    @Override
    @Transactional
    public void update(mascota mascota){
        repo.save(mascota);
    }

    @Override
    @Transactional
    public mascota agregar(mascota mascota){
        return repo.save(mascota);
    }
    
    @Override
    public List<mascota> findByDueñoId(Long id){
        return repo.findByDueñoId(id);
    }

    @Override
    public List<mascota> findByDueño(Cliente dueño) {
        return repo.findByDueño(dueño);
    }

    @Override
    public List<mascota> findByNombre(String nombre) {
        return repo.findByNombre(nombre);
    }

    @Override
    public List<mascota> getVetPets(long id){
        return  repo.getVetPets(id);
    }
}