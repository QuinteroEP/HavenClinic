package puj.web.clinicahaven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import puj.web.clinicahaven.entity.Cliente;

@Controller
public class PageController {
    @GetMapping("/menu")
    public String getMenu() {
        return "mainMenu";
    }

    @GetMapping("/")
       public String index(Model model) {
        model.addAttribute("cliente", new Cliente()); // Agrega el objeto cliente al modelo
        return "index";
    }
}