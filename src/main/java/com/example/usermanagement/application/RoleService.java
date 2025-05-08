package com.example.usermanagement.application;

import com.example.usermanagement.domain.Role;
import com.example.usermanagement.application.interfaces.RoleRepository;

public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role createRole(String roleName) {
        Role role = new Role(roleName);
        return roleRepository.save(role);
    }
}