package com.security.jwt.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.jwt.dto.CambiarPrestamoDTO;
import com.security.jwt.dto.CrearPrestamoDTO;
import com.security.jwt.dto.ListarPrestamoDTO;
import com.security.jwt.repositories.entities.PrestamoEntity;
import com.security.jwt.services.PrestamoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/prestamos")
@AllArgsConstructor
public class PrestamoController {

    private PrestamoService prestamoService;

    @PostMapping("/crear")
    public ResponseEntity<CrearPrestamoDTO> crear(@RequestBody CrearPrestamoDTO prestamoDTO) {
        CrearPrestamoDTO creado = prestamoService.crear(prestamoDTO);
        if (creado != null) {
            return new ResponseEntity<>(creado, HttpStatus.OK);
        }
        return new ResponseEntity<>(creado, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ListarPrestamoDTO>> listar() {
        List<ListarPrestamoDTO> prestamoDTOs = prestamoService.listar();
        if (prestamoDTOs != null) {
            return new ResponseEntity<>(prestamoDTOs, HttpStatus.OK);
        }
        return new ResponseEntity<>(prestamoDTOs, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/editar")
    public ResponseEntity<String> editar(@RequestBody CambiarPrestamoDTO prestamoDTO) {
        PrestamoEntity edited = prestamoService.editar(prestamoDTO);
        if (edited.getId() != null)  {
            return new ResponseEntity<>("El nuevo estado: " + prestamoDTO.getEstadoPrestamo() + " fue aplicado exitosamente.", HttpStatus.OK);
        }
        return new ResponseEntity<>("No se encontro el prestamo o ya fue cancelado", HttpStatus.BAD_REQUEST);
    }

}
