package com.security.jwt.dto;

import com.security.jwt.resources.enums.EstadoPrestamo;

import lombok.Data;

@Data
public class CambiarPrestamoDTO {
    private Long codigo_prestamo;
    private EstadoPrestamo estadoPrestamo;
}
