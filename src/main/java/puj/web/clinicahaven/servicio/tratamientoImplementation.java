package puj.web.clinicahaven.servicio;

import org.springframework.beans.factory.annotation.Autowired;

import puj.web.clinicahaven.entity.Tratamiento;
import puj.web.clinicahaven.repositorio.tratamientoRepository;

public class tratamientoImplementation implements tratamientoService{
    @Autowired
    tratamientoRepository repo;

    @Override
    public Tratamiento findById(Long key){
        return repo.findById(key).get();
    }
    
}
