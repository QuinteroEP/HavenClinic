package puj.web.clinicahaven.repositorio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import puj.web.clinicahaven.entity.Cliente;
import puj.web.clinicahaven.entity.mascot;

@Repository
public class petRepository {
    private Map<Integer, mascot> lista = new HashMap<>();

    public petRepository() {
        lista.put(1, new mascot("Moira", "10 años", "Labrador Negro", "/Images/pets/20240330_170037.jpg", 1, "displacia de cadera", "Animal de edad mayor; su condicion le causa dolor en la pata trazera derecha"));

        lista.put(2, new mascot("Trufa", "8 años", "Labrador Chocolate", "/Images/pets/20240327_143235.jpg", 2, "en recuperacion de cesarea", "El animal dio a luz a 4 cachorros labrador (3 chocolate, 1 negro - todos hembras) por medio de cesarea"));

        lista.put(3, new mascot("Bill", "4 años", "Criollo", "/Images/pets/20231216_135756.jpg", 3, "fractura en la pata izquierda trasera", "El animal callejero fue golpeado por un carro; presenta dificultad para caminar"));

        lista.put(4, new mascot("Joseph", "6 años", "Labrador Negro", " ", 4, "herida de mordida cerca del ojo derecho", "El animal fue mordido por uno de sus hermanos mientras jugaban. Presenta secrecion en el ojo e inflamacion en la zona del parpado"));
    }

    public Collection<mascot> findAll() {
        return lista.values();
    }

    public mascot findPet(int key) {
        return lista.get(key);
    }

    public void deletePet(int key) {
        lista.remove(key);
    }

    public void update(mascot mascota) {
        lista.put(mascota.getId(), mascota);
    }

    public void agregar(mascot mascota) {lista.put(mascota.getId(), mascota);}
}