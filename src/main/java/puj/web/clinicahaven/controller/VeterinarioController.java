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

  
    @GetMapping("/vetmain")
    public String getVetMain() {
        return "vetMainMenu";
    }


}