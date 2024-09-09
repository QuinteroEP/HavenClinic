package puj.web.clinicahaven.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import puj.web.clinicahaven.entity.Cliente;
import puj.web.clinicahaven.entity.SessionUtil;
import puj.web.clinicahaven.entity.mascot;
import puj.web.clinicahaven.errorHandling.NotFoundException;
import puj.web.clinicahaven.errorHandling.petNotFoundException;
import puj.web.clinicahaven.repositorio.petRepository;
import puj.web.clinicahaven.servicio.ClienteService;
import puj.web.clinicahaven.servicio.petService;




@Controller
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    ClienteService clienteService;
  
  @Autowired
    petService mascotaservice;
  



//localhost:8090/cliente/all
//usada para ver a todos los clientes
@GetMapping("/all")
public String getMethodName(Model model) {
    model.addAttribute("clientes", clienteService.findAll());
    return "mostrar_todos_los_clientes";
}


//localhost:8090/cliente/find/10
//usada en el cliente/all para ver la info de un cliente por su cedula
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

//localhost:8090/cliente/findEmail? correo=10
//buscar por correo (no se usa)
@GetMapping("/findEmail/{correo}")
public String MostrarInfoCliente( Model model,@RequestParam("correo") String correo) {
    model.addAttribute("cliente", clienteService.findByEmail(correo));
    return "mostrar_cliente";
}


//localhost:8080/cliente/find? cedula=10
//(no se usa)
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
    //model.addAttribute("mascotas", mascotas);
    return "registro_cliente";
}

//menu principal del cliente
//localhost:8090/cliente/menu
@GetMapping("/menu")
public String getMenu(Model model, @ModelAttribute("cliente") Cliente cliente) {
  // Agregar las mascotas del cliente al modelo
  model.addAttribute("mascotas", cliente.getMascotas());
  return "mainMenu";
}

//localhost:8090/cliente/agregarCliente
@PostMapping("/agregarCliente")
@Transactional
public String agregarCliente(@ModelAttribute("cliente") Cliente cliente, HttpSession session) {
   clienteService.add(cliente);
    SessionUtil.setLoggedInClient(session, cliente);
    return "redirect:/cliente/all";
}

//localhost:8080/cliente/eliminarCliente/{cedula}
//path variable para mandar el parametro de la url a la base de datos
@GetMapping("/eliminarCliente/{cedula}")
public String Eliminarcliente(@PathVariable("cedula") int cedula) {
    clienteService.deleteByCedula(cedula);
    return "redirect:/cliente/all";

}

    @GetMapping("/update/{id}")
    public String mostrarFormularioActualizar(@PathVariable("id") long id, Model model) {
        model.addAttribute("cliente", clienteService.findByclienteId(id));
        return "editar_cliente";
    }

    @PostMapping("/update/{id}")
    public String actualizarCliente(@PathVariable("id") long id, @ModelAttribute("cliente") Cliente cliente) {
        clienteService.update(cliente);
        return "redirect:/cliente/all";
    }

    @GetMapping("/update")
public String mostrarFormularioActualizar(HttpSession session, Model model) {
    Cliente loggedInClient = SessionUtil.getLoggedInClient(session);
    if (loggedInClient == null) {
        return "redirect:/"; // Redirect to home if not logged in
    }
    model.addAttribute("cliente", loggedInClient); // Preload form with logged-in client data
    return "editar_cliente"; // Render the update form
}

@PostMapping("/update")
public String actualizarCliente(HttpSession session, @ModelAttribute("cliente") Cliente cliente) {
    Cliente loggedInClient = SessionUtil.getLoggedInClient(session);
    
    if (loggedInClient == null) {
        return "redirect:/"; // Redirect if not logged in
    }

    // Ensure the logged-in client is updating their own data
    //if (loggedInClient.getId() == cliente.getId()) {
        clienteService.update(cliente); // Proceed with the update
        return "redirect:/cliente/menu"; // Redirect to profile or any other page
   // } else {
    //    return "redirect:/"; // If ID mismatch, redirect to prevent unauthorized updates
    //}
}


}