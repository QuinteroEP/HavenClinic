package puj.web.clinicahaven.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import puj.web.clinicahaven.entity.Tratamiento;
import puj.web.clinicahaven.servicio.tratamientoService;

import java.time.LocalDate;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class TratamientoServiceNaive {

    @Autowired
    private tratamientoService TratamientoService;

    @BeforeEach
    public void setUp() {
        TratamientoService.add(new Tratamiento(LocalDate.parse("2024-10-01"), "ACOLAN", 1L, 1L, 1L));
        TratamientoService.add(new Tratamiento(LocalDate.parse("2024-10-02"), "ACTIONIS", 2L, 2L, 2L));
        TratamientoService.add(new Tratamiento(LocalDate.parse("2024-10-03"), "ACUIMIX", 3L, 3L, 3L));
        TratamientoService.add(new Tratamiento(LocalDate.parse("2024-10-04"), "ALSIR", 1L, 4L, 4L));
        TratamientoService.add(new Tratamiento(LocalDate.parse("2024-10-05"), "AUROFAC", 2L, 2L, 5L));    }

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

    @Test
    public void TratamientoServiceNaive_GetHistorial() {
        //1. Arrange
        Long id = 2L;
        //2. Act
        TratamientoService.getHistorial(id);
        //3. Assert
        Assertions.assertThat(TratamientoService.getHistorial(id)).isNotNull();
        Assertions.assertThat(TratamientoService.getHistorial(id).size()).isEqualTo(2);
    }

}
