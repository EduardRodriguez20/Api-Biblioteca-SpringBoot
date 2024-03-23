package com.security.jwt.services;

import java.util.List;

import com.security.jwt.dto.CambiarPrestamoDTO;
import com.security.jwt.dto.CrearPrestamoDTO;
import com.security.jwt.dto.ListarPrestamoDTO;
import com.security.jwt.repositories.entities.PrestamoEntity;

public interface PrestamoService {
    CrearPrestamoDTO crear(CrearPrestamoDTO crearPrestamo);
    List<ListarPrestamoDTO> listar();
    PrestamoEntity editar(CambiarPrestamoDTO prestamo);
}
