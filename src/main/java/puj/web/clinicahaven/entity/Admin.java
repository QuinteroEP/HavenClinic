package puj.web.clinicahaven.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Admin {

    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity userEntity;

    
    @Id
    @GeneratedValue
    private long adminId;
    
    private String correo;
    private String contrasena;


    public Admin(String correo, String contrasena) {
        this.correo = correo;
        this.contrasena = contrasena;
    }
    
}
