package com.security.jwt.repositories;

import org.springframework.data.repository.CrudRepository;

import com.security.jwt.repositories.entities.LibroEntity;
import com.security.jwt.repositories.entities.PrestamoEntity;
import com.security.jwt.repositories.entities.UserEntity;

public interface PrestamoRepository extends CrudRepository<PrestamoEntity, Long>{
    boolean existsByUsuario(UserEntity usuario);
    boolean existsByLibro(LibroEntity libro);
}
