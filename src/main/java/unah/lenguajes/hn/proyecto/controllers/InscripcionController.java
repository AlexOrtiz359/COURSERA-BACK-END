package unah.lenguajes.hn.proyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import unah.lenguajes.hn.proyecto.models.Inscripcion;
import unah.lenguajes.hn.proyecto.services.InscripcionService;


@RestController
@RequestMapping("/api/inscripcion")
@Tag(name = "Inscripcion", description = "CRUD para Administradores y Clientes")
public class InscripcionController {
    
    @Autowired
    private InscripcionService inscripcionService;
    
    @PostMapping("/crear")
    @Operation(summary = "Crear", description = "Funcion Encargada de crear Inscripciones")
    public String crear(@RequestBody Inscripcion nvoInscripcion){
        return this.inscripcionService.crearInscripcion(nvoInscripcion);
    }

    @GetMapping("/todos")
    @Operation(summary = "Obtener", description = "Funcion Encargada de obtener todas las Inscripciones registrados en la base de datos")
    public List<Inscripcion> obtenerOrdenes() {
        return this.inscripcionService.obtenerInscripciones();
    }
    
}
