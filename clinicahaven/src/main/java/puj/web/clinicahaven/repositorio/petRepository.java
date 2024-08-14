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
        lista.put(1, new mascot("Moira", 10, "Labrador Negro"));
        lista.put(2, new mascot("Trufa", 8, "Labrador Chocolate"));
        lista.put(3, new mascot("Bill", 4, "Criollo"));
    }

    public  Collection<mascot> findAll(){
        return lista.values();
    }
}
