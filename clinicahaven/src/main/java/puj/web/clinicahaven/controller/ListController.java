package puj.web.clinicahaven.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import puj.web.clinicahaven.entity.mascot;
import puj.web.clinicahaven.repositorio.petRepository;
import puj.web.clinicahaven.servicio.petService;

@Controller
public class ListController {
    @Autowired
    petService servicio;

    private final petRepository petRepo;

    public ListController(petRepository petRepo) {
        this.petRepo = petRepo;
    }

    @GetMapping("/lista")
    public String list(Model model) {
        Collection<mascot> pets = petRepo.findAll();
        model.addAttribute("pets", pets);
        return "listPage";
    }

    @GetMapping("/delete/{id}")
    public String deletePet(@PathVariable("id") int id) {
        servicio.deletePet(id);
        return "redirect:/lista";
    }
}