package puj.web.clinicahaven.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import puj.web.clinicahaven.entity.Cliente;
import puj.web.clinicahaven.entity.Veterinario;
import puj.web.clinicahaven.servicio.VeterinarioService;

@RestController
@RequestMapping("/veterinarios")
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

    //localhost:8090/veterinario/findEmail/pq@c.m
    @GetMapping("/findEmail/{correo}")
    public Veterinario MostrarInfoVet(@PathVariable("correo") String correo) {
        Veterinario veterinario = veterinarioService.findByEmail(correo);
        return veterinario;
    }
}