package puj.web.clinicahaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import puj.web.clinicahaven.entity.mascot;
import puj.web.clinicahaven.servicio.petService;


@Controller
public class petRegisterController {

    @Autowired

    petService mascotaService;

    //localhost:8090/mascotas/registrar
    @GetMapping("mascotas/registrar")
    public String CrearNuevaMascota(Model model) {

        mascot mascota = new mascot("", 0, "", "", "", "", "");

        model.addAttribute("mascota", mascota);

        return "registroMascota";


    }

    //localhost:8090/mascotas/agregar
    @PostMapping("mascotas/agregar")
    public String agregarCliente(@ModelAttribute("mascota") mascot mascota) {
        mascotaService.agregar(mascota);

        return "redirect:/menu";
    }

}