package puj.web.clinicahaven.repositorio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import puj.web.clinicahaven.entity.Cliente;

import org.springframework.stereotype.Repository;

@Repository
public class clienteRepository {
    
    private Map<Integer,Cliente>clientes= new HashMap<>();

    public clienteRepository() {

        clientes.put(1, new Cliente("Jonatan", 12345678, 12345678, "j@j.com", "dfr3"));
        clientes.put(2, new Cliente("Pedro", 22345678, 12345678, "p@p.com", "123s45678"));
        clientes.put(3, new Cliente("Lucas", 32345678, 12345678, "l@l.com", "123f45678"));
        clientes.put(4, new Cliente("Carlos", 42345678, 12345678, "c@c.com", "12f345678"));
        clientes.put(5, new Cliente("Luis", 5345678, 12345678, "l@l.com", "1234f5678"));
        clientes.put(6, new Cliente("Daniel", 6345678, 12345678, "d@d.com", "12345e678"));

    }


    public Collection<Cliente> findAll() {
        return clientes.values();
    }
    public Cliente findByCedula(int cedula) {
        return clientes.get(cedula);
    }
    

    public void deleteByCedula(int cedula) {
        clientes.remove(cedula);
    }

    public void update(Cliente cliente) {
        clientes.put(cliente.getCedula(), cliente);
    }

    public void agregar(Cliente cliente) {
     
        clientes.put(cliente.getCedula(), cliente);
       
    



}
}