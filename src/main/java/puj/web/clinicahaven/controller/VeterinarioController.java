package puj.web.clinicahaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import puj.web.clinicahaven.entity.Cliente;
import puj.web.clinicahaven.entity.mascot;
import puj.web.clinicahaven.errorHandling.petNotFoundException;
import puj.web.clinicahaven.servicio.ClienteImplementation;
import puj.web.clinicahaven.servicio.petImplementation;

@Controller
public class VeterinarioController {

    @Autowired
    private petImplementation mascotaService;
    @Autowired
    private ClienteImplementation clienteService;

    @GetMapping("/vetmascota")
    public String listPage(Model model) {
        model.addAttribute("mascotas", mascotaService.findAll());
        return "vetLisPage";
    }
    @GetMapping("/vetAddPet")
    public String vetAddPet() {
        return "vetAddPet";
    }

    @PostMapping("/addPet")
    public String addPet(@RequestParam String name, @RequestParam Long ownerid, @RequestParam int edad, @RequestParam String raza,  @RequestParam String image, @RequestParam String genero,@RequestParam String condicion, @RequestParam String descripcion) {
        mascot newPet = new mascot(name, edad, raza, image, genero, condicion, descripcion);
       Cliente cliente = clienteService.findByclienteId(ownerid);
        newPet.setDueño(cliente);
        mascotaService.agregar(newPet);
        return "redirect:/vetmascota";
    }
    @GetMapping("/petInfo/{id}")
    public String petInfo(Model model, @PathVariable("id") Long id) {
        mascot mascota = mascotaService.findById(id);
        if (mascota == null) {
            throw new petNotFoundException(id);
        }

        model.addAttribute("pet", mascota);
        return "vetPetInfo";
    }

}