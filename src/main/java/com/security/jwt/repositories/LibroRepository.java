package com.security.jwt.repositories;

import org.springframework.data.repository.CrudRepository;

import com.security.jwt.repositories.entities.LibroEntity;

public interface LibroRepository extends CrudRepository<LibroEntity, Long>{
    
}
