package org.example.controllers;

import org.example.dtos.BrandDto;
import org.example.dtos.OfferDto;
import org.example.dtos.RoleDto;
import org.example.models.Role;
import org.example.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/roles")
    Iterable<RoleDto> all() {
        return roleService.getAllRoles();
    }

    @PostMapping("/role")
    RoleDto newRole(@RequestBody RoleDto newRole) {
        return roleService.registerRole(newRole);
    }

    @DeleteMapping("/role/{roleID}")
    void deleteRole(@PathVariable("roleID") RoleDto roleDto) {
        roleService.registerRole(roleDto);
    }

    @PutMapping("/role/{roleID}")
    public RoleDto updateRole(@PathVariable("roleID") UUID roleID, @RequestBody RoleDto updateRole) {
        return roleService.updateRole(roleID, updateRole);
    }
}
