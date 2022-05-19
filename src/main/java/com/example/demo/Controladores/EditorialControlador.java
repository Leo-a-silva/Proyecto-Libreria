package com.example.demo.Controladores;

import com.example.demo.Repositorios.EditorialRepositorio;
import com.example.demo.Servicios.EditorialServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Editorial")
public class EditorialControlador {
    
    @Autowired
    EditorialServicio editorialServicio;
    
    @Autowired
    EditorialRepositorio editorialRepositorio;
    
    @GetMapping("/registro")
    public String formulario(ModelMap modelo) {
        modelo.addAttribute("nombre", this);
        return "PagEditorial";
    }
    
    @PostMapping("/registro")
    public String registro(ModelMap modelo, @RequestParam String nombre) throws Exception {
        try {
            editorialServicio.crearEditorial(nombre);
            System.out.println("Editorial" + nombre);
            modelo.put("exito", "Registro exitoso");
        } catch (Exception e) {
            modelo.put("error", "Falló el registro");
        }
        return "pagEditorial";
    }
    }