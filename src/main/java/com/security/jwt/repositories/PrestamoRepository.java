package com.security.jwt.repositories;

import org.springframework.data.repository.CrudRepository;

import com.security.jwt.repositories.entities.PrestamoEntity;

public interface PrestamoRepository extends CrudRepository<PrestamoEntity, Long>{
    
}
