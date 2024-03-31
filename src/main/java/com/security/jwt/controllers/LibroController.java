package com.security.jwt.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.jwt.repositories.entities.LibroEntity;
import com.security.jwt.services.LibroService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@RestController
@RequestMapping("/libreria")
public class LibroController {

    private LibroService libroService;

    @PostMapping("/crear")
    public ResponseEntity<LibroEntity> save(@RequestBody LibroEntity libro) {
        try {
            return new ResponseEntity<>(libroService.save(libro), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/listar")
    public ResponseEntity<List<LibroEntity>> findAll() {
        List<LibroEntity> libros = libroService.findAll();
        if (!libros.isEmpty()) {
            return new ResponseEntity<>(libros, HttpStatus.OK);
        }
        return new ResponseEntity<>(libros, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/editar")
    public ResponseEntity<String> edit(@RequestParam Long id, @RequestBody LibroEntity libro) {
        if (libroService.edit(id, libro)) {
            return new ResponseEntity<>("Libro editado correctamente", HttpStatus.OK);
        }
        return new ResponseEntity<>("Libro no encontrado", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<String> deleteById(@RequestParam Long id) {
        if (libroService.deleteById(id)) {
            return new ResponseEntity<>("Libro eliminado correctamente", HttpStatus.OK);
        }
        return new ResponseEntity<>("No se encontro el libro o ya tiene prestamos relacionados", HttpStatus.BAD_REQUEST);
    }
    
}
