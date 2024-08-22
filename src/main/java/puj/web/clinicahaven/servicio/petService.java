package puj.web.clinicahaven.servicio;

import java.util.Collection;

import puj.web.clinicahaven.entity.mascot;

public interface petService {

    public Collection<mascot> findAll();
    
    public mascot findPet(int id);

    public void deletePet(int id);

    public void update(mascot mascota);

    public void agregar(mascot mascota);
}
