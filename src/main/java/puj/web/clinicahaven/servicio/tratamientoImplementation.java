package puj.web.clinicahaven.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import puj.web.clinicahaven.entity.Tratamiento;
import puj.web.clinicahaven.repositorio.tratamientoRepository;

@Service
public class tratamientoImplementation implements tratamientoService{
    @Autowired
    tratamientoRepository repo;

    @Override
    public Tratamiento findById(Long key){
        return repo.findById(key).get();
    }

    @Override
    public List<Tratamiento> getHistorial(Long id) {
        return repo.getHistorial(id);
    }

    @Override
    public Tratamiento findByPetId(Long id) {
        return repo.findByPetId(id);
    }

    @Override
    @Transactional
    public Tratamiento add(Tratamiento tratamiento) {
        return repo.save(tratamiento);
    }
}
