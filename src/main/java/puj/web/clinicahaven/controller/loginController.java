package puj.web.clinicahaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import puj.web.clinicahaven.entity.Cliente;
import puj.web.clinicahaven.servicio.ClienteService;

@Controller
public class loginController {
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/login")
    public String getMenu() {
        return "loginPage";
    }
    
    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("psw") String password, Model model) {
        Cliente cliente = clienteService.findByEmail(email);

        if (cliente.getCorreo().equals(email) && cliente.getcontraseña().equals(password)) {
            return "redirect:/menu";
        } else {
            System.out.println("Login Error");
            
            model.addAttribute("error", "Credenciales invalidas, vuelva a intentar");
            return "loginPage";
        }
    } 
}
