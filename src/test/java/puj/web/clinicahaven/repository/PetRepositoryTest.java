package puj.web.clinicahaven.repository;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import puj.web.clinicahaven.entity.*;
import puj.web.clinicahaven.repositorio.*;
import puj.web.clinicahaven.servicio.csvService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class PetRepositoryTest {

    @Autowired
    private petRepository PetRepository;

    @Autowired
    private clienteRepository ClienteRepository;

    @Autowired
    private tratamientoRepository TratamientoRepository;

    @Autowired
    private drogaRepository DrogaRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @BeforeEach
    public void setUp(){
        //datos quemados de clientes
        ClienteRepository.save(new Cliente("Juan", 123, 1222, "a@c.m", "abc"));
        ClienteRepository.save(new Cliente("Pedro", 124, 1223, "b@c.m", "abc"));
        ClienteRepository.save(new Cliente("Maria", 125, 1224, "c@c.m", "abc"));
        ClienteRepository.save(new Cliente("Luis", 126, 1225, "d@c.m", "abc"));
        ClienteRepository.save(new Cliente("Ana", 127, 1226, "e@c.m", "abc"));
        ClienteRepository.save(new Cliente("Pablo", 1005, 1228, "pq@c.m", "abcd"));
        ClienteRepository.save(new Cliente("Lucas", 12663, 1216, "luc@c.m", "cba"));
        ClienteRepository.save(new Cliente("Johnny", 12666, 1126, "jh@c.m", "bac"));
        ClienteRepository.save(new Cliente("Juan", 123456789, 346123, "juan.perez@example.com", "Segura123!"));
        ClienteRepository.save(new Cliente("Ana", 234567, 634567, "ana.gomez@example.com", "Contraseña456!"));

        //datos quemados de mascotas
        PetRepository.save(new mascota("Moira", 10, "Labrador Negro", "/Images/pets/perroMoira.jpg", "Hembra",  "displacia de cadera", "Animal de edad mayor; su condicion le causa dolor en la pata trazera derecha"));
        PetRepository.save(new mascota("Trufa", 8, "Labrador Chocolate", "/Images/pets/perroTrufa.jpg", "Hembra", "en recuperacion de cesarea", "El animal dio a luz a 4 cachorros labrador (3 chocolate, 1 negro - todos hembras) por medio de cesarea"));
        PetRepository.save(new mascota("Bill", 4, "Criollo", "/Images/pets/perroBill.jpg", "Macho", "fractura en la pata izquierda trasera", "El animal callejero fue golpeado por un carro; presenta dificultad para caminar"));
        PetRepository.save(new mascota("Joseph", 6, "Labrador Negro", "/Images/pets/perroJoseph.jpg", "Macho" , "herida de mordida cerca del ojo derecho", "El animal fue mordido por uno de sus hermanos mientras jugaban. Presenta secrecion en el ojo e inflamacion en la zona del parpado"));
        PetRepository.save(new mascota("Venus", 1, "Labrador Negro", "/Images/pets/perroVenus.jpg", "Hembra" , "Vomito", ""));
        PetRepository.save(new mascota("Belen", 9, "Labrador Negro", "/Images/pets/perroBelen.jpg", "Hembra", "Ansiedad", ""));
        PetRepository.save(new mascota("Milan", 7, "Labrador Negro", "/Images/pets/perroMilan.jpg", "Macho", "Corneas inflamadas", "Los parpado del perro estan invertidos hacia sus ojos, causandole inflamacion en la cornea por sus pestañas, pero su vision no se ve afectada de forma significante"));
        PetRepository.save(new mascota("Lucia", 6, "Criollo", "/Images/pets/perroLucia.jpg", "Hembra", "Ansiedad", ""));
        PetRepository.save(new mascota("Suco", 8, "Gran Danes", "/Images/pets/perroSuco.jpg", "Macho", "Artritis", "Presenta dolor en la pata trazera izquierda"));
        PetRepository.save(new mascota("Napoleon", 0, "Chihuahua", "/Images/pets/perroNapo.jpg", "Macho", "Recien Nacido", ""));
        PetRepository.save(new mascota("Charlie", 1, "Perro", "", "Macho", "Psitacosis", ""));

        //Datos quemados de veterinarios
        veterinarioRepository.save(new Veterinario(1234, "Admin", 111, "Cardilogia", "abc", "", 0, "qwe@m.c"));
        veterinarioRepository.save(new Veterinario(0301, "Juan Pérez", 1234, "Cirugia", "vetpass1", " ", 0, "juan.perez@vetclinic.com"));
        veterinarioRepository.save(new Veterinario(1103, "Carlos Ramírez", 3456, "Cardilogia", "vetpass3", " ", 0, "carlos.ramirez@vetclinic.com"));
        veterinarioRepository.save(new Veterinario(4004, "Ana González", 4567, "Nutricion", "vetpass4", " ", 0, "ana.gonzalez@vetclinic.com"));
        veterinarioRepository.save(new Veterinario(0065, "Luis Fernández", 5678, "Dentista", "vetpass5", " ", 0, "luis.fernandez@vetclinic.com"));

        //Datos de drogas
        DrogaRepository.save(new Droga("ACOLAN", 10, 1000, 100, 10));
        DrogaRepository.save(new Droga("ACTIONIS", 20, 2000, 200, 20));
        DrogaRepository.save(new Droga("ACUIMIX", 30, 3000, 300, 30));
        DrogaRepository.save(new Droga("ALSIR", 40, 4000, 400, 40));
        DrogaRepository.save(new Droga("AUROFAC", 50, 5000, 500, 50));
        DrogaRepository.save(new Droga("CEBIN", 60, 6000, 600, 60));
        DrogaRepository.save(new Droga("CEMAY", 70, 7000, 700, 70));
        DrogaRepository.save(new Droga("CENDOX", 80, 8000, 800, 80));
        DrogaRepository.save(new Droga("COLFIVE", 90, 9000, 900, 90));
        DrogaRepository.save(new Droga("COLIMIX", 100, 10000, 1000, 100));


        //datos de tratamiento
        TratamientoRepository.save(new Tratamiento(LocalDate.parse("2024-10-01"), "ACOLAN"));
        TratamientoRepository.save(new Tratamiento(LocalDate.parse("2024-10-02"), "ACTIONIS"));
        TratamientoRepository.save(new Tratamiento(LocalDate.parse("2024-10-03"), "ACUIMIX"));
        TratamientoRepository.save(new Tratamiento(LocalDate.parse("2024-10-04"), "ALSIR"));
        TratamientoRepository.save(new Tratamiento(LocalDate.parse("2024-10-05"), "AUROFAC"));
        TratamientoRepository.save(new Tratamiento(LocalDate.parse("2024-10-06"),  "CEBIN"));
        TratamientoRepository.save(new Tratamiento(LocalDate.parse("2024-10-07"), "CEMAY"));
        TratamientoRepository.save(new Tratamiento(LocalDate.parse("2024-10-08"),  "CENDOX"));
        TratamientoRepository.save(new Tratamiento(LocalDate.parse("2024-10-09"), "COLFIVE"));
        TratamientoRepository.save(new Tratamiento(LocalDate.parse("2024-10-10"),  "COLIMIX"));

        // Asociar mascotas a dueños ciclicamente
        List<mascota> mascotas = PetRepository.findAll();
        List<Cliente> clientes = ClienteRepository.findAll();
        List<Droga> drogas = DrogaRepository.findAll();
        List<Tratamiento> tratamientos = TratamientoRepository.findAll();
        List<Veterinario> veterinarios = veterinarioRepository.findAll();

        for (int i = 0; i < mascotas.size(); i++) {
            mascotas.get(i).setDueño(clientes.get(i % clientes.size()));
            PetRepository.save(mascotas.get(i));
        }


        //Asignar tratamientos
        int[] repetitions = {4, 3, 2, 1};
        int mascotaIndex = 0;
        int veterinarioIndex = 0;
        int x=0;
        for (int i = 0; i < repetitions.length; i++) {
            for (int j = 0; j < repetitions[i]; j++) {

                Tratamiento tratamiento = tratamientos.get(x);
                tratamiento.setIdMascota(mascotas.get(mascotaIndex % mascotas.size()).getId());
                mascotas.get(mascotaIndex % mascotas.size()).setEnTratamiento(true);
                tratamiento.setIdVeterinario(veterinarios.get(veterinarioIndex % veterinarios.size()).getVetId());
                veterinarios.get(veterinarioIndex % veterinarios.size()).setNumAtenciones(veterinarios.get(veterinarioIndex % veterinarios.size()).getNumAtenciones() + 1);


                tratamiento.setDroga(drogas.get(i % drogas.size()));
                drogas.get(i % drogas.size()).setUnidadesDisponibles(drogas.get(i % drogas.size()).getUnidadesDisponibles() - 1);
                drogas.get(i % drogas.size()).setUnidadesVendidas(drogas.get(i % drogas.size()).getUnidadesVendidas() + 1);

                tratamiento.setNombredroga(drogas.get(i % drogas.size()).getNombre());
                TratamientoRepository.save(tratamiento);
                x++;
                mascotaIndex++;
                veterinarioIndex++;
            }
        }

        for (int i = 0; i < mascotas.size(); i++) {
            if(mascotas.get(i).isEnTratamiento()){
                mascotas.get(i).setTratamiento(tratamientos.get(i % tratamientos.size()));
            }
            PetRepository.save(mascotas.get(i));
        }
    }

    //Pruebas CRUD del repositorio de mascotas
   @Test
    public void PetRepositoryTest_save_Pet() {
        //1. arrange
        mascota pet = new mascota("Firulais", 5, "Labrador","url", "Macho",  "Buena", "Muy tierno");
        //2. act
        mascota savedPet = PetRepository.save(pet);
        //3. assert
        Assertions.assertThat(savedPet).isNotNull();
    }
    @Test
    public void PetRepositoryTest_update_Pet(){
        //1. arrange
        mascota pet = new mascota("Firulais", 5, "Labrador","url", "Macho",  "Buena", "Muy tierno");
        //2. act
        mascota savedPet = PetRepository.save(pet);
        savedPet.setNombre("Firulais2");
        PetRepository.save(savedPet);
        //3. assert
        Assertions.assertThat(savedPet).isNotNull();
        Assertions.assertThat(savedPet.getNombre()).isEqualTo("Firulais2");
    }
    @Test
    public void PetRepositoryTest_deleteById_EmptyPet(){
        //1. arrange
        Long index = 1L;
        //2. act
        PetRepository.deleteById(index);
        //3. assert
        Assertions.assertThat(PetRepository.findById(index)).isEmpty();
    }
    @Test
    public void PetRepositoryTest_findById_Pet(){
        //1. arrange
        Long index = 1L;
        //2. act
        Optional<mascota> pet = PetRepository.findById(index);
        //3. assert
        Assertions.assertThat(pet).isNotEmpty();
        Assertions.assertThat(pet.get().getId()).isEqualTo(1);
    }

    //Pruebas de consultas personalizadas

   @Test
    public void PetRepositoryTest_findALL_NotEMptyList(){
        //1. arrange
        mascota pet = new mascota("Firulais", 5, "Labrador","url", "Macho",  "Buena", "Muy tierno");
        mascota pet2 = new mascota("Firulais2", 5, "Labrador","url", "Macho",  "Buena", "Muy tierno");

        //2. act
        PetRepository.save(pet);
        PetRepository.save(pet2);
        List<mascota> pets = PetRepository.findAll();
        //3. assert
        Assertions.assertThat(pets).isNotEmpty();
        Assertions.assertThat(pets.size()).isEqualTo(13);
        Assertions.assertThat(pets.size()).isGreaterThan(0);
    }

    @Test
    public void PetRepositoryTest_findById_FindWrongIndex(){
        //1. arrange
        Long index = -1L;
        //2. act
        Optional<mascota> pet = PetRepository.findById(index);
        //3. assert
        Assertions.assertThat(pet).isEmpty();
    }



    @Test
    public void PetRepositoryTest_findByNombre_Pet(){
        //1. arrange
        String nombre = "Moira";
        //2. act
        List<mascota> pets = PetRepository.findByNombre(nombre);
        //3. assert
        Assertions.assertThat(pets).isNotEmpty();
        Assertions.assertThat(pets.size()).isEqualTo(1);
    }

    @Test
    public void PetRepositoryTest_findByDueño_Pet(){
        //1. arrange
        Cliente dueño = ClienteRepository.findByCedula(123);
        //2. act
        List<mascota> pets = PetRepository.findByDueño(dueño);
        //3. assert
        Assertions.assertThat(pets).isNotEmpty();
        Assertions.assertThat(dueño.getNombre()).isEqualTo(pets.get(0).getDueño().getNombre());
    }

    @Test
    public void PetRepositoryTest_findByDueñoId_Pet(){
        //1. arrange
        Long id = 2L;
        //2. act
        List<mascota> pets = PetRepository.findByDueñoId(id);
        //3. assert
        Assertions.assertThat(pets).isNotEmpty();
        Assertions.assertThat(pets.get(0).getDueño().getId()).isEqualTo(2);
    }
    @Test
    public void PetRepositoryTest_countByEnTratamiento_Pet(){
        //1. arrange
        boolean enTratamiento = true;
        //2. act
        long count = PetRepository.countByEnTratamiento(enTratamiento);
        //3. assert
        Assertions.assertThat(count).isEqualTo(10);
    }

}
