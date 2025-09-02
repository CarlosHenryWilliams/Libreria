package com.cursomicroservicios.autores.controller;

import com.cursomicroservicios.autores.model.Autor;
import com.cursomicroservicios.autores.service.IAutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private IAutorService autorServ;


    @GetMapping("/traer")
    public List<Autor> getAutores() {
        return autorServ.getAutores();
    }

    @GetMapping("/traer/libro/{isbn}")
    public List<Autor> getAutores(@PathVariable String isbn) {
        return autorServ.getAutoresByLibroISBN(isbn);
    }

    @GetMapping("/traer/{id}")
    public Autor getAutor(@PathVariable  Long id) {
        return autorServ.getAutor(id);
    }

    @PutMapping("/editar/{idOriginal}")
    public Autor editAutor(@PathVariable Long idOriginal,@RequestBody Autor autor) {
       autorServ.editAutor(idOriginal, autor);
        return autorServ.getAutor(idOriginal);
    }

    @DeleteMapping("/eliminar/{id}")
    public String deleteAutor(@PathVariable Long id) {
        autorServ.deleteAutor(id);
        return "El autor se ha eliminado";
    }

    @PostMapping("/crear")
    public String createAutor(@RequestBody Autor autor) {
        autorServ.createAutor(autor);
        return "El autor se ha creado";
    }


}
