package puj.web.clinicahaven.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class userEntity {
    @Id
    @GeneratedValue
    Long id;

    private String username;
    private String contraseña;

    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Role> roles = new ArrayList();

}
