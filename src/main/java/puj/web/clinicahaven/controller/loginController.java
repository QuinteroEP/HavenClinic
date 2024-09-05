package puj.web.clinicahaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import puj.web.clinicahaven.entity.Cliente;
import puj.web.clinicahaven.entity.SessionUtil;
import puj.web.clinicahaven.entity.Veterinario;
import puj.web.clinicahaven.servicio.ClienteService;
import puj.web.clinicahaven.servicio.VeterinarioService;

@Controller
public class loginController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private VeterinarioService veterinarioService;

    /*@GetMapping("/login")
    public String getMenu() {
        return "loginPage";
    }*/

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("psw") String password, @RequestParam("userType") String userType, Model model, HttpSession session) {
        if ("veterinarian".equals(userType)) {
            Veterinario veterinario = veterinarioService.findByEmail(email);
            if (veterinario != null && veterinario.getCorreo().equals(email) && veterinario.getContraseña().equals(password)) {
                SessionUtil.setLoggedInVeterinarian(session, veterinario);
                model.addAttribute("veterinarianName", veterinario.getNombre());

                return "redirect:/vetmain";
            }
        } else {
            Cliente cliente = clienteService.findByEmail(email);
            if (cliente != null && cliente.getCorreo().equals(email) && cliente.getcontraseña().equals(password)) {
                SessionUtil.setLoggedInClient(session, cliente);
                return "redirect:/menu";
            }
        }
        model.addAttribute("error", "Credenciales invalidas, vuelva a intentar");
        return "loginPage";
    }
}
