package puj.web.clinicahaven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import puj.web.clinicahaven.entity.mascot;
import puj.web.clinicahaven.repositorio.petRepository;

import java.util.Collection;

@Controller
public class ListController {

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
}