package puj.web.clinicahaven.servicio;

import java.util.Collection;

import org.springframework.stereotype.Service;

import puj.web.clinicahaven.entity.mascot;

@Service
public interface petService {

    public Collection<mascot> findAll();
    
}
