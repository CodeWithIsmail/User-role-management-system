package com.example.usermanagement.domain;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class User {
    private UUID id;
    private String name;
    private String email;
    private List<Role> roles;

    public User(String name, String email) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.roles = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void assignRole(Role role) {
        this.roles.add(role);
    }
}