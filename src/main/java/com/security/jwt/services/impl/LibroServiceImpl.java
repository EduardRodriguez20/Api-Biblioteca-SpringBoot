package com.security.jwt.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.security.jwt.repositories.LibroRepository;
import com.security.jwt.repositories.entities.LibroEntity;
import com.security.jwt.services.LibroService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LibroServiceImpl implements LibroService {

    private LibroRepository libroRepository;

    @Override
    public LibroEntity save(LibroEntity libro) {
        return libroRepository.save(libro);
    }

    @Override
    public List<LibroEntity> findAll() {
        return (List<LibroEntity>) libroRepository.findAll();
    }

    @Override
    public boolean edit(Long id, LibroEntity libro) {
        Optional<LibroEntity> editLibro = libroRepository.findById(id);
        if (editLibro.isPresent()) {
            editLibro.get().setTitulo(libro.getTitulo());
            editLibro.get().setAutor(libro.getAutor());
            editLibro.get().setGenero(libro.getGenero());
            editLibro.get().setAño(libro.getAño());
            editLibro.get().setInventario(libro.getInventario());
            libroRepository.save(editLibro.get());
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        Optional<LibroEntity> deleteLibro = libroRepository.findById(id);
        if (deleteLibro.isPresent()) {
            libroRepository.delete(deleteLibro.get());
            return true;
        }
        return false;
    }
    
}
