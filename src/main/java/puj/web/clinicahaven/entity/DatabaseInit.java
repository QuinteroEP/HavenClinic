package puj.web.clinicahaven.entity;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;
import puj.web.clinicahaven.repositorio.clienteRepository;

@Controller
@Transactional
public class DatabaseInit implements ApplicationRunner {

    @Autowired
    clienteRepository clienteRepository1;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        clienteRepository1.save(new Cliente("Juan", 123, 1222, "a@c.m", "abc"));
        clienteRepository1.save(new Cliente("Pedro", 124, 1223, "b@c.m", "abc"));
        clienteRepository1.save(new Cliente("Maria", 125, 1224, "c@c.m", "abc"));
        clienteRepository1.save(new Cliente("Luis", 126, 1225, "d@c.m", "abc"));
        clienteRepository1.save(new Cliente("Ana", 127, 1226, "e@c.m", "abc"));
    }
}
