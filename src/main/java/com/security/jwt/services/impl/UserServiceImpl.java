package com.security.jwt.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.security.jwt.dto.RoleDTO;
import com.security.jwt.dto.UserDTO;
import com.security.jwt.dto.converters.RoleDTOConvert;
import com.security.jwt.dto.converters.UserDTOConvert;
import com.security.jwt.repositories.PrestamoRepository;
import com.security.jwt.repositories.RepositoryRole;
import com.security.jwt.repositories.RepositoryUser;
import com.security.jwt.repositories.entities.RoleEntity;
import com.security.jwt.repositories.entities.UserEntity;
import com.security.jwt.services.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private RepositoryUser repositoryUser;
    private RepositoryRole repositoryRole;
    private PrestamoRepository prestamoRepository;
    private UserDTOConvert userDTOConverter;
    private RoleDTOConvert roleDTOConvert;

    @SuppressWarnings("null")
    @Override
    public UserDTO save(UserDTO user) {
        Optional<UserEntity> userEntity = repositoryUser.findByEmail(user.getEmail());
        if (userEntity.isEmpty()) {
            UserEntity entity = userDTOConverter.convertEntity(user);
            for (RoleEntity role : entity.getRoles()){
                RoleEntity saved = repositoryRole.save(role);
                role.setId(saved.getId());
            }
            UserEntity userSaved = repositoryUser.save(entity);
            return userDTOConverter.convertDTO(userSaved);
        }
        return null;
    }

    @Override
    public UserDTO findByEmail(String email) {
        Optional<UserEntity> userEntity = repositoryUser.findByEmail(email);
        if (userEntity.isPresent()) {
            return userDTOConverter.convertDTO(userEntity.get());
        }
        return null;
    }

    @Override
    public List<UserDTO> findAll() {
        List<UserEntity> entities = (List<UserEntity>) repositoryUser.findAll();
        List<UserDTO> dtos = new ArrayList<>();
        for (UserEntity entity : entities) {
            dtos.add(userDTOConverter.convertDTO(entity));
        }
        return dtos;
    }

    @Override
    public boolean edit(String email, UserDTO user) {
        Optional<UserEntity> userEntity = repositoryUser.findByEmail(email);
        if (userEntity.isPresent()) {
            UserEntity entity = userEntity.get();
            entity.setEmail(user.getEmail());
            entity.setPassword(user.getPassword());
            for (RoleDTO role : user.getRoles()) {
                entity.getRoles().add(roleDTOConvert.convertEntity(role));
            }
            repositoryUser.save(entity);
            return true;
        }
        return false;
    }

    @SuppressWarnings("null")
    @Override
    public boolean deleteByEmail(String email) {
        Optional<UserEntity> userEntity = repositoryUser.findByEmail(email);
        if (userEntity.isPresent()) {
            if (prestamoRepository.existsByUsuario(userEntity.get())) {
                return false;
            }
            repositoryUser.delete(userEntity.get());
            return true;
        }
        return false;
    }
}
