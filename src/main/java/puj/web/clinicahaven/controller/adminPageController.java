package puj.web.clinicahaven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class adminPageController {


    @GetMapping("/veterinaria/administrador")
    public String getMenu() {
        return "adminPage";
    }




}