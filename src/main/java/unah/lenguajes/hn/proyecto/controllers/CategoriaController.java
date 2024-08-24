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
import unah.lenguajes.hn.proyecto.models.Categoria;
import unah.lenguajes.hn.proyecto.services.CategoriaService;



@RestController
@RequestMapping("/api/categoria")
@Tag(name = "Comercio", description = "CRUD que pude ser modificado por un Administrador de COURSERA")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/crear")
    @Operation(summary = "Crear", description = "Funcion Encargada de crear comercios")
    public String crearCategoria(@RequestBody Categoria categoria) {
        return this.categoriaService.crearCategoria(categoria);
    }
    
    @GetMapping("/todos")
    @Operation(summary = "Obtener", description = "Funcion Encargada de obtener todas las CATEGORIAS registrados en la base de datos")
    public List<Categoria> obtenerTodos() {
        return this.categoriaService.obtenerTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar", description = "Funcion Encargada de buscar un comercio en específico por medio de su id")
    public Categoria obtenerComercio(@PathVariable String id) {
        return this.categoriaService.obtenerCategoria(id);
    }
    
    @PutMapping("/editar/{id}")
    @Operation(summary = "Editar", description = "Funcion Encargada de editar un Comercio en específico, recibe un id(PrimaryKey) para buscar el Comercio y un objeto nvoComercio que contiene los nuevos cambios para ese Comercio")
    public String editar(@PathVariable String id, @RequestBody Categoria nvoCategoria) {        
        return this.categoriaService.editarCategoria(id,nvoCategoria);
    }

    
    @DeleteMapping("/eliminar/{id}")
    @Operation(summary = "Eliminar", description = "Funcion Encargada de eliminar un comercio en específico por medio de su id")
    public String eliminar(@PathVariable String id){
        return this.categoriaService.eliminar(id);
    }
}
