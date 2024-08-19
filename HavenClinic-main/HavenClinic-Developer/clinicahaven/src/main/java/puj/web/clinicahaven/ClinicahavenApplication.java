package puj.web.clinicahaven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration //activar autoconfiguracion: lee todas las dependencias y las relaciones al proyecto de sprignboot
@ComponentScan  //escanea todos los servlets ylos paquetes y las clases y los instancia
@SpringBootApplication
public class ClinicahavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicahavenApplication.class, args);
	}

}
