package com.every_restaurant.springbackend.controller;


import com.every_restaurant.springbackend.exception.ResourceNotFoundException;
import com.every_restaurant.springbackend.model.User;
import com.every_restaurant.springbackend.repository.UserRepository;
import com.every_restaurant.springbackend.security.CurrentUser;
import com.every_restaurant.springbackend.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }

/*    @GetMapping("/get-user-login")
    @PreAuthorize("hasRole('USER')")
    public User getUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }*/

}
