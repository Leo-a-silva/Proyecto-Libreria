package com.example.demo.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ControladorPrincipal {

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("RegistrarAutor")
    public String RegistrarAutor() {
        return "RegistrarAutor.html";
    }

    @GetMapping("pagEditorial")
    public String PagEditorial() {
        return "PagEditorial.html";
    }

    @GetMapping("PagLibro")
    public String PagLibro() {
        return "PagLibro.html";
    }
}
