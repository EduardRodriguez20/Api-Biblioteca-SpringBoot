package com.security.jwt.dto;

import lombok.Data;

@Data
public class CreateUserDTO {
    private String email;
    private String password;
}
