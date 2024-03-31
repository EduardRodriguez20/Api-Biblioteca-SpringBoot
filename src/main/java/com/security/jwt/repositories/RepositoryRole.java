package com.security.jwt.repositories;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import com.security.jwt.repositories.entities.RoleEntity;

public interface RepositoryRole extends CrudRepository<RoleEntity, BigInteger>{
    
}
