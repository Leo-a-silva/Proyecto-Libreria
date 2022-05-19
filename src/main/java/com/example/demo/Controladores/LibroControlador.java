package com.example.demo.Controladores;

import com.example.demo.Entidades.Autor;
import com.example.demo.Entidades.Editorial;
import com.example.demo.Repositorios.AutorRepositorio;
import com.example.demo.Repositorios.LibroRepositorio;
import com.example.demo.Servicios.AutorServicio;
import com.example.demo.Servicios.EditorialServicio;
import com.example.demo.Servicios.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Libro")
public class LibroControlador {
    
    @Autowired
    LibroServicio libroServicio;
    
    @Autowired
    LibroRepositorio libroRepositorio;
    
    @Autowired
    AutorServicio autorServicio;
    
    @Autowired
    AutorRepositorio AutorRepositorio;
    
    @Autowired
    EditorialServicio editorialServicio;
    
    @GetMapping("/registrar_libro")
    public String formulario(ModelMap modelo) {
        return "PagLibro";
    }
    
    @PostMapping("/registrar_libro")
    public String registro(ModelMap modelo, @RequestParam long isbn)throws Exception{
//            @RequestParam String titulo, @RequestParam Integer anio, @RequestParam Autor autor, @RequestParam Editorial editorial,
//            @RequestParam Integer ejemplares,
//            @RequestParam Integer ejemplaresPrestados, @RequestParam Integer ejemplaresRestantes) throws Exception {
        try { 
            libroServicio.CrearLibro(isbn);
            modelo.put("exito", "Registro exitoso");
        } catch (Exception e) {
            modelo.put("error", "Falló el registro");
        }
        return "PagLibro";
    }
    
}
