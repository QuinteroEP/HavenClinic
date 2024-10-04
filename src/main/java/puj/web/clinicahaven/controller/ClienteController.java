package puj.web.clinicahaven.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;
import puj.web.clinicahaven.entity.Cliente;
import puj.web.clinicahaven.entity.SessionUtil;
import puj.web.clinicahaven.servicio.ClienteService;





@RestController   //pasa de controller a restcontroller
@RequestMapping("/cliente")
@CrossOrigin (origins = "http://localhost:4200") //especifica al backend que paginas le pueden hacer peticiones//conecta con angular
public class ClienteController {
    
    @Autowired
    ClienteService clienteService;


//menu principal del cliente
//localhost:8090/cliente/menu
@GetMapping("/menu")
public String getMenu(Model model, @ModelAttribute("cliente") Cliente cliente) {
  // Agregar las mascotas del cliente al modelo
  model.addAttribute("mascotas", cliente.getMascotas());
  return "mainMenu";
}

//localhost:8090/cliente/all
//usada para ver a todos los clientes
@GetMapping("/all")
public List<Cliente> MostrarEstudiantes(Model model) {
    //model.addAttribute("clientes", clienteService.findAll());
   // return "mostrar_todos_los_clientes";
   return clienteService.findAll();
}


//localhost:8090/cliente/find/10
//usada en el cliente/all para ver la info de un cliente por su cedula
@GetMapping("/find/{cedula}")
@Operation(summary = "find student by id ")
public Cliente MostrarInfoCliente(@PathVariable("cedula") int cedula) {
    Cliente client = clienteService.findByCedula(cedula);

    return client;  
}

//localhost:8090/cliente/findEmail/pq@c.m
@GetMapping("/findEmail/{correo}")
public Cliente MostrarInfoCliente(@PathVariable("correo") String correo) {
    Cliente cliente = clienteService.findByEmail(correo);
    return cliente;
}


//localhost:8080/cliente/find? cedula=10
//(no se usa)
@GetMapping("/find")
public String getMethodName( Model model,@RequestParam("cedula") int cedula) {
    model.addAttribute("cliente", clienteService.findByCedula(cedula));
    return "mostrar_cliente";
}


//registra al cliente (no se uso, se dejo como pop up de index)
//localhost:8090/cliente/registrar

@GetMapping("/registrar") 
public String CrearNuevoCliente(Model model) {
    Cliente cliente = new Cliente ("", 0, 0, "", "");
    model.addAttribute("cliente", cliente);
    //model.addAttribute("mascotas", mascotas);
    return "registro_cliente";
}
//agrega el cliente despues de registrarse
//localhost:8090/cliente/agregarCliente

@PostMapping("/agregarCliente")

public void agregarCliente(@RequestBody Cliente cliente, HttpSession session) {
   clienteService.add(cliente);
    SessionUtil.setLoggedInClient(session, cliente);

}

//localhost:8080/cliente/eliminarCliente/{cedula}
//path variable para mandar el parametro de la url a la base de datos
@DeleteMapping("/eliminarCliente/{cedula}")
public void Eliminarcliente(@PathVariable("cedula") int cedula) {
    clienteService.deleteByCedula(cedula);
    

}
//localhost:8080/cliente/update
//redirecciona a la pagina para actualizar el cliente
    @GetMapping("/update/{id}")
    public String mostrarFormularioActualizar(@PathVariable("id") long id, Model model) {
        model.addAttribute("cliente", clienteService.findByclienteId(id));
        return "editar_cliente";
    }

//guarda los cambios del cliente
@PutMapping("/update")
public void actualizarCliente(HttpSession session, @RequestBody Cliente cliente) {
    Cliente loggedInClient = SessionUtil.getLoggedInClient(session);
    
    if (loggedInClient != null) {
        clienteService.update(cliente); // Proceed with the update
    }

}


}