package com.security.jwt.dto.converters;

import org.springframework.stereotype.Component;

import com.security.jwt.dto.ListarPrestamoDTO;
import com.security.jwt.repositories.entities.PrestamoEntity;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ListarPrestamoDTOConvert {

    public ListarPrestamoDTO convertDTO(PrestamoEntity prestamo) {
        ListarPrestamoDTO result = new ListarPrestamoDTO();
        result.setCodigo_prestamo(prestamo.getId());
        result.setCodigo_Libro(prestamo.getLibro().getId());
        result.setTitulo(prestamo.getLibro().getTitulo());
        result.setEmail_usuario(prestamo.getUsuario().getEmail());
        result.setPrestamo(prestamo.getPrestamo());
        result.setDevolucion(prestamo.getDevolucion());
        result.setEstado(prestamo.getEstado());
        return result;
    }
}
