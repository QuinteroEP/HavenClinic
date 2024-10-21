package puj.web.clinicahaven.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.anyLong;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

import puj.web.clinicahaven.entity.mascota;
import puj.web.clinicahaven.servicio.ClienteService;
import puj.web.clinicahaven.servicio.petService;

@WebMvcTest(controllers = petController.class)
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class PetControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private petService petService;

    @MockBean
    private ClienteService clienteService;

    @Autowired
    ObjectMapper ObjectMapper;

    @Test
    public void petControllar_Add() throws Exception {
        mascota mascotaNueva = new mascota(
            "Luciano", 
            5, 
            "Labrador Negro", 
            "", 
            "Macho",  
            "displacia de cadera",
            "Dolor en la pata trazera derecha"
        );

        when(petService.agregar(Mockito.any(mascota.class))).thenReturn(mascotaNueva);

        ResultActions response = mockMvc.perform(
            post("/mascotas/addPet/1")
            .contentType("application/json")
            .content(ObjectMapper.writeValueAsString(mascotaNueva)));

        response.andExpect(status().isCreated())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.nombre").value(mascotaNueva.getNombre()));
    }

    @Test
    public void petController_findAll() throws Exception{
        when(petService.findAll()).thenReturn(
            List.of(
                new mascota(
                    "Luciano", 
                    5, 
                    "Labrador Negro", 
                    "", 
                    "Macho",  
                    "displacia de cadera",
                    "Dolor en la pata trazera derecha"
                ),
                new mascota(
                    "Yan", 
                    5, 
                    "Labrador Negro", 
                    "", 
                    "Macho",  
                    "displacia de cadera",
                    "Dolor en la pata trazera derecha"
                )
            )
        );

        ResultActions response = mockMvc.perform(
            get("/mascotas/vetmascota"));

        response.andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    public void petController_findById() throws Exception{
        Long id = 1L;

        when(petService.findById(id)).thenReturn(
            new mascota(
                "Zoe", 
                1, 
                "Labrador Negro", 
                "", 
                "Hembra",  
                "displacia de cadera",
                "Dolor en la pata trazera derecha"
            )
        );

        ResultActions response = mockMvc.perform(
            get("/mascotas/petInfo/1"));

        response.andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.nombre").value("Zoe"));
    }

    @Test
    public void petController_findById_NotFound() throws Exception{
        when(petService.findById(anyLong())).thenReturn(null);

        ResultActions response = mockMvc.perform(
            get("/mascotas/petInfo/0"));

        response.andExpect(status().isNotFound());
    }

    @Test
    public void petController_findOwnPets() throws Exception{
        Long id = 1L;

        when(petService.findByDueñoId(id)).thenReturn(
            List.of(
                new mascota(
                    "Luciano", 
                    5, 
                    "Labrador Negro", 
                    "", 
                    "Macho",  
                    "displacia de cadera",
                    "Dolor en la pata trazera derecha"
                ),
                new mascota(
                    "Yan", 
                    5, 
                    "Labrador Negro", 
                    "", 
                    "Macho",  
                    "displacia de cadera",
                    "Dolor en la pata trazera derecha"
                )
            )
        );

        ResultActions response = mockMvc.perform(
            get("/mascotas/mascotascliente/1"));

        response.andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    public void petController_findByName() throws Exception{
        String nombre = "Kiara";
        when(petService.findByNombre(nombre)).thenReturn(
            List.of(
                new mascota(
                    "Kiara", 
                    5, 
                    "Labrador Negro", 
                    "", 
                    "Hembra",  
                    "displacia de cadera",
                    "Dolor en la pata trazera derecha"
                )
            )
        );

        ResultActions response = mockMvc.perform(
            get("/mascotas/findByNombre/Kiara"));

        response.andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$[0].nombre").value("Kiara"));
    }

    @Test
    public void petController_Delete() throws Exception{
        ResultActions response = mockMvc.perform(
            delete("/mascotas/deletePet/1"));

        response.andExpect(status().isNoContent());
    }

    @Test
    public void petController_Update() throws Exception{
        Long id = 1L;
        mascota mascotaActualizada = new mascota(
            "Moira", 
            11, 
            "Labrador Negro", 
            "", 
            "Hembra",  
            "displacia de cadera",
            "Dolor en la pata trazera derecha"
        );

        when(petService.findById(id)).thenReturn(mascotaActualizada);

        ResultActions response = mockMvc.perform(
            put("/mascotas/actualizar_mascota/1")
            .contentType("application/json")
            .content(ObjectMapper.writeValueAsString(mascotaActualizada)));

        response.andExpect(status().isOk());
    }

    @Test
    public void petController_Update_NotFound() throws Exception{
        Long id = 0L;
        mascota mascotaActualizada = new mascota(
            "Moira", 
            11, 
            "Labrador Negro", 
            "", 
            "Hembra",  
            "displacia de cadera",
            "Dolor en la pata trazera derecha"
        );
        when(petService.findById(id)).thenReturn(null);

        ResultActions response = mockMvc.perform(
            put("/mascotas/actualizar_mascota/0")
            .contentType("application/json")
            .content(ObjectMapper.writeValueAsString(mascotaActualizada)));

        response.andExpect(status().isNotFound());
    }
}

