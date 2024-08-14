package puj.web.clinicahaven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class pageController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
    
    @GetMapping("/menu")
    public String mainMenu(){
        return "mainMenu";
    }

    @GetMapping("/lista")
    public String list(){
        return "listPage";
    }
}
