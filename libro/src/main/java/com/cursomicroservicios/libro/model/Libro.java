package com.cursomicroservicios.libro.model;

import com.cursomicroservicios.libro.dto.AutorDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn;
    private String titulo;
    private String descripcion;
    private Long anioLanzamiento;
    @ElementCollection(fetch = FetchType.EAGER) // para que cargue cuando lo necesite nomas.
    private List<String> listaAutores;

}
