package unah.lenguajes.hn.proyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import unah.lenguajes.hn.proyecto.models.Persona;
import unah.lenguajes.hn.proyecto.services.PersonaService;




@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "USUARIOS", description = "CRUD para Administradores y Clientes")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/crear")
        @Operation(summary = "Crear", description = "Funcion Encargada de crear Personas")
    public String crearUsuario(@RequestBody Usuario nvoUsuario) {
        return this.usuarioService.crear(nvoUsuario);
    }

    @GetMapping("/todos")
    @Operation(summary = "Obtener", description = "Funcion Encargada de obtener todos los Usuarios registradas en la base de datos.")
    public List<Usuario> obtenerTodos() {
        return this.usuarioService.obtenerTodos();
    }

    @GetMapping("/{dni}")
    @Operation(summary = "Obtener", description = "Funcion Encargada de obtener un Usuario en específico, dandole busqueda mediante su dni(PrimaryKey).")
    public Usuario obtenerUsuario(@PathVariable Long id) {
        return this.usuarioService.obtenerUsuario(id);
    }
    
    @PutMapping("/editar/{id}")
    @Operation(summary = "Editar", description = "Funcion Encargada de editar un Usuario en específico, recibe un dni(PrimaryKey) para buscar la persona y un objeto nvaPersona que contiene los nuevos cambios para esta Persona")
    public Usuario editar(@PathVariable Long id, @RequestBody Usuario nvoUsuario) {
        return this.usuarioService.editarUsuario(id,nvoUsuario);
    }

    @DeleteMapping("/eliminar/{dni}")
    @Operation(summary = "Eliminar", description = "Funcion Encargada de eliminar una Usuarios en específico por medio de su dni(PrimaryKey)")
    public String eliminar(@PathVariable Long id){
        return this.usuarioService.eliminar(id);
    }
}
