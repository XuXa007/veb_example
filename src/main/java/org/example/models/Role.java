package org.example.models;

import jakarta.persistence.*;
import org.example.Enums.RoleEnum;

import java.util.List;

@Entity
@Table(name = "roles")
public class Role extends Base {

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<Users> users;
    @Column(name="name", length = 11, nullable = false)
    private RoleEnum roleEnum;

    protected Role() {};

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public RoleEnum getRoleEnum() {
        return roleEnum;
    }

    public void setRoleEnum(RoleEnum roleEnum) {
        this.roleEnum = roleEnum;
    }

    @Override
    public String toString() {
        return "Role{" +
                "users=" + users +
                ", roleEnum=" + roleEnum +
                ", id=" + id +
                '}';
    }
}