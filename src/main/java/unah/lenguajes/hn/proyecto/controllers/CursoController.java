package unah.lenguajes.hn.proyecto.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import unah.lenguajes.hn.proyecto.models.Curso;
import unah.lenguajes.hn.proyecto.services.CategoriaService;
import unah.lenguajes.hn.proyecto.services.CursoService;


@RestController
@RequestMapping("/api/curso")
@Tag(name = "Cursos", description = "CRUD para Administradores")
public class CursoController {
    
    @Autowired
    private CursoService cursoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/todos")
    @Operation(summary = "Obtener", description = "Funcion Encargada de obtener todos los Productos registradas en la base de datos.")
    List<Curso> obtenerTodos() {
        return this.cursoService.obtenerTodos();
    }
    
    @PostMapping("/crear")
    @Operation(summary = "Crear", description = "Funcion Encargada de crear Cusrsos")
    public String crear(@RequestBody Curso nvoCurso){
        return this.cursoService.crear(nvoCurso);
    }

    @GetMapping("/obtener/categoria/{id}")
    @Operation(summary = "Obtener", description = "Funcion Encargada de obtener todos los Cursos asociados a una categoria en específico, dandole busqueda mediante su id(PrimaryKey).")
    public List<Curso> obtenerCursoPorComercio(@PathVariable String id) {
        return this.categoriaService.obtenerCursosPorCategoria(id);
    }

    @GetMapping("/obtener/{id}")
    @Operation(summary = "Obtener", description = "Funcion Encargada de obtener un Curso en específico, dandole busqueda mediante su id(PrimaryKey).")
    public Curso obtenerProducto(@PathVariable Long id) {
        return this.cursoService.obtenerCurso(id);
    }

    @PostMapping("/asociar/{id}")
    @Operation(summary = "Asociar", description = "Funcion Encargada de asociar un Cursos a una Categoria en específico, dandole busqueda al comercio mediante su id(PrimaryKey) y pasandole el producto que se recibe como parámetro de la función.")
    public Curso asociarProductoAComercio(@PathVariable String id, @RequestBody Curso nvoCurso) {
        return this.cursoService.asociarCursoACategoria(id, nvoCurso);
    }

    @PutMapping("/editar/{id}")
    @Operation(summary = "Editar", description = "Funcion Encargada de editar un Curso en específico, recibe un id(PrimaryKey) para buscar el producto y un objeto nvoProducto que contiene los nuevos cambios para este producto")
    public String editarProducto (@PathVariable Long id,@RequestBody Curso nvCurso   ){

        return this.cursoService.editarCurso(id, nvCurso);

    } 
    
}
