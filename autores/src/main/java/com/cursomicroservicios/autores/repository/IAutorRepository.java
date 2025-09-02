package com.cursomicroservicios.autores.repository;

import com.cursomicroservicios.autores.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAutorRepository extends JpaRepository<Autor, Long> {

    // la consulta esta asi porque se enfoca en Objetos en vez de tablas como SQL
    // Autor - Clase    listaISBNLibros - atributos -- isbn lo que recibe por parametro.
    @Query("SELECT a FROM Autor a WHERE :isbn MEMBER OF a.listaISBNLibros")
    List<Autor> findAutoresIsbn(String isbn);
}
