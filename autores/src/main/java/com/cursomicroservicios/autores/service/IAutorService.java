package com.cursomicroservicios.autores.service;

import com.cursomicroservicios.autores.model.Autor;

import java.util.List;

public interface IAutorService {
    // Crud
    // 1- Get autores
    public List<Autor> getAutores();
    // 2 - Get autor
    public Autor getAutor(Long id);
    // 3 - Edit Autor
    public void editAutor(Long id, Autor autor);
    // 4 - Delete autor
    public void deleteAutor(Long id);
    // 5 - Create autor
    public void createAutor(Autor autor);
    // 6 - Get autores by LibroISBN
    public List<Autor> getAutoresByLibroISBN(String ISBN);
}
