package com.cursomicroservicios.libro.service;

import com.cursomicroservicios.libro.dto.AutorDTO;
import com.cursomicroservicios.libro.dto.LibroDTO;
import com.cursomicroservicios.libro.model.Libro;
import com.cursomicroservicios.libro.repository.IAutoresAPI;
import com.cursomicroservicios.libro.repository.ILibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class LibroService implements ILibroService {

    @Autowired
    private ILibroRepository libroRepo;

    @Autowired
    private IAutoresAPI autoresRepoAPI;

    @Override
    public List<Libro> getLibros() {
        return libroRepo.findAll();
    }

    @Override
    public Libro getLibroById(Long id) {
        return libroRepo.findById(id).orElse(null);
    }


    @Override
    public Libro getLibroByisbn(String isbn) {
        return libroRepo.findLibroByisbn(isbn);
    }


    @Override
    public void editLibro(Long id, LibroDTO libroDTO) {
        Libro libroAEditar = this.getLibroById(id);
        libroAEditar.setIsbn(libroDTO.getIsbn());
        libroAEditar.setTitulo(libroDTO.getTitulo());
        libroAEditar.setDescripcion(libroDTO.getDescripcion());
        libroAEditar.setAnioLanzamiento(libroDTO.getAnioLanzamiento());
        libroAEditar.getListaAutores().clear();

        List<AutorDTO> autorDTOLista = autoresRepoAPI.findAutoresLibroISBNApi(libroDTO.getIsbn());
        for(AutorDTO autor : autorDTOLista ){
            libroAEditar.getListaAutores().add(autor.getNombreCompleto() + " - " + autor.getNacionalidad());
        }
        libroRepo.save(libroAEditar);
    }

    @Override
    public void deleteLibro(Long id) {
        libroRepo.deleteById(id);
    }

    @Override
    public void createLibro(LibroDTO libroDTO) {
        Libro libro = new Libro();
        libro.setIsbn(libroDTO.getIsbn());
        libro.setTitulo(libroDTO.getTitulo());
        libro.setAnioLanzamiento(libroDTO.getAnioLanzamiento());
        libro.setDescripcion(libroDTO.getDescripcion());
        System.out.println("ISBN  QUE LLEGA DEL LIBRO" + libroDTO.getIsbn());
        // Inicializar Lista
        libro.setListaAutores(new LinkedList<>());
        List<AutorDTO> autorDTOLista = autoresRepoAPI.findAutoresLibroISBNApi(libroDTO.getIsbn());
        for(AutorDTO autor : autorDTOLista ){
            libro.getListaAutores().add(autor.getNombreCompleto() + " - " + autor.getNacionalidad());
        }

        libroRepo.save(libro);
    }
}
