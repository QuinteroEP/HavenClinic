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
  
    @Autowired
    petRepository petRepo;


//localhost:8090/cliente/all
//usada para ver a todos los clientes
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
    //model.addAttribute("mascotas", mascotas);
    return "registro_cliente";
}

//menu
//localhost:8090/cliente/menu
@GetMapping("/menu")
public String getMenu(Model model, @ModelAttribute("cliente") Cliente cliente) {
  // Agregar las mascotas del cliente al modelo
  model.addAttribute("mascotas", cliente.getMascotas());
  return "mainMenu";
}

//todas las mascotas
//localhost:8090/cliente/mis_mascotasall
@GetMapping("/mis_mascotasall")
public String petList(Model model) {
    Collection<mascot> mascotas = mascotaservice.findAll();
    model.addAttribute("pets", mascotas);

    return "listPage";
}

//mascotas del cliente
//localhost:8090/cliente/mis_mascotas/id
@GetMapping("/mis_mascotas/{id}")
public String clientPetInfo(Model model, @PathVariable("id") Long id) {
    Collection<mascot> mascotas = mascotaservice.findByDueñoId(id);
    model.addAttribute("pets", mascotas);

    return "listPage";
}

//mascotas del cliente loggeado
@GetMapping("/mis_mascotas")
public String showClientPets(Model model, HttpSession session) {
    Cliente loggedInClient = SessionUtil.getLoggedInClient(session);
    if (loggedInClient == null) {
        return "redirect:/";
    }
    System.out.println("Cliente loggeado: " + loggedInClient.getNombre() + "id: " + loggedInClient.getId());
    Collection<mascot> mascotas = mascotaservice.findByDueñoId(loggedInClient.getId());
    model.addAttribute("pets", mascotas);
    return "listPage";
}

/*@GetMapping("/mis_mascotas")
public String list(Model model, @RequestParam("correo") String correo) {
    Cliente cliente = clienteService.findByEmail(correo);
    if (cliente == null) {
        //throw new NotFoundException("Cliente no encontrado");
    }
    model.addAttribute("mascotas", cliente.getMascotas());
    return "informacion_mascotas";
}*/


//informacion mascota
//localhost:8090/cliente/informacionmascota/2
@GetMapping("/informacionmascota/{id}")
public String petInfo(Model model, @PathVariable("id") Long id) {
    mascot mascota = mascotaservice.findById(id);
    if (mascota == null) {
        throw new petNotFoundException(id);
    }

    model.addAttribute("pet", mascota);
    return "petInfo";
}


  //registrar Mascota
  //localhost:8090/cliente/registrarmascota
  @GetMapping("/registrarmascota")
  public String CrearNuevaMascota(Model model, HttpSession session) {

      Cliente loggedInClient = SessionUtil.getLoggedInClient(session);
      if (loggedInClient == null) {
          return "redirect:/";
      }
      model.addAttribute("mascota", new mascot());

      return "registroMascota";
  }
    @PostMapping("/registrarmascota")
    @Transactional
    public String addPet(@RequestParam("nombre") String nombre, @RequestParam("edad") int edad, @RequestParam("raza") String raza, @RequestParam("url") String url, @RequestParam("genero") String genero, @RequestParam("condicion") String condicion, @RequestParam("descripcion") String descripcion, HttpSession session) {
        Cliente loggedInClient = SessionUtil.getLoggedInClient(session);
        if (loggedInClient == null) {
            return "redirect:/";
        }
        mascot nuevaMascota = new mascot(nombre, edad, raza, url, genero, condicion, descripcion);
        nuevaMascota.setDueño(loggedInClient);
        loggedInClient.getMascotas().add(nuevaMascota);
        clienteService.update(loggedInClient);
        return "redirect:/cliente/mis_mascotas";
    }

//ver todas las mascotas
   @GetMapping("/informacion_mascotas")
    public String list(Model model) {
        
        model.addAttribute("pets", petRepo.findAll());
        return "listPage";
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