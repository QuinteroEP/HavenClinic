package puj.web.clinicahaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import puj.web.clinicahaven.servicio.petService;

@RequestMapping("/mascot")
@Controller

public class petController {
    @Autowired
    petService service;

    /*public String mostrarLista(Model model){
        model.addAttribute("Mascotas", petService.findAll());

        return s;
    }*/
} 
