package com.example.demo.Repositorios;

import com.example.demo.Entidades.Libro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, String> {

    @Query("SELECT c FROM Libro c WHERE c.titulo = :titulo")
    public List<Libro> buscarPorTitulo(@Param("titulo") String titulo);
}
