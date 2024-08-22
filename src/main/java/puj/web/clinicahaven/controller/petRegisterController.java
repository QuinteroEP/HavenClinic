package puj.web.clinicahaven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class petRegisterController {
    @GetMapping("/register")
    public String getMenu() {
        return "registroMascota";
    }
}
