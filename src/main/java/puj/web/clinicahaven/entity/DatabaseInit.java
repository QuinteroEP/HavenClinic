package puj.web.clinicahaven.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import jakarta.transaction.Transactional;
import puj.web.clinicahaven.repositorio.VeterinarioRepository;
import puj.web.clinicahaven.repositorio.clienteRepository;
import puj.web.clinicahaven.repositorio.drogaRepository;
import puj.web.clinicahaven.repositorio.petRepository;
import puj.web.clinicahaven.repositorio.tratamientoRepository;
import puj.web.clinicahaven.servicio.csvService;

@Controller
@Transactional
public class DatabaseInit implements ApplicationRunner {

    @Autowired
    clienteRepository clienteRepository1;
    @Autowired
    petRepository petRepository1;
    @Autowired
    VeterinarioRepository veterinarioRepository;
    @Autowired
    drogaRepository drogaRepository;
    @Autowired
    csvService csvService;
    @Autowired
    tratamientoRepository tratamientoRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        
        //datos quemados de clientes
        clienteRepository1.save(new Cliente("Juan", 123, 1222, "a@c.m", "abc"));
        clienteRepository1.save(new Cliente("Pedro", 124, 1223, "b@c.m", "abc"));
        clienteRepository1.save(new Cliente("Maria", 125, 1224, "c@c.m", "abc"));
        clienteRepository1.save(new Cliente("Luis", 126, 1225, "d@c.m", "abc"));
        clienteRepository1.save(new Cliente("Ana", 127, 1226, "e@c.m", "abc"));
        clienteRepository1.save(new Cliente("Pablo", 1005, 1228, "pq@c.m", "abcd"));
        clienteRepository1.save(new Cliente("Lucas", 12663, 1216, "luc@c.m", "cba"));
        clienteRepository1.save(new Cliente("Johnny", 12666, 1126, "jh@c.m", "bac"));
        clienteRepository1.save(new Cliente("Juan", 123456789, 346123, "juan.perez@example.com", "Segura123!"));
        clienteRepository1.save(new Cliente("Ana", 234567, 634567, "ana.gomez@example.com", "Contraseña456!"));
        clienteRepository1.save(new Cliente("Luis", 345678, 645678, "luis.martinez@example.com", "Password789!"));
        clienteRepository1.save(new Cliente("Maria", 456789, 656789, "maria.lopez@example.com", "Clave101112!"));
        clienteRepository1.save(new Cliente("Pedro", 567890, 667890, "pedro.fernandez@example.com", "Secreta1314!"));
        clienteRepository1.save(new Cliente("Laura", 678901, 678901, "laura.torres@example.com", "Contraseña1516!"));
        clienteRepository1.save(new Cliente("Jorge Ramírez", 78902, 689012, "jorge.ramirez@example.com", "Password1718!"));
        clienteRepository1.save(new Cliente("Carla Sánchez", 80123, 690123, "carla.sanchez@example.com", "Clave1920!"));
        clienteRepository1.save(new Cliente("Fernando Ruiz", 90234, 701234, "fernando.ruiz@example.com", "Secreta2122!"));
        clienteRepository1.save(new Cliente("Sofia Morales", 12346, 712345, "sofia.morales@example.com", "Contraseña2324!"));
        clienteRepository1.save(new Cliente("Hugo Mendoza", 2347, 723456, "hugo.mendoza@example.com", "Password2526!"));
        clienteRepository1.save(new Cliente("Valeria Castro", 5678, 734567, "valeria.castro@example.com", "Clave2728!"));
        clienteRepository1.save(new Cliente("Eduardo Vargas", 4789, 745678, "eduardo.vargas@example.com", "Secreta2930!"));
        clienteRepository1.save(new Cliente("Daniela Soto", 56789, 756789, "daniela.soto@example.com", "Contraseña3132!"));
        clienteRepository1.save(new Cliente("Andrés López", 601, 767890, "andres.lopez@example.com", "Password3334!"));
        clienteRepository1.save(new Cliente("Isabel Gómez", 78902, 778901, "isabel.gomez@example.com", "Clave3536!"));
        clienteRepository1.save(new Cliente("Javier Martínez", 0123, 789012, "javier.martinez@example.com", "Secreta3738!"));
        clienteRepository1.save(new Cliente("Natalia Pérez", 934, 790123, "natalia.perez@example.com", "Contraseña3940!"));
        clienteRepository1.save(new Cliente("Óscar Torres", 12456, 801234, "oscar.torres@example.com", "Password4142!"));
        clienteRepository1.save(new Cliente("Camila Rodríguez", 4567, 812345, "camila.rodriguez@example.com", "Clave4344!"));
        clienteRepository1.save(new Cliente("Ricardo Díaz", 35678, 823456, "ricardo.diaz@example.com", "Secreta4546!"));
        clienteRepository1.save(new Cliente("Gabriela Fernández", 6789, 834567, "gabriela.fernandez@example.com", "Contraseña4748!"));
        clienteRepository1.save(new Cliente("Samuel Hernández", 67890, 845678, "samuel.hernandez@example.com", "Password4950!"));
        clienteRepository1.save(new Cliente("Paola Morales", 67901, 856789, "paola.morales@example.com", "Clave5152!"));
        clienteRepository1.save(new Cliente("Rafael García", 7012, 867890, "rafael.garcia@example.com", "Secreta5354!"));
        clienteRepository1.save(new Cliente("Juliana Silva", 8903, 878901, "juliana.silva@example.com", "Contraseña5556!"));
        clienteRepository1.save(new Cliente("Alejandro Martínez", 234, 889012, "alejandro.martinez@example.com", "Password5758!"));
        clienteRepository1.save(new Cliente("Mariana Ruiz", 126, 890123, "mariana.ruiz@example.com", "Clave5960!"));
        clienteRepository1.save(new Cliente("Luisana Castro", 234567, 901234, "luisana.castro@example.com", "Secreta6162!"));
        clienteRepository1.save(new Cliente("Sebastián Gómez", 3678, 912345, "sebastian.gomez@example.com", "Contraseña6364!"));
        clienteRepository1.save(new Cliente("Melissa Rodríguez", 456789, 923456, "melissa.rodriguez@example.com", "Password6566!"));
        clienteRepository1.save(new Cliente("Felipe González", 50, 934567, "felipe.gonzalez@example.com", "Clave6768!"));
        clienteRepository1.save(new Cliente("Carolina López", 91, 945678, "carolina.lopez@example.com", "Secreta6970!"));
        clienteRepository1.save(new Cliente("Alejandra Morales", 78012, 956789, "alejandra.morales@example.com", "Contraseña7172!"));
        clienteRepository1.save(new Cliente("Guillermo Martínez", 8123, 967890, "guillermo.martinez@example.com", "Password7374!"));
        clienteRepository1.save(new Cliente("Liliana Pérez", 901230, 978901, "liliana.perez@example.com", "Clave7576!"));
        clienteRepository1.save(new Cliente("Martha Ramírez", 1234506, 989012, "martha.ramirez@example.com", "Secreta7778!"));
        clienteRepository1.save(new Cliente("Esteban Torres", 2342567, 990123, "esteban.torres@example.com", "Contraseña7980!"));
        clienteRepository1.save(new Cliente("Catherine Fernández", 3415678, 100234, "catherine.fernandez@example.com", "Password8182!"));
        clienteRepository1.save(new Cliente("Héctor Rodríguez", 4563789, 101345, "hector.rodriguez@example.com", "Clave8384!"));
        clienteRepository1.save(new Cliente("Samantha Gómez", 5678940, 102456, "samantha.gomez@example.com", "Secreta8586!"));
        clienteRepository1.save(new Cliente("Rodrigo Castro", 6782901, 103567, "rodrigo.castro@example.com", "Contraseña8788!"));

        //datos quemados de mascotas
        petRepository1.save(new mascot("Moira", 10, "Labrador Negro", "/Images/pets/perroMoira.jpg", "Hembra",  "displacia de cadera", "Animal de edad mayor; su condicion le causa dolor en la pata trazera derecha"));
        petRepository1.save(new mascot("Trufa", 8, "Labrador Chocolate", "/Images/pets/perroTrufa.jpg", "Hembra", "en recuperacion de cesarea", "El animal dio a luz a 4 cachorros labrador (3 chocolate, 1 negro - todos hembras) por medio de cesarea"));
        petRepository1.save(new mascot("Bill", 4, "Criollo", "/Images/pets/perroBill.jpg", "Macho", "fractura en la pata izquierda trasera", "El animal callejero fue golpeado por un carro; presenta dificultad para caminar"));
        petRepository1.save(new mascot("Joseph", 6, "Labrador Negro", "/Images/pets/perroJoseph.jpg", "Macho" , "herida de mordida cerca del ojo derecho", "El animal fue mordido por uno de sus hermanos mientras jugaban. Presenta secrecion en el ojo e inflamacion en la zona del parpado"));
        petRepository1.save(new mascot("Venus", 1, "Labrador Negro", "/Images/pets/perroVenus.jpg", "Hembra" , "Vomito", ""));
        petRepository1.save(new mascot("Belen", 9, "Labrador Negro", "/Images/pets/perroBelen.jpg", "Hembra", "Ansiedad", ""));
        petRepository1.save(new mascot("Milan", 7, "Labrador Negro", "/Images/pets/perroMilan.jpg", "Macho", "Corneas inflamadas", "Los parpado del perro estan invertidos hacia sus ojos, causandole inflamacion en la cornea por sus pestañas, pero su vision no se ve afectada de forma significante"));
        petRepository1.save(new mascot("Lucia", 6, "Criollo", "/Images/pets/perroLucia.jpg", "Hembra", "Ansiedad", ""));
        petRepository1.save(new mascot("Suco", 8, "Gran Danes", "/Images/pets/perroSuco.jpg", "Macho", "Artritis", "Presenta dolor en la pata trazera izquierda"));
        petRepository1.save(new mascot("Napoleon", 0, "Chihuahua", "/Images/pets/perroNapo.jpg", "Macho", "Recien Nacido", ""));
        
        petRepository1.save(new mascot("Firulais", 5, "Labrador", "", "Macho", "Dolor de pierna", "Dolor de pierna"));
        petRepository1.save(new mascot("Mishi", 4, "Siames", "", "Hembra", "Parasitos", " "));
        petRepository1.save(new mascot("Piolin", 9, "Canario", "" , "Macho", "Ansiedad", " "));
        petRepository1.save(new mascot("Nemo", 7, "Pez Payaso", "", "Macho", "Poco apetito", " "));
        petRepository1.save(new mascot("Daisy", 4, "Gato", "", "Hembra", "Enfermedad Renal", ""));
        petRepository1.save(new mascot("Charlie", 1, "Perro", "", "Macho", "Psitacosis", ""));
        petRepository1.save(new mascot("Oscar", 6, "Perro", "", "Macho", "Displasia de Cadera", ""));
        petRepository1.save(new mascot("Lucy", 8, "Gato", "", "Hembra", "Hipertiroidismo", ""));
        petRepository1.save(new mascot("Bailey", 5, "Perro", "", "Hembra", "Enfermedad Cardíaca", ""));
        petRepository1.save(new mascot("Simba", 2, "Gato", "", "Macho", "Leucemia Felina", ""));
        petRepository1.save(new mascot("Sadie", 4, "Perro", "", "Hembra", "Alergias", ""));
        petRepository1.save(new mascot("Oliver", 3, "Gato", "", "Macho", "Asma", ""));
        petRepository1.save(new mascot("Coco", 7, "Perro", "", "Hembra", "Enfermedad del Pico y Plumas", ""));
        petRepository1.save(new mascot("Buddy", 6, "Perro", "", "Macho", "Epilepsia", ""));
        petRepository1.save(new mascot("Lily", 4, "Gato", "", "Hembra", "Ácaros del Oído", ""));
        petRepository1.save(new mascot("Rocky", 5, "Perro", "", "Macho", "Enfermedad de Cushing", ""));
        petRepository1.save(new mascot("Molly", 3, "Gato", "", "Hembra", "Pancreatitis", ""));
        petRepository1.save(new mascot("Toby", 2, "Perro", "", "Macho", "Parvovirus", ""));
        petRepository1.save(new mascot("Chloe", 6, "Gato", "", "Hembra", "Artritis", ""));
        petRepository1.save(new mascot("Buster", 7, "Perro", "", "Macho", "Enfermedad Hepática", ""));
        petRepository1.save(new mascot("Zoe", 1, "Perro", "", "Hembra", "Retención de Huevos", ""));
        petRepository1.save(new mascot("Jack", 4, "Perro", "", "Macho", "Enfermedad de Lyme", ""));
        petRepository1.save(new mascot("Bella", 3, "Gato", "", "Hembra", "Infección del Tracto Urinario", ""));
        petRepository1.save(new mascot("Duke", 5, "Perro", "", "Macho", "Enfermedad Dental", ""));
        petRepository1.save(new mascot("Misty", 2, "Gato", "", "Hembra", "Conjuntivitis", ""));
        petRepository1.save(new mascot("Rex", 6, "Perro", "", "Macho", "Artritis", ""));
        petRepository1.save(new mascot("Nala", 4, "Gato", "", "Hembra", "Virus de Inmunodeficiencia Felina", ""));
        petRepository1.save(new mascot("Harley", 3, "Perro", "", "Macho", "Obesidad", ""));
        petRepository1.save(new mascot("Mittens", 7, "Gato", "", "Hembra", "Diabetes", ""));
        petRepository1.save(new mascot("Zeus", 5, "Perro", "", "Macho", "Alergias", ""));
        petRepository1.save(new mascot("Luna", 2, "Gato", "", "Hembra", "Tiña", ""));
        petRepository1.save(new mascot("Sam", 6, "Perro", "", "Macho", "Hipotiroidismo", ""));
        petRepository1.save(new mascot("Ruby", 3, "Gato", "", "Hembra", "Infección Respiratoria Superior", ""));
        petRepository1.save(new mascot("Shadow", 4, "Perro", "", "Macho", "Pancreatitis", ""));
        petRepository1.save(new mascot("Ginger", 7, "Gato", "", "Hembra", "Hipertensión", ""));
        petRepository1.save(new mascot("Leo", 5, "Perro", "", "Macho", "Artritis", ""));
        petRepository1.save(new mascot("Sophie", 2, "Gato", "", "Hembra", "Estomatitis", ""));
        petRepository1.save(new mascot("Rocco", 6, "Perro", "", "Macho", "Enfermedad Renal", ""));
        petRepository1.save(new mascot("Lily", 4, "Gato", "", "Hembra", "Hipertiroidismo", ""));
        petRepository1.save(new mascot("Rusty", 7, "Perro", "", "Macho", "Glaucoma", ""));
        petRepository1.save(new mascot("Willow", 3, "Gato", "", "Hembra", "Asma", ""));
        petRepository1.save(new mascot("Gizmo", 5, "Perro", "", "Macho", "Enfermedad de Cushing", ""));
        petRepository1.save(new mascot("Penny", 2, "Gato", "", "Hembra", "Leucemia Felina", ""));
        petRepository1.save(new mascot("Diesel", 6, "Perro", "", "Macho", "Artritis", ""));
        petRepository1.save(new mascot("Sasha", 4, "Gato", "", "Hembra", "Enfermedad Renal", ""));
        petRepository1.save(new mascot("Hunter", 7, "Perro", "", "Macho", "Diabetes", ""));
        petRepository1.save(new mascot("Whiskers", 5, "Gato", "", "Hembra", "Pancreatitis", ""));
        petRepository1.save(new mascot("Bruno", 6, "Perro", "", "Macho", "Enfermedad Cardíaca", ""));
        petRepository1.save(new mascot("Lulu", 3, "Gato", "", "Hembra", "Infección Respiratoria", ""));
        petRepository1.save(new mascot("Thor", 4, "Perro", "", "Macho", "Epilepsia", ""));
        petRepository1.save(new mascot("Mia", 2, "Gato", "", "Hembra", "Conjuntivitis", ""));
        petRepository1.save(new mascot("Jake", 7, "Perro", "", "Macho", "Displasia de Cadera", ""));
        petRepository1.save(new mascot("Poppy", 5, "Gato", "", "Hembra", "Hipertiroidismo", ""));
        petRepository1.save(new mascot("Duke", 3, "Perro", "", "Macho", "Pancreatitis", ""));
        petRepository1.save(new mascot("Molly", 4, "Gato", "", "Hembra", "Infección del Tracto Urinario", ""));
        petRepository1.save(new mascot("Blue", 6, "Perro", "", "Macho", "Enfermedad de Lyme", ""));
        petRepository1.save(new mascot("Gracie", 5, "Gato", "", "Hembra", "Alergias", ""));
        petRepository1.save(new mascot("Bandit", 7, "Perro", "", "Macho", "Enfermedad Hepática", ""));
        petRepository1.save(new mascot("Cleo", 3, "Gato", "", "Hembra", "Asma", ""));
        petRepository1.save(new mascot("Murphy", 4, "Perro", "", "Macho", "Enfermedad Dental", ""));
        petRepository1.save(new mascot("Jasmine", 6, "Gato", "", "Hembra", "Pancreatitis", ""));
        petRepository1.save(new mascot("Bear", 5, "Perro", "", "Macho", "Hipotiroidismo", ""));
        petRepository1.save(new mascot("Lily", 2, "Gato", "", "Hembra", "Tiña", ""));
        petRepository1.save(new mascot("Ace", 7, "Perro", "", "Macho", "Enfermedad Renal", ""));
        petRepository1.save(new mascot("Daisy", 4, "Gato", "", "Hembra", "Hipertensión", ""));
        petRepository1.save(new mascot("Rocky", 6, "Perro", "", "Macho", "Glaucoma", ""));
        petRepository1.save(new mascot("Nina", 3, "Gato", "", "Hembra", "Estomatitis", ""));
        petRepository1.save(new mascot("Ziggy", 5, "Perro", "", "Macho", "Enfermedad de Cushing", ""));
        petRepository1.save(new mascot("Tinker", 2, "Gato", "", "Hembra", "Virus de Inmunodeficiencia Felina", ""));
        petRepository1.save(new mascot("Toby", 7, "Perro", "", "Macho", "Artritis", ""));
        petRepository1.save(new mascot("Misty", 4, "Gato", "", "Hembra", "Infección Respiratoria Superior", ""));
        petRepository1.save(new mascot("Max", 6, "Perro", "", "Macho", "Enfermedad Cardíaca", ""));
        petRepository1.save(new mascot("Kitty", 3, "Gato", "", "Hembra", "Hipertiroidismo", ""));
        petRepository1.save(new mascot("Buddy", 5, "Perro", "", "Macho", "Epilepsia", ""));
        petRepository1.save(new mascot("Lola", 2, "Gato", "", "Hembra", "Enfermedad Renal", ""));
        petRepository1.save(new mascot("Rufus", 7, "Perro", "", "Macho", "Diabetes", ""));
        petRepository1.save(new mascot("Suki", 4, "Gato", "", "Hembra", "Asma", ""));
        petRepository1.save(new mascot("Benny", 6, "Perro", "", "Macho", "Pancreatitis", ""));
        petRepository1.save(new mascot("Princess", 5, "Gato", "", "Hembra", "Conjuntivitis", ""));
        petRepository1.save(new mascot("Rusty", 4, "Perro", "", "Macho", "Infección Bacteriana", ""));
        petRepository1.save(new mascot("Maggie", 3, "Gato", "", "Hembra", "Fiebre", ""));
        petRepository1.save(new mascot("Riley", 6, "Perro", "", "Macho", "Enfermedad Respiratoria", ""));
        petRepository1.save(new mascot("Nico", 2, "Gato", "", "Macho", "Hígado Agrandado", ""));
        petRepository1.save(new mascot("Ellie", 5, "Perro", "", "Hembra", "Colitis", ""));
        petRepository1.save(new mascot("Pepper", 4, "Gato", "", "Macho", "Hipoglucemia", ""));
        petRepository1.save(new mascot("Oscar", 7, "Perro", "", "Macho", "Síndrome de Cushing", ""));
        petRepository1.save(new mascot("Luna", 1, "Gato", "", "Hembra", "Gastroenteritis", ""));
        petRepository1.save(new mascot("Jax", 3, "Perro", "", "Macho", "Infección Ocular", ""));
        petRepository1.save(new mascot("Mimi",6, "Gato", "", "Hembra", "Anemia", ""));
        petRepository1.save(new mascot("Mimi", 6, "Gato", "", "Hembra", "Anemia", ""));
        petRepository1.save(new mascot("Teddy", 5, "Perro", "", "Macho", "Problemas Renales", ""));
        petRepository1.save(new mascot("Ginger", 2, "Gato", "", "Hembra", "Dermatitis", ""));

        //Datos quemados de veterinarios
        veterinarioRepository.save(new Veterinario(1234, "Admin", 111, "Cardilogia", "abc", "", 0, "qwe@m.c"));
        veterinarioRepository.save(new Veterinario(0301, "Juan Pérez", 1234, "Cirugia", "vetpass1", " ", 0, "juan.perez@vetclinic.com"));
        veterinarioRepository.save(new Veterinario(1103, "Carlos Ramírez", 3456, "Cardilogia", "vetpass3", " ", 0, "carlos.ramirez@vetclinic.com"));
        veterinarioRepository.save(new Veterinario(4004, "Ana González", 4567, "Nutricion", "vetpass4", " ", 0, "ana.gonzalez@vetclinic.com"));
        veterinarioRepository.save(new Veterinario(0065, "Luis Fernández", 5678, "Dentista", "vetpass5", " ", 0, "luis.fernandez@vetclinic.com"));
        veterinarioRepository.save(new Veterinario(0406, "Laura Martínez", 6789, "Oftamologia", "vetpass6", " ", 0, "laura.martinez@vetclinic.com"));
        veterinarioRepository.save(new Veterinario(3007, "José Sánchez", 7890, "Cirugia", "vetpass7", " ", 0, "jose.sanchez@vetclinic.com"));
        veterinarioRepository.save(new Veterinario(5010, "Marta Ruiz", 0123, "Nutricion", "vetpass10", " ", 0, "marta.ruiz@vetclinic.com"));
        veterinarioRepository.save(new Veterinario(6011, "Fernando Morales", 1235, "Dentista", "vetpass11", " ", 0, "fernando.morales@vetclinic.com"));
        veterinarioRepository.save(new Veterinario(0412, "Patricia Soto", 2346, "Oftamologia", "vetpass12", " ", 0, "patricia.soto@vetclinic.com"));
        veterinarioRepository.save(new Veterinario(2213, "Andrés Gil", 3457, "Cirugia", "vetpass13", " ", 0, "andres.gil@vetclinic.com"));
        veterinarioRepository.save(new Veterinario(1114, "Cristina Núñez", 4568, "Dermatologia", "vetpass14", " ", 0, "cristina.nunez@vetclinic.com"));
        veterinarioRepository.save(new Veterinario(0315, "Miguel Herrera", 5679, "Cardilogia", "vetpass15", " ", 0, "miguel.herrera@vetclinic.com"));
        veterinarioRepository.save(new Veterinario(4416, "Sofía Flores", 6780, "Nutricion", "vetpass16", " ", 0, "sofia.flores@vetclinic.com"));
        veterinarioRepository.save(new Veterinario(0717, "Víctor Delgado", 7891, "Dentista", "vetpass17", " ", 0, "victor.delgado@vetclinic.com"));
        veterinarioRepository.save(new Veterinario(8820, "Claudia Ríos", 0124, "Dermatologia", "vetpass20", " ", 0, "claudia.rios@vetclinic.com"));
        veterinarioRepository.save(new Veterinario(3021, "Daniel Ortega", 1236, "Cirugia", "vetpass21", " ", 0, "daniel.ortega@vetclinic.com"));
        veterinarioRepository.save(new Veterinario(0422, "Lucía Vargas", 2347, "Dermatologia", "vetpass22", " ", 0, "lucia.vargas@vetclinic.com"));
        veterinarioRepository.save(new Veterinario(6023, "Roberto Salinas", 3458, "Cardilogia", "vetpass23", " ", 0, "roberto.salinas@vetclinic.com"));
        veterinarioRepository.save(new Veterinario(7024, "Verónica Paredes", 4569, "Nutricion", "vetpass24", " ", 0, "veronica.paredes@vetclinic.com"));

        //Datos de drogas
        csvService.uploadCsv("src/main/resources/MEDICAMENTOS_VETERINARIA.csv");

        //datos de tratamiento

        // Asociar mascotas a dueños ciclicamente
        List<mascot> mascotas = petRepository1.findAll();
        List<Cliente> clientes = clienteRepository1.findAll();

        clientes.removeIf(cliente -> cliente.getCedula() == 1005);

        Cliente P = clienteRepository1.findByCedula(1005);
        for (int j = 0; j < 10; j++){
            mascotas.get(j).setDueño(P);
        }

        for (int i = 10; i < mascotas.size(); i++) {
            mascotas.get(i).setDueño(clientes.get(i % clientes.size()));
            petRepository1.save(mascotas.get(i));
        }
    }
}