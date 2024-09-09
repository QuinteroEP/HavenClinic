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
import puj.web.clinicahaven.errorHandling.petNotFoundException;
import puj.web.clinicahaven.repositorio.petRepository;
import puj.web.clinicahaven.servicio.ClienteService;
import puj.web.clinicahaven.servicio.petService;



@Controller
@RequestMapping("/mascotas")
public class petController {
    @Autowired
    petService mascotaService;

    @Autowired
    ClienteService clienteService;


    //Mostrar las mascotas para el veterinario
      //localhost:8090/vetmascota
      @GetMapping("/vetmascota")
      public String listPage(Model model) {
          model.addAttribute("mascotas", mascotaService.findAll());
          return "vetLisPage";
      }

//registrar mascota nueva

//localhost:8090/mascota/vetAddPet
    @GetMapping("/vetAddPet")
    public String vetAddPet() {
        return "vetAddPet";
    }

    @PostMapping("/addPet")
    public String addPet(@RequestParam String name, @RequestParam int ownerCedula, @RequestParam int edad, @RequestParam String raza,  @RequestParam String image, @RequestParam String genero,@RequestParam String condicion, @RequestParam String descripcion) {
        mascot newPet = new mascot(name, edad, raza, image, genero, condicion, descripcion);
       Cliente cliente = clienteService.findByCedula(ownerCedula);
        newPet.setDueño(cliente);
        mascotaService.agregar(newPet);
        return "redirect:/mascotas/vetmascota";
    }

//Actualizar Mascota
//localhost:8090/mascota/actualizar_mascota/1
  @GetMapping("/actualizar_mascota/{id}")
  public String mostrarFormulario(@PathVariable("id") Long id, Model model) {
    model.addAttribute("pet", mascotaService.findById(id));
    return "modificar_mascota";
  }

  @PostMapping("/actualizar_mascota/{id}")
  public String actualizarMascota(@PathVariable("id") Long id, @ModelAttribute("pet") mascot mascota) {
      mascot existingMascota = mascotaService.findById(id);
      mascota.setDueño(existingMascota.getDueño());
      mascotaService.update(mascota);
    return "redirect:/cliente/mis_mascotas";
  }

  @GetMapping("/updatePet/{id}")
    public String updatePetForm( @PathVariable("id") Long id, Model model) {
        mascot pet = mascotaService.findById(id);
        model.addAttribute("pet", pet);
        return "vetUpdatePet";
    }
    @PostMapping("/updatePet/{id}")
    public String actualizarMascotavet(@PathVariable("id") Long id, @ModelAttribute("pet") mascot pet) {
        mascot existingMascota = mascotaService.findById(id);
        pet.setDueño(existingMascota.getDueño());
        mascotaService.update(pet);
        return "redirect:/vetmascota";
    }
  
//Eliminar Mascota
//localhost:8090/mascotas/delete/2
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
@GetMapping("/deletePet/{id}")
@Transactional
public String deletePetVet(@PathVariable("id") Long id) {
    mascotaService.deleteById(id);
    return "redirect:/vetmascota";
}

//localhost:8090/mascotas/petInfo/2
//ver la mascotas desde el veterinario
    @GetMapping("/petInfo/{id}")
    public String petInfo(Model model, @PathVariable("id") Long id) {
        mascot mascota = mascotaService.findById(id);
        if (mascota == null) {
            throw new petNotFoundException(id);
        }

        model.addAttribute("pet", mascota);
        return "vetPetInfo";
    }

    //mascotas del cliente loggeado
//localhost:8090/mascotas/mis_mascotas
@GetMapping("/mis_mascotas")
public String showClientPets(Model model, HttpSession session) {
    Cliente loggedInClient = SessionUtil.getLoggedInClient(session);
    if (loggedInClient == null) {
        return "redirect:/";
    }
    System.out.println("Cliente loggeado: " + loggedInClient.getNombre() + "id: " + loggedInClient.getId());
    Collection<mascot> mascotas = mascotaService.findByDueñoId(loggedInClient.getId());
    model.addAttribute("pets", mascotas);
    return "listPage";
}

   
}