package com.security.jwt.dto.converters;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.security.jwt.dto.RoleDTO;
import com.security.jwt.dto.UserDTO;
import com.security.jwt.repositories.entities.RoleEntity;
import com.security.jwt.repositories.entities.UserEntity;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserDTOConvert {
    
    private ModelMapper mapper;
    private RoleDTOConvert roleDTOConvert;

    public UserDTO convertDTO(UserEntity user) {
        UserDTO dto = mapper.map(user, UserDTO.class);
        for (RoleEntity role : user.getRoles()){
            dto.getRoles().add(roleDTOConvert.convertDTO(role));
        }
        return dto;
    }

    public UserEntity convertEntity(UserDTO user) {
        UserEntity entity = mapper.map(user, UserEntity.class);
        for (RoleDTO role : user.getRoles()){
            entity.getRoles().add(roleDTOConvert.convertEntity(role));
        }
        return mapper.map(user, UserEntity.class);
    }
}
