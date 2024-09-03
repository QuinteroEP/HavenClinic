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

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import puj.web.clinicahaven.entity.Cliente;
import puj.web.clinicahaven.entity.SessionUtil;
import puj.web.clinicahaven.entity.mascot;
import puj.web.clinicahaven.repositorio.petRepository;
import puj.web.clinicahaven.servicio.ClienteService;
import puj.web.clinicahaven.servicio.petService;



@Controller
@RequestMapping("/mascotas")
public class petController {
    @Autowired
    petService mascotaservice;

    @Autowired
    ClienteService clienteService;

    @Autowired
    private final petRepository petRepo;

    public petController(petRepository petRepo) {
        this.petRepo = petRepo;
    }

    @GetMapping("/informacion")
    public String list(Model model) {
        Collection<mascot> pets = petRepo.findAll();
        model.addAttribute("pets", pets);
        return "listPage";
    }

//registrar Mascota
//localhost:8090/mascotas/agregarmascota
@PostMapping("/agregarmascota")
@Transactional
public String agregarCliente(@ModelAttribute("mascota") mascot mascota, HttpSession session) {
    Cliente loggedInClient = SessionUtil.getLoggedInClient(session);
    if (loggedInClient == null) {
        return "redirect:/";
    }
    Cliente clienteWithMascotas = clienteService.findByCedula(loggedInClient.getCedula());
    mascota.setDueño(clienteWithMascotas);
    clienteWithMascotas.getMascotas().add(mascota);
    clienteService.update(clienteWithMascotas);
    return "redirect:/cliente/mis_mascotas";
}

//Actualizar Mascota
//localhost:8090/mascota/actualizar_mascota/1
  @GetMapping("/actualizar_mascota/{id}")
  public String mostrarFormulario(@PathVariable("id") Long id, Model model) {
    model.addAttribute("mascota", mascotaservice.findById(id));
    return "modificar_mascota";
  }

  @PostMapping("/actualizar_mascota/{id}")
  public String actualizarMascota(@PathVariable("id") Long id, @ModelAttribute("mascota") mascot mascota) {
      mascot existingMascota = mascotaservice.findById(id);
      mascota.setDueño(existingMascota.getDueño());
      mascotaservice.update(mascota);
    return "redirect:/cliente/mis_mascotas";
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
    mascotaservice.deleteById(mascotaToDelete.getId());
    return "redirect:/cliente/mis_mascotas";
}
}