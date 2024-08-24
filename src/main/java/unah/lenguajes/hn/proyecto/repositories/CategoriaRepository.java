package unah.lenguajes.hn.proyecto.repositories;

import java.util.Optional;

import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import unah.lenguajes.hn.proyecto.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, String> {
    @Query("SELECT l FROM Local l WHERE l.id=id")
    Optional<Local> findLocalByIdWithJPAQL(String id);

}
