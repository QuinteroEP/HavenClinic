package puj.web.clinicahaven.servicio;

import java.util.List;

import jakarta.transaction.Transactional;
import puj.web.clinicahaven.entity.Cliente;





public interface ClienteService {


    public Cliente findByid(Long id);

    public Cliente findByCedula(int cedula);

    public Cliente findByEmail(String correo);

    public Cliente findByContrasena(String pass);

    public Cliente findByclienteId(Long id);

    public List<Cliente>  findClienteByNombre(String nombre);

    public List<Cliente> findAll();

    @Transactional
    public void deleteByCedula(int cedula);
    @Transactional
    public void deleteById(Long id);
    @Transactional
    public void update(Cliente cliente);
    @Transactional
    public void add(Cliente cliente);
}
