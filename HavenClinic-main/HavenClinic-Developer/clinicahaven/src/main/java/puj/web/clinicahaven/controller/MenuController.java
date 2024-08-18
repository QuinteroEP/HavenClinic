package puj.web.clinicahaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import puj.web.clinicahaven.repositorio.petRepository;
import puj.web.clinicahaven.entity.mascot;

@Controller
public class MenuController {

    @Autowired
    private petRepository repo;

    @GetMapping("/menu")
    public String getMenu(Model model) {
        mascot firstPet = repo.findAll().iterator().next();
        model.addAttribute("pet", firstPet);
        return "mainMenu";
    }
}