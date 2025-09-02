package com.cursomicroservicios.autores.service;

import com.cursomicroservicios.autores.model.Autor;
import com.cursomicroservicios.autores.repository.IAutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService implements IAutorService{

    @Autowired
    private IAutorRepository autorRepo;

    @Override
    public List<Autor> getAutores() {
        return autorRepo.findAll();
    }

    @Override
    public Autor getAutor(Long id) {
        return autorRepo.findById(id).orElse(null);
    }

    @Override
    public void editAutor(Long id, Autor autor) {
        Autor autorAEditar = this.getAutor(id);
        autorAEditar.setNombreCompleto(autor.getNombreCompleto());
        autorAEditar.setNacionalidad(autor.getNacionalidad());
        autorAEditar.setFechaNacimiento(autor.getFechaNacimiento());

        // Lista de libros
        autorAEditar.getListaISBNLibros().clear();
        // Agregar nuevos libros.
         //  autorAEditar.setListaISBNLibros( );
        autorRepo.save(autorAEditar);
    }

    @Override
    public void deleteAutor(Long id) {
        autorRepo.deleteById(id);
    }

    @Override
    public void createAutor(Autor autor) {
        autorRepo.save(autor);
    }

    @Override
    public List<Autor> getAutoresByLibroISBN(String ISBN){
        return autorRepo.findAutoresIsbn(ISBN);
    }
}
