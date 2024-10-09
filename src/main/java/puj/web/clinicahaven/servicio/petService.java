package puj.web.clinicahaven.servicio;

import java.util.List;

import jakarta.transaction.Transactional;
import puj.web.clinicahaven.entity.Cliente;
import puj.web.clinicahaven.entity.mascota;

public interface petService {

    public List<mascota> findAll();
    
    public mascota findById(Long id);
    @Transactional
    public void deleteById(Long id);   
    @Transactional
    public void update(mascota mascota);
    @Transactional
    public void agregar(mascota mascota);

    public List<mascota> findByDueño(Cliente dueño);
    
    public List<mascota> findByDueñoId(Long id);
}
