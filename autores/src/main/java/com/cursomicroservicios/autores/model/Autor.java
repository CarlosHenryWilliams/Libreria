package com.cursomicroservicios.autores.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombreCompleto;
    private String nacionalidad;
    @Temporal(TemporalType.DATE)
    private LocalDate fechaNacimiento;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> listaISBNLibros;

}
