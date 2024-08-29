package puj.web.clinicahaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import puj.web.clinicahaven.entity.Cliente;
import puj.web.clinicahaven.errorHandling.NotFoundException;
import puj.web.clinicahaven.servicio.ClienteService;




@Controller
@RequestMapping("/cliente")
public class ClienteController {
    
@Autowired
ClienteService clienteService;


//localhost:8090/cliente/all
@GetMapping("/all")
public String getMethodName(Model model) {
    model.addAttribute("clientes", clienteService.findAll());
    return "mostrar_todos_los_clientes";
}


//localhost:8090/cliente/find/10
@GetMapping("/find/{cedula}")
public String MostrarInfoCliente( Model model,@PathVariable("cedula") int cedula) {
    Cliente client = clienteService.findByCedula(cedula);
    if(client!=null) {
        model.addAttribute("cliente", clienteService.findByCedula(cedula));
 
    }else{
     throw new NotFoundException(cedula);
    }
    return "mostrar_cliente";
}


@GetMapping("/findEmail/{correo}")
public String MostrarInfoCliente( Model model,@RequestParam("correo") String correo) {
    model.addAttribute("cliente", clienteService.findByEmail(correo));
    return "mostrar_cliente";
}


//localhost:8080/cliente/find? cedula=10
@GetMapping("/find")
public String getMethodName( Model model,@RequestParam("cedula") int cedula) {
    model.addAttribute("cliente", clienteService.findByCedula(cedula));
    return "mostrar_cliente";
}


//localhost:8090/cliente/registrar
@GetMapping("/registrar") 
public String CrearNuevoCliente(Model model) {
    Cliente cliente = new Cliente ("", 0, 0, "", "");
    model.addAttribute("cliente", cliente);
  
    return "registro_cliente";
}

//localhost:8090/cliente/agregarCliente
@PostMapping("/agregarCliente")
public String agregarCliente(@ModelAttribute("cliente") Cliente cliente) {
   clienteService.add(cliente);
    return "redirect:/menu";
}

//localhost:8080/cliente/eliminarCliente/{cedula}
//path variable para mandar el parametro de la url a la base de datos
@GetMapping("/eliminarCliente/{cedula}")
public String Eliminarcliente(@PathVariable("cedula") int cedula) {
    clienteService.deleteByCedula(cedula);
    return "redirect:/cliente/all";

}

@GetMapping("/update/{cedula}")
public String ActualizarDatos(@PathVariable("cedula") int cedula, Model model) {
    model.addAttribute("cliente", clienteService.findByCedula(cedula));
    return "editar_perfil";
}

@PostMapping("/update/{cedula}")
public String actualizarCliente(@PathVariable("cedula") int cedula, @ModelAttribute("cliente") Cliente cliente) {
   
    clienteService.update(cliente);
    return "redirect:/cliente/all";
    
 
}





}



