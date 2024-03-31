package com.security.jwt.dto.converters;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.security.jwt.dto.RoleDTO;
import com.security.jwt.repositories.entities.RoleEntity;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RoleDTOConvert {
    
    private ModelMapper mapper;

    public RoleDTO convertDTO(RoleEntity role) {
        RoleDTO roleDTO = mapper.map(role, RoleDTO.class);
        return roleDTO;
    }

    public RoleEntity convertEntity(RoleDTO dto) {
        RoleEntity role = mapper.map(dto, RoleEntity.class);
        return role;
    }
}
