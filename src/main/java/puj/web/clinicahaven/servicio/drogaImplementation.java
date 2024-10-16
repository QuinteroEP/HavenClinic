package puj.web.clinicahaven.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import puj.web.clinicahaven.entity.Droga;
import puj.web.clinicahaven.repositorio.drogaRepository;

@Service
public class drogaImplementation implements drogaService{
    @Autowired
    drogaRepository repo;

    public List<Droga> findAll(){
        return repo.findAll();
    }
    
    public Droga findById(Long id){
        return repo.findById(id).get();
    }
}
