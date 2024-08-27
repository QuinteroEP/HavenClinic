package puj.web.clinicahaven.controller.errorHandling;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class petErrorController {
    @ExceptionHandler(petNotFoundException.class)

    public String error(Model model, petNotFoundException ex){

        model.addAttribute("id", ex.getPetId());
        return ("errorFindPet");
    }
}
