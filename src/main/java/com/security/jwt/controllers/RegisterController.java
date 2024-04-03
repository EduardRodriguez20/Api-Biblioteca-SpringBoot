package com.security.jwt.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.jwt.dto.CreateUserDTO;
import com.security.jwt.dto.UserDTO;
import com.security.jwt.dto.converters.CreateUserDTOConvert;
import com.security.jwt.services.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class RegisterController {

    private UserService userService;
    private CreateUserDTOConvert userDTOConvert;

    @PostMapping("/register")
    public ResponseEntity<String> save(@RequestBody CreateUserDTO userDTO) {
        UserDTO user = userService.save(userDTOConvert.convertUserDTO(userDTO));
        if (user!= null) {
            return new ResponseEntity<>("Usuario creado correctamente", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("El correo ingresado ya tiene una cuenta", HttpStatus.BAD_REQUEST);
    }
    
}
