package puj.web.clinicahaven.servicio;

import java.util.Collection;


import puj.web.clinicahaven.entity.Cliente;





public interface ClienteService {
    
    public Cliente findByCedula(int cedula);

    public Cliente findByEmail(String correo);


    public Collection<Cliente> findAll();

    public void deleteByCedula(int cedula);
    
    public void update(Cliente cliente);

    public void add(Cliente cliente);
    



}
