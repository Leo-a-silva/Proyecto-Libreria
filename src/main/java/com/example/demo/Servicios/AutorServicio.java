package com.example.demo.Servicios;

import com.example.demo.Entidades.Autor;
import com.example.demo.Repositorios.AutorRepositorio;
import java.util.List;
import java.util.Optional;
import javax.persistence.Id;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorServicio {

    @Autowired
    private AutorRepositorio AutorRepositorio;

    @Transactional
    public void crearAutor(String nombre) {
        Autor autor = new Autor();
        autor.setNombre(nombre);

        AutorRepositorio.save(autor);

    }
    
    @Transactional
    public List<Autor> mostrarAutores(){
       List<Autor> mostrarAutores= AutorRepositorio.findAll();
       return mostrarAutores;
    }
    
@Transactional
    public void modificarAutor(String id, String nombre, boolean alta) throws Exception {
        Optional<Autor> respuesta = AutorRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Autor autor = respuesta.get();
            autor.setNombre(nombre);
            autor.setAlta(alta);

        } else {
            throw new Exception("No existe un libro con ese ID");
        }
    }
@Transactional
    public void buscarAutorPorNombre(String nombre) throws Exception {
        Optional<Autor> respuesta = AutorRepositorio.findById(nombre);
        if (respuesta.isPresent()) {
            Autor autor = respuesta.get();
            System.out.println(nombre);
        } else {
            throw new Exception("No se encuentra ese titulo");
        }
    }
    
    @Transactional
    public void darDeAlta(String id) throws Exception {
        Optional<Autor> respuesta = AutorRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Autor autor = respuesta.get();
            autor.setAlta(true);
        } else {
            throw new Exception("No se encuentra en nuestra base de dato");
        }
    }

}
