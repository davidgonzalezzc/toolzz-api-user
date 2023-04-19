package puj.api.userapi.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Clase para modelar la entidad Usuario
 * @Data Constructor, Getter y Setter de Lombok
 */
@Data
@Entity
@Table(name="user")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String email;
    private String password;
    private String role;
    private String name;
    private String last;
    

    
}
