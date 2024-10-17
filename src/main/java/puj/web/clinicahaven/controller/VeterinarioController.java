package puj.web.clinicahaven.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

import puj.web.clinicahaven.entity.Veterinario;
import puj.web.clinicahaven.servicio.VeterinarioService;

@RestController
@RequestMapping("/veterinarios")
@CrossOrigin(origins = "http://localhost:4200")
public class VeterinarioController {

    @Autowired
    private VeterinarioService veterinarioService;

    @GetMapping("/all")
    public List<Veterinario> getAllVeterinarios() {
        return veterinarioService.findAll();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Veterinario> getVeterinarioById(@PathVariable Long id) {
        Veterinario veterinario = veterinarioService.findById(id);
        if (veterinario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(veterinario);
    }

      @GetMapping("/findByCedula/{cedula}")
    @Operation(summary = "find veterinario by cedula")
    public Veterinario getVeterinarioByCed(@PathVariable("cedula") int cedula) {
        Veterinario veterinario = veterinarioService.findVetByCedula(cedula);
        return veterinario; 
    }

    @PostMapping("/agregarVeterinario")
    public  void addVeterinario(@RequestBody Veterinario veterinario) {
        veterinarioService.add(veterinario);
       
    }

    //localhost:8090/veterinario/update/1
    //se encarga de actualizar la info del vet
    @PutMapping("/update/{cedula}")
    public void updateVeterinario(@PathVariable("cedula") int cedula, @RequestBody Veterinario veterinarioDetails) {
        Veterinario veterinario = veterinarioService.findVetByCedula(cedula);
        if (veterinario == null) {
            return;
        }

        veterinarioService.updateVet(veterinarioDetails);

    }

    @PutMapping("/cambiarestado/{cedula}")
    public void cambiarEstadoVeterinario(@PathVariable("cedula") int cedula, @RequestBody Veterinario veterinarioDetails) {
        Veterinario veterinario = veterinarioService.findVetByCedula(cedula);
        if (veterinario == null) {
            return;
        }

        veterinarioService.cambiarEstado(veterinario);

    }


   //no se usa
    //localhost:8090/veterinario/delete/1
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteVeterinario(@PathVariable Long id) {
        Veterinario veterinario = veterinarioService.findById(id);
        if (veterinario == null) {
            return ResponseEntity.notFound().build();
        }
        veterinarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //eliminar por cedula//en este caso no eliminar al vet sino que cambia su estado de activo a desactivado
    //localhost:8090/veterinario/eliminarVeterinario/1
    @DeleteMapping("/eliminarVeterinario/{cedula}")
public void EliminarVeterinario(@PathVariable("cedula") int cedula) {
    veterinarioService.deleteVetByCedula(cedula);

}


    //localhost:8090/veterinario/findEmail/pq@c.m
    @GetMapping("/findEmail/{correo}")
    public Veterinario MostrarInfoVet(@PathVariable("correo") String correo) {
        Veterinario veterinario = veterinarioService.findByEmail(correo);
        return veterinario;
    }

    @GetMapping("/findByNombre/{nombre}")
@Operation(summary = "Buscar veterinario por nombre")
public List<Veterinario> findByNombre(@PathVariable("nombre") String nombre) {
    return veterinarioService.findByNombre(nombre);
}
}