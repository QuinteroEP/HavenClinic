package puj.web.clinicahaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import puj.web.clinicahaven.entity.mascot;
import puj.web.clinicahaven.servicio.petService;


@Controller
public class infoPageController {

    @Autowired
    petService servicio;

    @GetMapping("mascotas/informacion/{id}")
    public String petInfo(Model model, @PathVariable("id") Long id) {


        mascot mascota = servicio.findPet(id);
        if(mascota!=null){
            model.addAttribute("pet", servicio.findPet(id));
        }
        else{
            throw new petNotFoundException(id);
        }
        return "petInfo";
    }
    
}
