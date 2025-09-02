package com.cursomicroservicios.libro.repository;

import com.cursomicroservicios.libro.dto.AutorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="autoresapi", url="http://localhost:9002/autor")
public interface IAutoresAPI {
    @GetMapping("/traer/libro/{isbn}")
    public List<AutorDTO> findAutoresLibroISBNApi(@PathVariable("isbn") String isbn);
}
