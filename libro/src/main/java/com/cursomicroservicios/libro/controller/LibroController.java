package com.cursomicroservicios.libro.controller;

import com.cursomicroservicios.libro.dto.LibroDTO;
import com.cursomicroservicios.libro.model.Libro;
import com.cursomicroservicios.libro.repository.ILibroRepository;
import com.cursomicroservicios.libro.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private ILibroService libroServ;


    @Autowired
    private ILibroRepository libroRepo;

    @GetMapping("/traer")
    public List<Libro> getLibros() {
        return libroServ.getLibros();
    }

    @GetMapping("/traer/{id}")
    public Libro getLibroById(@PathVariable Long id) {
        return libroServ.getLibroById(id);
    }


    @GetMapping("/traer/libroisbn/{isbn}")
    public Libro getLibroByisbn(@PathVariable String isbn) {
        return libroServ.getLibroByisbn(isbn);
    }


    @PutMapping("/editar/{idOriginal}")
    public Libro editLibro(@PathVariable Long idOriginal, @RequestBody LibroDTO LibroDTO) {
        libroServ.editLibro(idOriginal, LibroDTO);
        return libroServ.getLibroById(idOriginal);
    }

    @DeleteMapping("/eliminar/{id}")
    public String deleteLibro(@PathVariable Long id) {

        libroServ.deleteLibro(id);
        return "El libro ha sido eliminado";
    }

    @PostMapping("/crear")
    public String createLibro(@RequestBody LibroDTO libroDTO) {
        libroServ.createLibro(libroDTO);
        return "El libro ha sido creado";
    }


}
