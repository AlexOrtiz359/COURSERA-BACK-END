package unah.lenguajes.hn.proyecto.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Comercios")
@Data
public class Categoria {
    @Id
    @Column(name="ID")
    private String id;
    
    @Column(name="nombre")
    private String nombre;

    @Column(name="imagen")
    private String imagen;

    @JsonIgnore
    @OneToMany(mappedBy = "comercio")
    private List<Curso> Cursos;

}
