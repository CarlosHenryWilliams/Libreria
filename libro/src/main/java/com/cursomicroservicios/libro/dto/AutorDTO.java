package com.cursomicroservicios.libro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class AutorDTO {
    private String nombreCompleto;
    private String nacionalidad;
}
