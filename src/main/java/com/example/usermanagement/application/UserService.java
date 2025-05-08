package com.example.usermanagement.application;

import com.example.usermanagement.domain.User;
import com.example.usermanagement.domain.Role;
import com.example.usermanagement.application.interfaces.UserRepository;
import com.example.usermanagement.application.interfaces.RoleRepository;

import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User createUser(String name, String email) {
        User user = new User(name, email);
        return userRepository.save(user);
    }

    public void assignRoleToUser(String userId, String roleId) {
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<Role> roleOpt = roleRepository.findById(roleId);

        if (userOpt.isEmpty() || roleOpt.isEmpty()) {
            throw new IllegalArgumentException("User or Role not found");
        }

        User user = userOpt.get();
        Role role = roleOpt.get();
        user.assignRole(role);
        userRepository.save(user);
    }

    public User getUserDetails(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}