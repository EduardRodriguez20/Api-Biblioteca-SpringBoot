package com.security.jwt.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class UserDTO {
    private String email;
    private String password;
    private List<RoleDTO> roles = new ArrayList<>();

    public void addRole(RoleDTO role) {
        this.roles.add(role);
    }
}
