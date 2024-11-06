package puj.web.clinicahaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import puj.web.clinicahaven.entity.Cliente;
import puj.web.clinicahaven.entity.Veterinario;
import puj.web.clinicahaven.security.JWTGenerator;
import puj.web.clinicahaven.servicio.ClienteService;
import puj.web.clinicahaven.servicio.VeterinarioService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class PageController {

    
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private VeterinarioService veterinarioService;

    @Autowired
    AuthenticationManager authenticationManager; 

    @Autowired
    JWTGenerator jwtGenerator;

    @Autowired
    private PasswordEncoder passwordEncoder;

    
    @GetMapping("/menu")
    public String getMenu() {
        return "mainMenu";
    }

    @GetMapping("/")
       public String index(Model model) {
        model.addAttribute("cliente", new Cliente()); // Agrega el objeto cliente al modelo
        return "index";
    }



    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("psw") String password, @RequestParam("userType") String userType, Model model, HttpSession session) {
        if ("veterinarian".equals(userType)) {
            Veterinario veterinario = veterinarioService.findByEmail(email);

            if (veterinario != null && veterinario.getCorreo().equals(email) && veterinario.getContrasena().equals(password)) {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(veterinario.getCorreo(), veterinario.getContrasena())
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtGenerator.generateToken(authentication);
            return "redirect:/vetmain";
            }
            
            /* 
            Veterinario veterinario = veterinarioService.findByEmail(email);
            VeterinarioDTO veterinarioDTO = VeterinarioMapper.INSTANCE.convert(veterinario);

            if (veterinario != null && veterinario.getCorreo().equals(email) && veterinario.getContrasena().equals(password)) {
                SessionUtil.setLoggedInVeterinarian(session, veterinario);
                model.addAttribute("veterinarianName", veterinario.getNombre());

                return "redirect:/vetmain";
            }*/
        } else {
            Cliente cliente = clienteService.findByEmail(email);

            if (cliente != null && passwordEncoder.matches(password, cliente.getContrasena())) {
                Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
                );
            
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtGenerator.generateToken(authentication);  //2:07 como meto el token en la redireccion
            return "redirect:/menu";
            }
            /* 
            Cliente cliente = clienteService.findByEmail(email);
            if (cliente != null && cliente.getCorreo().equals(email) && cliente.getContrasena().equals(password)) {
                SessionUtil.setLoggedInClient(session, cliente);
                return "redirect:/menu";
            }*/
        }

        model.addAttribute("error", "Credenciales invalidas, vuelva a intentar");
        return "loginPage";
    }
    //JWT json web token ->encriptacion de informacion


}