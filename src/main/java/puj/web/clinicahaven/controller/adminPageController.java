package puj.web.clinicahaven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class adminPageController {


    @GetMapping("/veterinaria/administrador")
    public String getMenu() {
        return "adminPage";
    }
}