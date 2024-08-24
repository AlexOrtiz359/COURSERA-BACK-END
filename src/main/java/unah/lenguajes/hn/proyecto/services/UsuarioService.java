package unah.lenguajes.hn.proyecto.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.hn.proyecto.models.Usuario;
import unah.lenguajes.hn.proyecto.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public String crear(Usuario nvoUsuario){
        if (!this.usuarioRepository.existsById(nvoUsuario.getId())){ 
            this.usuarioRepository.save(nvoUsuario);
                return "{\"status\":true,\"message\":\"se creo correctamente.\",\"alert\":\"success\"}";
        }
        return "{\"status\":false,\"message\":\"Ya existe Usuario con ese ID.\",\"alert\":\"danger\"}";
    }


    public List<Usuario> obtenerTodos(){
        return this.usuarioRepository.findAll();
    }

    public Usuario editarUsuario(Long id, Usuario nvaPersona){
        if (this.usuarioRepository.existsById(id)){
            Usuario usuarioActual = this.usuarioRepository.findById(id).get();
            usuarioActual.setNombre(nvaPersona.getNombre());
            usuarioActual.setApellido(nvaPersona.getApellido());
            usuarioActual.setEmail(nvaPersona.getEmail());
            usuarioActual.setContrasenia(nvaPersona.getContrasenia());
            return this.usuarioRepository.save(usuarioActual);
        }
        return null;
    }

    public  String eliminar(Long id){
        if (this.usuarioRepository.existsById(id)){
            Usuario UsuarioEliminar = this.usuarioRepository.findById(id).get();
            this.usuarioRepository.delete(UsuarioEliminar);
            return "Registro eliminado correctamente";
        }
        return "No se pudo eliminar el registro";
    }

    public Usuario obtenerPersona (Long id){
        if (this.usuarioRepository.existsById(id)){
            return this.usuarioRepository.findById(id).get();
        }
        return null;
    }
}
