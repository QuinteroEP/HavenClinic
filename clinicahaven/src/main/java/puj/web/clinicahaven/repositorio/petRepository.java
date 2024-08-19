package puj.web.clinicahaven.repositorio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import puj.web.clinicahaven.entity.mascot;

@Repository
public class petRepository {
    private Map<Integer, mascot> lista = new HashMap<>();

    public petRepository(){
        lista.put(1, new mascot("Moira", "10 años", "Labrador Negro", "/Images/pets/20240330_170037.jpg", 1));

        lista.put(2, new mascot("Trufa", "8 años", "Labrador Chocolate", "/Images/pets/20240327_143235.jpg", 2));

        lista.put(3, new mascot("Bill", "4 años", "Criollo", "/Images/pets/20231216_135756.jpg", 3));
    }

    public  Collection<mascot> findAll(){
        return lista.values();
    }

    public  mascot findPet(int key){
        return lista.get(key);
    }

    public void deletePet(int key){
        lista.remove(key);
    }
}
