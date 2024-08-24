package unah.lenguajes.hn.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.hn.proyecto.models.Categoria;
import unah.lenguajes.hn.proyecto.models.Curso;
import unah.lenguajes.hn.proyecto.repositories.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public String crearCategoria(Categoria categoria){
        if (!this.categoriaRepository.existsById(categoria.getId())){

        }
        return "{\"status\":false,\"message\":\"Codigo de comercio Existente.\",\"alert\":\"danger\"}";
    }

    public List<Categoria> obtenerTodos(){
        return this.categoriaRepository.findAll();
    }

    public Categoria obtenerCategoria(String id){
        if (this.categoriaRepository.existsById(id)){
            return this.categoriaRepository.findById(id).get() ;
        }
        return null;
    }

    public String editarCategoria(String id, Categoria nvoCategoria){
        if (this.categoriaRepository.existsById(id)){
            Categoria categoriaActual = this.categoriaRepository.findById(id).get();
            categoriaActual.setNombre(nvoCategoria.getNombre());
            this.categoriaRepository.save(categoriaActual);       
            return "{\"status\":true,\"message\":\"Comercio editado correctamente.\",\"alert\":\"success\"}" ;
        }
        return "{\"status\":false,\"message\":\"No existe tal comercio.\",\"alert\":\"danger\"}";
    }

    public String eliminar(String id){
        if (this.categoriaRepository.existsById(id)){
            Categoria categoriaActual = this.categoriaRepository.findById(id).get();
            this.categoriaRepository.delete(categoriaActual);
            return "Comercio eliminado correctamente";
        }
        return "No se pudo eliminar el comercio";
    }

    public List<Curso> obtenerCursosPorCategoria(String id){
        if(this.categoriaRepository.findById(id).get().getCursos() != null){
        List<Curso> cursos = this.categoriaRepository.findById(id).get().getCursos();
        return cursos;
        }else{
            return null;
        }
    }
}
