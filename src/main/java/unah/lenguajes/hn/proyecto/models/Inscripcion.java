package unah.lenguajes.hn.proyecto.models;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="INSCRIPCIONES")
@Data
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="INSCRIPCIONID")
    private long inscripcionID;

    @Column(name="FECHAINSCRPCION")
    private LocalDateTime fechaHora;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="ID_Cliente", referencedColumnName = "DNI")
    private Curso curso;

    @OneToMany(mappedBy = "USUARIOID")
    @JoinColumn(name="ID_Cliente", referencedColumnName = "DNI")
    private Usuario usuario;
}
