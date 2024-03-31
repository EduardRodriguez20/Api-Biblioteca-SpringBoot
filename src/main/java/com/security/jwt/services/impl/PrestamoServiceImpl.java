package com.security.jwt.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.security.jwt.dto.CambiarPrestamoDTO;
import com.security.jwt.dto.CrearPrestamoDTO;
import com.security.jwt.dto.ListarPrestamoDTO;
import com.security.jwt.dto.converters.CambiarPrestamoDTOConvert;
import com.security.jwt.dto.converters.CrearPrestamoDTOConvert;
import com.security.jwt.dto.converters.ListarPrestamoDTOConvert;
import com.security.jwt.repositories.LibroRepository;
import com.security.jwt.repositories.PrestamoRepository;
import com.security.jwt.repositories.entities.LibroEntity;
import com.security.jwt.repositories.entities.PrestamoEntity;
import com.security.jwt.services.PrestamoService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PrestamoServiceImpl implements PrestamoService{

    private PrestamoRepository prestamoRepository;
    private LibroRepository libroRepository;
    private CrearPrestamoDTOConvert crearPrestamoDTO;
    private CambiarPrestamoDTOConvert cambiarPrestamoDTO;
    private ListarPrestamoDTOConvert listarPrestamoDTO;

    @Override
    public CrearPrestamoDTO crear(CrearPrestamoDTO crearPrestamo) {
        CrearPrestamoDTO crearDTO = new CrearPrestamoDTO();
        PrestamoEntity prestamo = crearPrestamoDTO.convertEntity(crearPrestamo);
        if (prestamo != null && prestamo.getLibro().existeInventario()) {
            crearDTO = crearPrestamoDTO.convertDTO(prestamoRepository.save(prestamo));
            LibroEntity libro = prestamo.getLibro();
            libro.libroPrestado();
            libroRepository.save(libro);
            return crearDTO;
        }
        return crearDTO;
    }

    @Override
    public List<ListarPrestamoDTO> listar() {
        List<PrestamoEntity> prestamos = (List<PrestamoEntity>) prestamoRepository.findAll();
        List<ListarPrestamoDTO> prestamoDTOs = new ArrayList<>();
        for (PrestamoEntity prestamo : prestamos){
            prestamoDTOs.add(listarPrestamoDTO.convertDTO(prestamo));
        }
        return prestamoDTOs;
    }

    @Override
    public PrestamoEntity editar(CambiarPrestamoDTO prestamo) {
        PrestamoEntity prestamoEdit = cambiarPrestamoDTO.convertEntity(prestamo);
        if (prestamoEdit.getId() != null) {
            return prestamoRepository.save(prestamoEdit);
        }
        return prestamoEdit;
    }    
}
