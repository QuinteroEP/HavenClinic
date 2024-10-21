package puj.web.clinicahaven.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import puj.web.clinicahaven.entity.Tratamiento;
import puj.web.clinicahaven.repositorio.tratamientoRepository;
import puj.web.clinicahaven.servicio.tratamientoImplementation;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class TratamientoServiceTestMock {

    @InjectMocks //La clase que se esta probando
    private tratamientoImplementation TratamientoService;

    @Mock //Clases que se van a usar
    tratamientoRepository repo;

    @BeforeEach
    public void init(){ }

    @Test
    public void TratamientoServicio_Add(){
        Tratamiento testTratamiento= new Tratamiento(LocalDate.parse("2024-10-01"), "ACOLAN", 1L, 1L, 1L);
        when(repo.save(testTratamiento)).thenReturn(testTratamiento);

        Tratamiento newTratamiento = TratamientoService.add(testTratamiento);
        
        Assertions.assertThat(newTratamiento).isNotNull();
    }

    @Test
    public void TratamientoService_FindById(){
        Long id = 1L;
        Tratamiento testTratamiento = new Tratamiento(LocalDate.parse("2024-10-01"), "ACOLAN", 1L, 1L, 1L);
        when(repo.findById(id)).thenReturn(
            Optional.of(testTratamiento)
        );

        Tratamiento result = TratamientoService.findById(id);

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getId()).isEqualTo(id);
    }

    @Test
    public void TratamientoServicio_getHistorial(){
        Long id = 1L;
        when(repo.getHistorial(id)).thenReturn(
            List.of(
                new Tratamiento(LocalDate.parse("2024-10-01"), "ACOLAN", 1L, 1L, 1L),
                new Tratamiento(LocalDate.parse("2024-12-01"), "ACOLAN", 1L, 1L, 1L)
            ) 
        );

        TratamientoService.getHistorial(id);
        
        Assertions.assertThat(TratamientoService.getHistorial(id)).isNotNull();
        Assertions.assertThat(TratamientoService.getHistorial(id).size()).isEqualTo(2);
    }

    @Test
    public void TratamientoServicio_findByPetId(){
        Long id = 2L;
        Tratamiento testTratamiento = new Tratamiento(LocalDate.parse("2024-10-01"), "ACOLAN", 1L, 2L, 1L);
        when(repo.findByPetId(id)).thenReturn(
            testTratamiento
        );

        TratamientoService.findByPetId(id);
        
        Assertions.assertThat(TratamientoService.findByPetId(id)).isNotNull();
        Assertions.assertThat(TratamientoService.findByPetId(id).getIdMascota()).isEqualTo(id);
    }
    
    /*
    @Test
    public void TratamientoServiceNaive_FindById() {
        //1. Arrange
        Long id = 1L;
        //2. Act
        TratamientoService.findById(id);
        //3. Assert
        Assertions.assertThat(TratamientoService.findById(id)).isNotNull();
        Assertions.assertThat(TratamientoService.findById(id).getId()).isEqualTo(1);
    }
 */
}
