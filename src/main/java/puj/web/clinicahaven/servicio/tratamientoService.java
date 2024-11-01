package puj.web.clinicahaven.servicio;

import java.util.List;

import jakarta.transaction.Transactional;
import puj.web.clinicahaven.entity.Tratamiento;

public interface tratamientoService {
    public Tratamiento findById(Long id);

    public List<Tratamiento> findAll();

    public List<Tratamiento> getHistorial(Long id);

    public List<Tratamiento> findByPetId(Long id);

    @Transactional
    public Tratamiento add(Tratamiento tratamiento);
}
