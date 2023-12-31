package org.example.services.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.example.models.enums.UserRoleType;
import org.example.services.dtos.input.UserDTO;
import org.example.services.dtos.input.UserRoleDTO;
import org.example.models.entities.UserRole;
import org.example.repositories.UserRoleRepository;
import org.example.services.UserRoleService;
import org.example.services.internal.InternalRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@EnableCaching
public class UserRoleServiceImpl implements UserRoleService, InternalRoleService {
    private final UserRoleRepository userRoleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository, ModelMapper modelMapper) {
        this.userRoleRepository = userRoleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = "user_roles", allEntries = true)
    public UserRoleDTO createUserRole(UserRoleDTO userRoleDTO) {
        UserRole userRole = modelMapper.map(userRoleDTO, UserRole.class);
        UserRole savedUserRole = userRoleRepository.save(userRole);
        return modelMapper.map(savedUserRole, UserRoleDTO.class);
    }

    @Override
    @Cacheable("user_roles")
    public UserRoleDTO getUserRoleById(String id) {
        Optional<UserRole> userRoleOptional = userRoleRepository.findById(id);

        if (userRoleOptional.isPresent()) {
            return modelMapper.map(userRoleOptional.get(), UserRoleDTO.class);
        } else {
            throw new EntityNotFoundException("User role not found with id: " + id);
        }
    }

    @Override
    @Cacheable("user_roles")
    public List<UserRoleDTO> getAllUserRoles() {
        List<UserRole> userRoles = userRoleRepository.findAll();
        return userRoles.stream()
                .map(userRole -> modelMapper.map(userRole, UserRoleDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = {"user_roles", "users", "offers", "brands", "models"}, allEntries = true)
    public void deleteUserRole(String id) {
        userRoleRepository.deleteById(id);
    }

    @Override
    @Cacheable("user_roles")
    public UserRole findByRole(UserRoleType roleType) {
        UserRole userRole = userRoleRepository.findByRole(roleType)
                .orElseThrow(() -> new EntityNotFoundException("User role not found: " + roleType));
        return userRole;
    }

    @Override
    @Cacheable("user_roles")
    public List<UserRoleDTO> findAll() {
        return userRoleRepository.findAll().stream().map(e -> modelMapper.map(e, UserRoleDTO.class)).collect(Collectors.toList());
    }
}

