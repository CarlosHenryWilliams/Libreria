package com.cursomicroservicios.libro.service;

import com.cursomicroservicios.libro.dto.LibroDTO;
import com.cursomicroservicios.libro.model.Libro;

import java.util.List;

public interface ILibroService {
    // TODO: CRUD
    // 1 - Get libros
    public List<Libro> getLibros();
    // 2 - Get only one libro
    public Libro getLibroById(Long id);
    // 3 - Get libro by ISBN
    public Libro getLibroByisbn(String ISBN);
    // 4 - Edit libro
    public void editLibro(Long id, LibroDTO libroDTO);
    // 5 - Delete libro
    public void deleteLibro(Long id);
    // 6- Create Libro
    public void createLibro(LibroDTO libroDTO);
}
