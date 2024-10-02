package puj.web.clinicahaven.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import puj.web.clinicahaven.entity.Cliente;
import puj.web.clinicahaven.entity.SessionUtil;
import puj.web.clinicahaven.entity.mascot;
import puj.web.clinicahaven.errorHandling.petNotFoundException;
import puj.web.clinicahaven.repositorio.petRepository;
import puj.web.clinicahaven.servicio.ClienteService;
import puj.web.clinicahaven.servicio.petService;



@RestController
@RequestMapping("/mascotas")
@CrossOrigin(origins = "http://localhost:4200")
public class petController {
    @Autowired
    petService mascotaService;

    @Autowired
    ClienteService clienteService;


    //Mostrar todas las mascotas para el veterinario
      //localhost:8090/mascotas/vetmascota
      @GetMapping("/vetmascota")
      public List<mascot> listPage() {
         return mascotaService  .findAll();
         
      }


      //mascotas de cada cliente por id //no se usa por ahora
      //localhost:8090/mascotas/mascotascliente/1
      @GetMapping("/mascotascliente/{id}")
      public List<mascot> Mascotacliente(@PathVariable("id") Long id) {
          return mascotaService.findByDueñoId(id);
      }
      
//mascotas del cliente loggeado
//localhost:8090/mascotas/mis_mascotas
@GetMapping("/mis_mascotas")
public List<mascot> showClientPets( HttpSession session) {
    Cliente loggedInClient = SessionUtil.getLoggedInClient(session);
    System.out.println("Cliente loggeado: " + loggedInClient.getNombre() + "id: " + loggedInClient.getId());
    List<mascot> mascotas = mascotaService.findByDueñoId(loggedInClient.getId());

    return mascotas;
}

//registrar mascota nueva

//localhost:8090/mascota/vetAddPet
    @GetMapping("/vetAddPet")
    public String vetAddPet() {
        return "vetAddPet";
    }

    @PostMapping("/addPet")
    public void addPet(@PathVariable("ownerCedula") int ownerCedula,@RequestBody mascot mascota){
        Cliente cliente = clienteService.findByCedula(ownerCedula);
        mascota.setDueño(cliente);
        mascotaService.agregar(mascota);
    
    }

//Actualizar Mascota
//localhost:8090/mascota/actualizar_mascota/1
  @GetMapping("/actualizar_mascota/{id}")
  public String mostrarFormulario(@PathVariable("id") Long id, Model model) {
    model.addAttribute("pet", mascotaService.findById(id));
    return "modificar_mascota";
  }

  @PostMapping("/actualizar_mascota/{id}")
  public void actualizarMascota(@RequestBody mascot mascota, @PathVariable("id") Long id) {
      mascot existingMascota = mascotaService.findById(id);
      mascota.setDueño(existingMascota.getDueño());
      mascotaService.update(mascota);

  }

  
//Eliminar Mascota (No se usa, era en caso de que el cliente pudiera eliminar su mascota)
//localhost:8090/mascotas/delete/2
//NO SE USA
@GetMapping("/delete/{id}")
@Transactional
public String deletePet(@PathVariable("id") Long id, HttpSession session) {
    Cliente loggedInClient = SessionUtil.getLoggedInClient(session);
    if (loggedInClient == null) {
        return "redirect:/";
    }
    Cliente clienteWithMascotas = clienteService.findByCedula(loggedInClient.getCedula());
    mascot mascotaToDelete = clienteWithMascotas.getMascotas().stream()
            .filter(m -> m.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Mascota no encontrada"));
    clienteWithMascotas.getMascotas().remove(mascotaToDelete);
    clienteService.update(clienteWithMascotas);
    mascotaService.deleteById(mascotaToDelete.getId());
    return "redirect:/cliente/mis_mascotas";
}

//Eliminar mascota veterinario
//localhost:8090/mascotas/deletePet/2
@DeleteMapping("/deletePet/{id}")

public void deletePetVet(@PathVariable("id") Long id) {
    mascotaService.deleteById(id);
  
}

//localhost:8090/mascotas/petInfo/2
//ver la mascotas desde el veterinario
    @GetMapping("/petInfo/{id}")
    @Operation(summary = "ver la Mascota seleccionada")
    public mascot petInfo(Model model, @PathVariable("id") Long id) {
        mascot mascota = mascotaService.findById(id);
        return  mascota;
    }



   
}