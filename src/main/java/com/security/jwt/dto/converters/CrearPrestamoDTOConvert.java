package com.security.jwt.dto.converters;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.security.jwt.dto.CrearPrestamoDTO;
import com.security.jwt.repositories.LibroRepository;
import com.security.jwt.repositories.RepositoryUser;
import com.security.jwt.repositories.entities.LibroEntity;
import com.security.jwt.repositories.entities.PrestamoEntity;
import com.security.jwt.repositories.entities.UserEntity;
import com.security.jwt.resources.enums.EstadoPrestamo;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CrearPrestamoDTOConvert {

    private RepositoryUser repositoryUser;
    private LibroRepository libroRepository;

    public CrearPrestamoDTO convertDTO(PrestamoEntity prestamo) {
        CrearPrestamoDTO result = new CrearPrestamoDTO();
        result.setCodigo_libro(prestamo.getLibro().getId());
        result.setEmailUsuario(prestamo.getUsuario().getEmail());
        result.setPrestamo(prestamo.getPrestamo());
        result.setDevolucion(prestamo.getDevolucion());
        result.setEstado(prestamo.getEstado());
        return result;
    }

    @SuppressWarnings("null")
    public PrestamoEntity convertEntity(CrearPrestamoDTO dto) {
        Optional<LibroEntity> libro = libroRepository.findById(dto.getCodigo_libro());
        Optional<UserEntity> usuario = repositoryUser.findByEmail(dto.getEmailUsuario());
        if (libro.isPresent() && usuario.isPresent()) {
            PrestamoEntity prestamoEntity = new PrestamoEntity();
            prestamoEntity.setLibro(libro.get());
            prestamoEntity.setUsuario(usuario.get());
            prestamoEntity.setPrestamo(dto.getPrestamo());
            prestamoEntity.setDevolucion(dto.getDevolucion());
            prestamoEntity.setEstado(EstadoPrestamo.SOLICITADO);
            return prestamoEntity;
        }else{
            return null;
        }
    }
}
