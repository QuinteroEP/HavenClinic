package puj.web.clinicahaven.servicio;

import java.util.List;

import puj.web.clinicahaven.entity.Tratamiento;

public interface tratamientoService {
    public Tratamiento findById(Long id);

    public List<Tratamiento> getHistorial(Long id);

    public Tratamiento findByPetId(Long id);

    public void add(Tratamiento tratamiento);
}
