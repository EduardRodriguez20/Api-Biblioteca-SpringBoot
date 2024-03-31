package com.security.jwt.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserDTO {
    private String email;
    private String password;
    private List<RoleDTO> roles;
}
