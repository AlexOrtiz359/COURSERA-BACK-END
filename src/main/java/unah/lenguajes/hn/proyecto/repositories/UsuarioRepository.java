package unah.lenguajes.hn.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import unah.lenguajes.hn.proyecto.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Boolean existsByNombre(String nombre);
}
