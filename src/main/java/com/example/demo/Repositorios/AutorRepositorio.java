package com.example.demo.Repositorios;

import com.example.demo.Entidades.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, String> {

    @Query("SELECT e FROM Autor e WHERE e.nombre = :nombre ORDER BY e.nombre ASC")
    public Autor buscarPorNombre(@Param("nombre")String nombre);
}
