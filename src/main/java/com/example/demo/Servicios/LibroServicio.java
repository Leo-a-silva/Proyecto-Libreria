package com.example.demo.Servicios;

import com.example.demo.Entidades.Autor;
import com.example.demo.Entidades.Editorial;
import com.example.demo.Entidades.Libro;
import com.example.demo.Repositorios.LibroRepositorio;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

@Service
public class LibroServicio {

    @Autowired
    private LibroRepositorio LibroRepositorio;

    @Transactional
    public void CrearLibro(long isbn) throws Exception {
//        if (titulo == null || titulo.isEmpty()) {
//            throw new Exception("Este campo no puede quedar vacio");
//        }
//        if (anio == null) {
//            throw new Exception("Este campo no puede quedar vacio");
//        }
//        if (autor == null || autor.isEmpty()) {
//            throw new Exception("Este campo no puede quedar vacio");
//        }
//        if (ejemplares == null) {
//            throw new Exception("Este campo no puede quedar vacio");
//        }
////                  if(editorial == null || editorial.isEmpty()){
////            throw new Exception("Este campo no puede quedar vacio");
//        }
        Libro libro = new Libro();
//        libro.setIsbn(0);
        libro.setIsbn(isbn);
//        libro.setAnio(anio);
//        libro.setAutor(autor);
//        libro.setEditorial(editorial);
//        libro.setEjemplares(ejemplares);

        LibroRepositorio.save(libro);

    }

    @Transactional
    public void modificarLibro(String Id, Integer isbn, String titulo, Integer anio, Autor autor, Editorial editorial, Integer ejemplares) throws Exception {
        Optional<Libro> respuesta = LibroRepositorio.findById(Id);
        if (respuesta.isPresent()) {
            Libro libro = respuesta.get();
            libro.setIsbn(isbn);
            libro.setTitulo(titulo);
            libro.setAnio(anio);
            libro.setAutor(autor);
            libro.setEjemplares(ejemplares);
            //libro.setEditorial(editoral);
            LibroRepositorio.save(libro);
        } else {
            throw new Exception("No existe un libro con ese ID");
        }

    }
@Transactional
    public void buscarLibroPorId(String id) throws Exception {
        Optional<Libro> respuesta = LibroRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Libro libro = respuesta.get();
            System.out.println(libro);
        } else {
            throw new Exception("No se encuentra el libro");
        }

    }
@Transactional
    public void buscarLibroPorTitulo(String titulo) throws Exception {
//        Optional<Libro> respuesta = LibroRepositorio.findById(titulo);
//        if (respuesta.isPresent()) {
//            Libro libro = respuesta.get();
//            System.out.println(libro);
//        } else {
//            throw new Exception("No se encuentra ese titulo");
//        }
    }

    @Transactional
    public List<Libro> mostrarTodos() {
        return LibroRepositorio.findAll();
    }

    @Transactional
    public void borrarPorId(String id) throws Exception {
        Optional<Libro> respuesta = LibroRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Libro libro = respuesta.get();
            LibroRepositorio.delete(libro);
        } else {
            throw new Exception("No se encuentra ese titulo");
        }
    }
@Transactional
    public void darDeBaja(String id) throws Exception {
        Optional<Libro> respuesta = LibroRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Libro libro = respuesta.get();
            libro.setAlta(false);
        } else {
            throw new Exception("No se encuentra en nuestra base de dato");
        }

    }
@Transactional
    public void darDeAlta(String id) throws Exception {
        Optional<Libro> respuesta = LibroRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Libro libro = respuesta.get();
            libro.setAlta(true);
        } else {
            throw new Exception("No se encuentra en nuestra base de dato");
        }
    }
}
