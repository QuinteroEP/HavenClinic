package puj.web.clinicahaven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller


public class pageController {

    //localhost:8090/HavenClinic/inicio
    @GetMapping("/inicio")
    public String index(){
        return "index";
    }


}
