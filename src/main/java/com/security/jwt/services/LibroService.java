package com.security.jwt.services;

import java.util.List;

import com.security.jwt.repositories.entities.LibroEntity;

public interface LibroService {
    LibroEntity save(LibroEntity libro);
    List<LibroEntity> findAll();
    boolean edit(Long id, LibroEntity libro);
    boolean deleteById(Long id);
}
