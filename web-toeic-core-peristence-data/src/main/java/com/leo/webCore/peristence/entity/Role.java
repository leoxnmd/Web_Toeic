package com.leo.webCore.peristence.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @Column(name = "roleid")
    private String roleId;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "role",fetch = FetchType.LAZY)
    private List<User> usersList;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
