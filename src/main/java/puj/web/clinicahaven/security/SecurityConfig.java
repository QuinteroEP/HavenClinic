
package puj.web.clinicahaven.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


//En esta clase voy a configurar todo lo relacionado a seguridad(Filter Chain(tercer patron de diseño))
@Configuration //decir que en esta clase se van a crear beans
@EnableWebSecurity  
public class SecurityConfig {
    @Autowired
    private JwtAuthEntryPoint jwtAuthEntryPoint;

    @Bean //decir que este metodo va a crear un bean que se va a manejar  de manejador de objetos 
     SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable)
            .headers(headers -> headers.frameOptions(frame -> frame.disable()))
            .authorizeHttpRequests(exchanges ->   //configurar lo que quiero que sea publico o no 
                exchanges
                    .requestMatchers("/h2/**" ).permitAll() //min 36
                    //.requestMatchers("/mascotas/**" ).authenticated() 
                    //.requestMatchers("/cliente/**" ).authenticated() 
                    .anyRequest().permitAll()
            )
            .exceptionHandling(exception -> exception.authenticationEntryPoint(jwtAuthEntryPoint));
            return http.build();
     }

     @Bean
     PasswordEncoder passwordEncoder(){
         return new BCryptPasswordEncoder();
     }

     @Bean  
     public AuthenticationManager authenticationManager(
        AuthenticationConfiguration authenticationConfiguration
     ) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
     }
}