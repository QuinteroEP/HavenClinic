package puj.web.clinicahaven.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;
import puj.web.clinicahaven.entity.Cliente;
import puj.web.clinicahaven.entity.SessionUtil;
import puj.web.clinicahaven.entity.mascota;
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
      public List<mascota> listPage() {
         return mascotaService.findAll();
      }


      //mascotas de cada cliente por id //no se usa por ahora
      //localhost:8090/mascotas/mascotascliente/1
      @GetMapping("/mascotascliente/{id}")
      public List<mascota> Mascotacliente(@PathVariable("id") Long id) {
          return mascotaService.findByDueñoId(id);
      }
      
    //mascotas del cliente loggeado
    //localhost:8090/mascotas/mis_mascotas
    @GetMapping("/mis_mascotas")
    public List<mascota> showClientPets( HttpSession session) {
        Cliente loggedInClient = SessionUtil.getLoggedInClient(session);
        System.out.println("Cliente loggeado: " + loggedInClient.getNombre() + "id: " + loggedInClient.getId());
        List<mascota> mascotas = mascotaService.findByDueñoId(loggedInClient.getId());

        return mascotas;
    }

    //registrar mascota nueva
    //localhost:8090/mascotas/vetAddPet
        @PostMapping("/addPet/{id}")
        public void addPet(@PathVariable("id") int id,@RequestBody mascota mascota){
            Cliente cliente = clienteService.findByCedula(id);
            mascota.setDueño(cliente);
            mascotaService.agregar(mascota);
        
        }

    //Actualizar Mascota
    //localhost:8090/mascotas/actualizar_mascota/1
     @PutMapping("/actualizar_mascota/{id}")
     @Operation(summary = "actualizar la informacion de la Mascota seleccionada")
    public ResponseEntity<mascota> actualizarMascota(@RequestBody mascota mascota, @PathVariable("id") Long id) {
        mascota existingMascota = mascotaService.findById(id);
        if (existingMascota == null) {
            return ResponseEntity.notFound().build();
        }
        mascota.setDueño(existingMascota.getDueño());
        mascotaService.update(mascota);
        return ResponseEntity.ok(mascota);
    }



    //Eliminar mascota veterinario
    //localhost:8090/mascotas/deletePet/2
    @DeleteMapping("/deletePet/{id}")
    @Operation(summary = "Eliminar la Mascota seleccionada")
    public void deletePetVet(@PathVariable("id") Long id) {
        mascotaService.deleteById(id);
    
    }
    
    //ver informacion de la mascotas
    //localhost:8090/mascotas/petInfo/1
        @GetMapping("/petInfo/{id}")
        @Operation(summary = "ver la Mascota seleccionada")
        public mascota petInfo(Model model, @PathVariable("id") Long id) {
            mascota mascota = mascotaService.findById(id);
            return  mascota;
        }
}