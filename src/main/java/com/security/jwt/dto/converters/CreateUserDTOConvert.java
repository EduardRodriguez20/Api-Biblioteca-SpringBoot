package com.security.jwt.dto.converters;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.security.jwt.dto.CreateUserDTO;
import com.security.jwt.dto.RoleDTO;
import com.security.jwt.dto.UserDTO;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CreateUserDTOConvert {
    
    private ModelMapper mapper;

    public UserDTO convertUserDTO(CreateUserDTO dto) {
        UserDTO entity = mapper.map(dto, UserDTO.class);
        entity.addRole(roleDefault());
        return entity;
    }

    private RoleDTO roleDefault(){
        RoleDTO role = new RoleDTO();
        role.setName("ROLE_USER");
        return role;
    }
}
