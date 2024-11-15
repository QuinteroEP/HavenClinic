package puj.web.clinicahaven.servicio;

import puj.web.clinicahaven.entity.Admin;

public interface adminService {
        
         Admin findByCorreo(String correo);
    
         Admin findByContrasena(String pass);
}
