package com.example.usermanagement.infrastructure.controller;

import com.example.usermanagement.application.UserService;
import com.example.usermanagement.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user.getName(), user.getEmail());
        return ResponseEntity.ok(createdUser.getId().toString());
    }

    @PostMapping("/{userId}/assign-role/{roleId}")
    public ResponseEntity<String> assignRoleToUser(@PathVariable String userId, @PathVariable String roleId) {
        userService.assignRoleToUser(userId, roleId);
        return ResponseEntity.ok("Role assigned successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserDetails(@PathVariable String id) {
        User user = userService.getUserDetails(id);
        return ResponseEntity.ok(user);
    }
}