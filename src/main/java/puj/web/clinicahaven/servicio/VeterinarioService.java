package puj.web.clinicahaven.servicio;

import java.util.List;

import puj.web.clinicahaven.entity.Veterinario;

public interface VeterinarioService {
    List<Veterinario> findAll();
    Veterinario findById(Long id);
    Veterinario findByEmail(String email);
    Veterinario findVetByCedula(int cedula);
    void add(Veterinario veterinario); // Declarar el método add
    void updateVet(Veterinario veterinario); // Declarar el método update
    void deleteById(Long id);//este no se usa
     void deleteVetByCedula(int cedula); 
}