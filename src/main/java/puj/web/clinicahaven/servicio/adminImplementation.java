package puj.web.clinicahaven.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import puj.web.clinicahaven.entity.Admin;
import puj.web.clinicahaven.repositorio.adminRepository;

@Service
public class adminImplementation implements adminService{

    @Autowired
    adminRepository repoAdmin;

    @Override
    public Admin findByCorreo(String correo) {
        
        return repoAdmin.findByCorreo(correo);
    }

    @Override
    public Admin findByContrasena(String pass) {
        // TODO Auto-generated method stub
        return repoAdmin.findByContrasena(pass);
    }
    
}
