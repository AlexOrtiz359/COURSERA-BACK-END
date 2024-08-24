package unah.lenguajes.hn.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import unah.lenguajes.hn.proyecto.models.Categoria;
import unah.lenguajes.hn.proyecto.models.Curso;
import unah.lenguajes.hn.proyecto.repositories.CategoriaRepository;
import unah.lenguajes.hn.proyecto.repositories.CursoRepository;

public class CursoService {
        @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public String crear(Curso nvoCurso){
        if (!this.cursoRepository.existsById(nvoCurso.getCursoID())) { 
            this.cursoRepository.save(nvoCurso);
                return "{\"status\":true,\"message\":\"Curso creado correctamente.\",\"alert\":\"success\"}";
            
        }  return "{\"status\":false,\"message\":\"Codigo de producto existente.\",\"alert\":\"danger\"}";
            
    }
    

    public Curso obtenerCurso(Long id){
        return this.cursoRepository.findById(id).get();
    }

    public List<Curso> obtenerTodos(){
        return this.cursoRepository.findAll();
    }

    public Curso asociarCursoACategoria(String id, Curso nvoCurso){
        Categoria categoriaAsociar = this.categoriaRepository.findById(id).get();
        categoriaAsociar.getCursos().add(nvoCurso);
        this.categoriaRepository.save(categoriaAsociar);
        Curso cursoAgregar = nvoCurso;
        cursoAgregar.setCategoria(categoriaAsociar);
        return this.cursoRepository.save(cursoAgregar);
    }

    public String editarCurso(Long id, Curso nvCurso){
        if (this.cursoRepository.existsById(id)) {
            Curso curso = this.cursoRepository.findById(id).get();
            curso.setTitulo(nvCurso.getTitulo());
            curso.setDescripcion(nvCurso.getDescripcion());
            curso.setPrecio(nvCurso.getPrecio());
            curso.setCategoria(nvCurso.getCategoria());
            this.cursoRepository.save(curso);
            return "{\"status\":true,\"message\":\"Producto editato correctamente.\",\"alert\":\"success\"}";
        
        }  return "{\"status\":false,\"message\":\"No existe Producto.\",\"alert\":\"danger\"}";
            

    }
}
