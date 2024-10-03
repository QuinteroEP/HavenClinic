package puj.web.clinicahaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import puj.web.clinicahaven.entity.Veterinario;
import puj.web.clinicahaven.servicio.veterinarioService;

import java.util.List;

@RestController
@RequestMapping("/veterinarios")
public class VeterinarioController {

    @Autowired
    private veterinarioService veterinarioService;

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

    @PostMapping("/agregarVeterinario")
    public ResponseEntity<Veterinario> addVeterinario(@RequestBody Veterinario veterinario) {
        veterinarioService.add(veterinario);
        return ResponseEntity.ok(veterinario);
    }

    @PutMapping("/update/{id}")
    public void updateVeterinario(@PathVariable Long id, @RequestBody Veterinario veterinarioDetails) {
        Veterinario veterinario = veterinarioService.findById(id);
        if (veterinario == null) {
            return;
        }
        veterinarioDetails.setVetId(id);  
        veterinarioService.updateVet(veterinarioDetails);
      
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteVeterinario(@PathVariable Long id) {
        Veterinario veterinario = veterinarioService.findById(id);
        if (veterinario == null) {
            return ResponseEntity.notFound().build();
        }
        veterinarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}