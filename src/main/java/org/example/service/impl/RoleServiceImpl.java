package org.example.service.impl;

import org.example.dtos.RoleDto;
import org.example.exception.NotFoundException;
import org.example.models.*;
import org.example.repo.RoleRepository;
import org.example.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;
    private String role = "role";

    @Override
    public List<RoleDto> getAllRoles() {
        return roleRepository.findAll().stream().map((s) -> modelMapper.map(s, RoleDto.class)).collect(Collectors.toList());
    }
    @Override
    public RoleDto registerRole(RoleDto newRoleDto) {
        Role b = modelMapper.map(newRoleDto, Role.class);
        return modelMapper.map(roleRepository.save(b), RoleDto.class);
    }

    @Override
    public void deleteRole(UUID roleID) {
        Role role = roleRepository.findById(roleID)
                .orElseThrow(() -> new NotFoundException("Could not find user by id: " + roleID));

        roleRepository.delete(role);
    }

    @Override
    public RoleDto updateRole(UUID roleID, RoleDto updateRole) {
        Role existingRole = roleRepository.findById(roleID).orElseThrow(() -> new NotFoundException("Could not find" + role + " by id: " + roleID));


        existingRole.setId(updateRole.getId());
        existingRole.setRoleEnum(updateRole.getRole());


        Role savedRole = roleRepository.save(existingRole);
        return modelMapper.map(savedRole, RoleDto.class);
    }
}
