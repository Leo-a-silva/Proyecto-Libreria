package com.example.demo.Servicios;

import com.example.demo.Entidades.Editorial;
import com.example.demo.Repositorios.EditorialRepositorio;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditorialServicio {

    @Autowired
    EditorialRepositorio EditorialRepositorio;
    
        @Transactional
    public void crearEditorial(String nombre) {
        Editorial editorial = new Editorial();
       editorial.setNombre(nombre);
       editorial.setAlta(true);

       EditorialRepositorio.save(editorial);

    }

    @Transactional
    public void buscarPorNombre(String nombre) throws Exception {
        Optional<Editorial> respuesta = EditorialRepositorio.findById(nombre);
        if (respuesta.isPresent()) {
            Editorial libro = respuesta.get();
            System.out.println(libro);
        } else {
            throw new Exception("No se encuentra ese titulo");
        }
    }

    @Transactional
    public List<Editorial> mostrarTodos(){
       List<Editorial> mostrarTodos= EditorialRepositorio.findAll();
       return mostrarTodos;

    }
    
    @Transactional
        public void darDeBaja(String id) throws Exception {
        Optional<Editorial> respuesta = EditorialRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Editorial editorial = respuesta.get();
            editorial.setAlta(false);
        } else {
            throw new Exception("No se encuentra en nuestra base de dato");
        }

    }
@Transactional
    public void darDeAlta(String id) throws Exception {
        Optional<Editorial> respuesta = EditorialRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Editorial editorial = respuesta.get();
            editorial.setAlta(true);
        } else {
            throw new Exception("No se encuentra en nuestra base de dato");
        }
    }
}
