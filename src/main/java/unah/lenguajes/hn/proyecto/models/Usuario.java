package unah.lenguajes.hn.proyecto.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Usuarios")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USUARIOID")
    private long id;

    @Column(name="NOMBRE")
    private String nombre ;

    @Column(name="APELLIDO")
    private String Apellido ;

    @Column(name="EMAIL")
    private String email;
    
    @Column(name="Contrasenia")
    private String contrasenia;
}
