package org.example.dtos;


import org.example.Enums.RoleEnum;

import java.util.UUID;

public class RoleDto {
    private UUID id;
    private RoleEnum role;

    protected RoleDto() {};

    public RoleDto(UUID id, RoleEnum role) {
        this.id = id;
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "RoleDto{" +
                "id=" + id +
                ", roleEnum=" + role +
                '}';
    }
}
