package unah.lenguajes.hn.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import unah.lenguajes.hn.proyecto.models.Curso;

public interface CursoRepository extends JpaRepository<Curso,Long>{
    
}
