package puj.web.clinicahaven.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import puj.web.clinicahaven.entity.Cliente;
import puj.web.clinicahaven.entity.Role;
import puj.web.clinicahaven.entity.UserEntity;
import puj.web.clinicahaven.entity.Veterinario;
import puj.web.clinicahaven.repositorio.RoleRepository;
import puj.web.clinicahaven.repositorio.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired 
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        UserEntity userDB = userRepository.findByUsername(username).orElseThrow(
            () -> new UsernameNotFoundException("Este usuario no existe")
        );

        UserDetails userDetails = new User(userDB.getUsername(), userDB.getContrasena(), mapToGrantedAuthorities(userDB.getRoles()));

        return userDetails;
    }
    
    private Collection<GrantedAuthority> mapToGrantedAuthorities(List<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    public UserEntity ClienteToUser(Cliente cliente){
        UserEntity user = new UserEntity();
        user.setUsername(cliente.getCorreo());
        user.setContrasena(passwordEncoder.encode(cliente.getContrasena()));

        Role roles = roleRepository.findByName("CLIENTE").get();
        user.setRoles(List.of(roles));

        return user;
    }

    public UserEntity VetToUser(Veterinario Veterinario){
        UserEntity user = new UserEntity();
        user.setUsername(Veterinario.getCorreo());
        user.setContrasena(passwordEncoder.encode(Veterinario.getContrasena()));

        Role roles = roleRepository.findByName("VETERINARIO").get();
        user.setRoles(List.of(roles));

        return user;
    }
}
