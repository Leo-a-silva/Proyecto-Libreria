package com.example.demo.Controladores;

import com.example.demo.Servicios.AutorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Autor")
public class AutorControlador {

    @Autowired
    AutorServicio autorServicio;

    @GetMapping("/registro")
    public String formulario(ModelMap vista) {
        vista.addAttribute("nombre", this);
        return "RegistrarAutor";
    }

    @PostMapping("/registro")
    public String registro(ModelMap modelo, @RequestParam String nombre) throws Exception {
        try {
            autorServicio.crearAutor(nombre);
            modelo.put("exito", "Registro exitoso");
        } catch (Exception e) {
            modelo.put("error", "Falló el registro");
        }
        return "RegistrarAutor";
    }
 @GetMapping("/mostrarAutores")   
 public String mostarAutores (ModelMap modelo){
     modelo.addAttribute("mostrarAutores", autorServicio.mostrarAutores());
     return "registrarAutor";
 }
   
}
