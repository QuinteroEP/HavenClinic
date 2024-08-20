package puj.web.clinicahaven.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorControler {
    @ExceptionHandler (NotFoundException.class)
    public String error(Model model, NotFoundException e) {
        model.addAttribute("error", e.getId());

        return ("pagina_error_cliente");
    }
}
