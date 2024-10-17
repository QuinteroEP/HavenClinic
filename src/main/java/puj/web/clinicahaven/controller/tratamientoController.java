package puj.web.clinicahaven.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import puj.web.clinicahaven.entity.Tratamiento;
import puj.web.clinicahaven.entity.mascota;
import puj.web.clinicahaven.servicio.petService;
import puj.web.clinicahaven.servicio.tratamientoService;

@RestController
@RequestMapping("/tratamientos")
@CrossOrigin(origins = "http://localhost:4200")
public class tratamientoController {
    @Autowired
    petService mascotaService;

    @Autowired
    tratamientoService tratamientoService;

    //agregar tratamiento
    //localhost:8090/tratamientos/add/1
    @PostMapping("/add/{id}")
    @Operation(summary = "agregar un tratamiento a una mascota")
    public ResponseEntity<mascota> newTreatment(Model model, @PathVariable("id") Long id, @RequestBody Tratamiento tratamiento  ) {
        mascota mascota = mascotaService.findById(id);
        if(!mascota.isEnTratamiento()){
            mascota.setEnTratamiento(true);
        }
        mascota.setTratamiento(tratamiento);
        mascotaService.update(mascota);
        
        tratamientoService.add(tratamiento);
        return ResponseEntity.ok(mascota);
    }

    
    //cambiar el estado del tratamiento de una mascota
    //localhost:8090/tratamientos/update/1
    @PutMapping("/update/{id}")
    @Operation(summary = "cambiar el estado del tratamiento de una mascota")
    public ResponseEntity<mascota> alterTreatment(Model model, @PathVariable("id") Long id) {
        mascota mascota = mascotaService.findById(id);
        if(mascota.isEnTratamiento()){
            mascota.setEnTratamiento(false);
        }
        else{
            mascota.setEnTratamiento(true);
        }
        mascotaService.update(mascota);
        return ResponseEntity.ok(mascota);
    }

    //mostrar informacion del tratamiento
      //localhost:8090/tratamientos/info/1
      @GetMapping("/info/{id}")
      public Tratamiento infoTratamiento(@PathVariable("id") Long id) {
          return tratamientoService.findById(id);
      }

      //Historial medico de la mascota
        //localhost:8090/tratamientos/historial/1
        @GetMapping("/historial/{id}")
        @Operation(summary = "ver historial de la Mascota seleccionada")
        public List<Tratamiento> petHistory(Model model, @PathVariable("id") Long id) {
            mascota mascota = mascotaService.findById(id);
            List<Tratamiento> historial = tratamientoService.getHistorial(mascota.getId());

            return  historial;
        }

        //Obtener tratamiento apartir de la id de una mascota
        //http://localhost:8090/tratamientos/mascota/1
        @GetMapping("/mascota/{id}")
        @Operation(summary = "ver historial de la Mascota seleccionada")
        public Tratamiento petTreatment(Model model, @PathVariable("id") Long id) {
            Tratamiento tratamiento = tratamientoService.findByPetId(id);
            return  tratamiento;
        }
}
