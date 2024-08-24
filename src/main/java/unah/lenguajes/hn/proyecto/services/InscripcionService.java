package unah.lenguajes.hn.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.hn.proyecto.models.Inscripcion;
import unah.lenguajes.hn.proyecto.repositories.InscripcionRepository;
import unah.lenguajes.hn.proyecto.repositories.UsuarioRepository;

@Service
public class InscripcionService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private InscripcionRepository inscripcionRepository;

    public String crearInscripcion(Inscripcion nvaInscripcion){
        /*Usuario usuarioActual = nvaInscripcion.getUsuario();/* */
        if (!this.inscripcionRepository.existsById(nvaInscripcion.getInscripcionID())) { 
            this.inscripcionRepository.save(nvaInscripcion);
        } return "{\"status\":true,\"message\":\"Inscripcion Exitosa.\",\"alert\":\"success\"}";
        
    }

    public List<Inscripcion> obtenerInscripciones(){
        return this.inscripcionRepository.findAll();
    }
}
