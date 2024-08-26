package puj.web.clinicahaven.servicio;

import java.util.Collection;


import jakarta.transaction.Transactional;
import puj.web.clinicahaven.entity.Cliente;





public interface ClienteService {


    public Cliente findByCedula(int cedula);

    public Cliente findByEmail(String correo);


    public Collection<Cliente> findAll();

    @Transactional
    public void deleteByCedula(int cedula);
    @Transactional
    public void update(Cliente cliente);
    @Transactional
    public void add(Cliente cliente);
    



}
