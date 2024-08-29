package puj.web.clinicahaven.servicio;

import java.util.Collection;

import jakarta.transaction.Transactional;
import puj.web.clinicahaven.entity.mascot;

public interface petService {

    public Collection<mascot> findAll();
    
    public mascot findById(Long id);
    @Transactional
    public void deleteById(Long id);   
    @Transactional
    public void update(mascot mascota);
    @Transactional
    public void agregar(mascot mascota);
}
