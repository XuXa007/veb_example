package org.example.service;

import org.example.dtos.RoleDto;

import java.util.List;
import java.util.UUID;

public interface RoleService {
    List<RoleDto> getAllRoles();

    RoleDto registerRole(RoleDto newRoleDto);
    void deleteRole(UUID roleID);

    RoleDto updateRole(UUID roleID, RoleDto updateRole);
}
