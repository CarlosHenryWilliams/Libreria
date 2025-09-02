package com.cursomicroservicios.libro.repository;

import com.cursomicroservicios.libro.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILibroRepository extends JpaRepository<Libro, Long> {
    public Libro findLibroByisbn(String isbn);
}
