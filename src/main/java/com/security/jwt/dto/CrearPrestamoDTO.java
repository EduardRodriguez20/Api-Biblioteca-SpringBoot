package com.security.jwt.dto;

import java.util.Date;

import com.security.jwt.resources.enums.EstadoPrestamo;

import lombok.Data;

@Data
public class CrearPrestamoDTO {
    private Long codigo_Libro;
    private String emailUsuario;
    private Date prestamo = new Date();
    private Date devolucion;
    private EstadoPrestamo estado;
}
