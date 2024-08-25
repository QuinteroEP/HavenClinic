package puj.web.clinicahaven.entity;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;
import puj.web.clinicahaven.repositorio.clienteRepository;
import puj.web.clinicahaven.repositorio.petRepository;

import java.util.List;

@Controller
@Transactional
public class DatabaseInit implements ApplicationRunner {

    @Autowired
    clienteRepository clienteRepository1;
    @Autowired
    petRepository petRepository1;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //datos quemados de clientes
        clienteRepository1.save(new Cliente("Juan", 123, 1222, "a@c.m", "abc"));
        clienteRepository1.save(new Cliente("Pedro", 124, 1223, "b@c.m", "abc"));
        clienteRepository1.save(new Cliente("Maria", 125, 1224, "c@c.m", "abc"));
        clienteRepository1.save(new Cliente("Luis", 126, 1225, "d@c.m", "abc"));
        clienteRepository1.save(new Cliente("Ana", 127, 1226, "e@c.m", "abc"));

        //datos quemados de mascotas
        petRepository1.save(new mascot("Firulais", "Perro", "Labrador", "Macho", "1", "1"));
        petRepository1.save(new mascot("Mishi", "Gato", "Siames", "Hembra", "2", "2"));
        petRepository1.save(new mascot("Piolin", "Pajaro", "Canario", "Macho", "3", "3"));
        petRepository1.save(new mascot("Nemo", "Pez", "Payaso", "Macho", "4", "4"));
        petRepository1.save(new mascot("Moira", "10 años", "Labrador Negro", "/Images/pets/20240330_170037.jpg",  "displacia de cadera", "Animal de edad mayor; su condicion le causa dolor en la pata trazera derecha"));
        petRepository1.save(new mascot("Trufa", "8 años", "Labrador Chocolate", "/Images/pets/20240327_143235.jpg",  "en recuperacion de cesarea", "El animal dio a luz a 4 cachorros labrador (3 chocolate, 1 negro - todos hembras) por medio de cesarea"));
        petRepository1.save(new mascot("Bill", "4 años", "Criollo", "/Images/pets/20231216_135756.jpg",  "fractura en la pata izquierda trasera", "El animal callejero fue golpeado por un carro; presenta dificultad para caminar"));
        petRepository1.save(new mascot("Joseph", "6 años", "Labrador Negro", " ",  "herida de mordida cerca del ojo derecho", "El animal fue mordido por uno de sus hermanos mientras jugaban. Presenta secrecion en el ojo e inflamacion en la zona del parpado"));

        // Asociar mascotas a dueños ciclicamente
        List<Cliente> clientes = clienteRepository1.findAll();
        List<mascot> mascotas = petRepository1.findAll();

        for (int i = 0; i < mascotas.size(); i++) {
            mascotas.get(i).setDueño(clientes.get(i % clientes.size()));
            petRepository1.save(mascotas.get(i));
        }
    }
}
