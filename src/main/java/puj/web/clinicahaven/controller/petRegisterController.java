package puj.web.clinicahaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import puj.web.clinicahaven.entity.Cliente;
import puj.web.clinicahaven.entity.mascot;
import puj.web.clinicahaven.servicio.ClienteService;
import puj.web.clinicahaven.servicio.petService;


@Controller
@RequestMapping("/mascotas/registrar")
public class petRegisterController {

    @Autowired

    petService mascotaService;

    //localhost:8090/mascotaRegister/crear_mascota
    @GetMapping("mascotas/crear")
    public String CrearNuevaMascota(Model model) {

        mascot mascota = new mascot("", "", "", "", 0, "", "");

        model.addAttribute("mascota", mascota);

        return "registroMascota";


    }

    //localhost:8090/cliente/agregarCliente
    @PostMapping("mascotas/agregar")
    public String agregarCliente(@ModelAttribute("mascota") mascot mascota) {
        mascotaService.agregar(mascota);

        return "redirect:/menu";
    }

}