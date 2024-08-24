package unah.lenguajes.hn.proyecto.models;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Productos")
@Data
public class Curso {
    @Id
    @Column(name="CURSOID")
    private Long cursoID;

    @Column(name="TITULO")
    private String titulo;
    
    @Column(name="Descripcion")
    private String descripcion;
    
    
    @Column(name="Precio")
    private double precio;
    

    @JsonIgnore
    @OneToMany
    @JoinColumn(name="ID_Comercio")
    private Categoria categoria;

}
