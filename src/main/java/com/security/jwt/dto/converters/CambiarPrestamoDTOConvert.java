package com.security.jwt.dto.converters;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.security.jwt.dto.CambiarPrestamoDTO;
import com.security.jwt.repositories.PrestamoRepository;
import com.security.jwt.repositories.entities.PrestamoEntity;
import com.security.jwt.resources.enums.EstadoPrestamo;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CambiarPrestamoDTOConvert {
    
    private PrestamoRepository prestamoRepository;

    @SuppressWarnings("null")
    public PrestamoEntity convertEntity(CambiarPrestamoDTO dto) {
        PrestamoEntity prestamo = new PrestamoEntity();
        Optional<PrestamoEntity> existPrestamo = prestamoRepository.findById(dto.getCodigo_prestamo());
        if (existPrestamo.isPresent()) {
            if (existPrestamo.get().getEstado() != EstadoPrestamo.CANCELADO) {
                prestamo = existPrestamo.get();
                prestamo.setEstado(dto.getEstadoPrestamo());
                return prestamo;
            }
        }
        return prestamo;
    }
}
