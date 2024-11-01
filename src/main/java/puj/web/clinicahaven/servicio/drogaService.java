package puj.web.clinicahaven.servicio;

import java.util.List;

import puj.web.clinicahaven.entity.Droga;

public interface drogaService {
    public List<Droga> findAll();
    
    public Droga findById(Long id);

    public Number getQuantity(Long id);

    public Droga findByName(String nombre);

    public Droga update(Droga droga);

    public Droga findByTratamientoId(Long id);
}
