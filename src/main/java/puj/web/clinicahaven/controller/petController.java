package puj.web.clinicahaven.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import puj.web.clinicahaven.entity.mascot;
import puj.web.clinicahaven.repositorio.petRepository;
import puj.web.clinicahaven.servicio.petService;



@Controller
@RequestMapping("/mascotas")
public class petController {
    @Autowired
    petService mascotaservice;

    @Autowired
    private final petRepository petRepo;

    public petController(petRepository petRepo) {
        this.petRepo = petRepo;
    }

    @GetMapping("/informacion")
    public String list(Model model) {
        Collection<mascot> pets = petRepo.findAll();
        model.addAttribute("pets", pets);
        return "listPage";
    }

//registrar Mascota
//localhost:8090/mascota/agregarmascota
  @PostMapping("/agregarmascota")
  public String agregarCliente(@ModelAttribute("mascota") mascot mascota) {
    mascotaservice.agregar(mascota);

      return "redirect:/cliente/mis_mascotas";
  }

//Actualizar Mascota
//localhost:8090/mascota/actualizar_mascota/1
  @GetMapping("/actualizar_mascota/{id}")
  public String mostrarFormulario(@PathVariable("id") Long id, Model model) {
    model.addAttribute("mascota", mascotaservice.findById(id));
    //mascotaservice.update(mascota);
    return "modificar_mascota";
  }

  @PostMapping("/actualizar_mascota/{id}")
  public String actualizarMascota(@PathVariable("id") Long id, @ModelAttribute("mascota") mascot mascota) {
    mascotaservice.update(mascota);
    return "redirect:/cliente/mis_mascotas";
  }
  
//Eliminar Mascota
//localhost:8090/mascotas/delete/2
@GetMapping("/delete/{id}")
public String deletePet(@PathVariable("id") Long id) {
    mascotaservice.deleteById(id);
    return "redirect:/cliente/informacion_mascotas";
}

}