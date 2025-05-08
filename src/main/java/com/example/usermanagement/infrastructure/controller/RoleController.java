package com.example.usermanagement.infrastructure.controller;

import com.example.usermanagement.application.RoleService;
import com.example.usermanagement.domain.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<String> createRole(@RequestBody Role role) {
        Role createdRole = roleService.createRole(role.getRoleName());
        return ResponseEntity.ok(createdRole.getId().toString());
    }
}