package com.every_restaurant.springbackend.controller;


import com.every_restaurant.springbackend.exception.BadRequestException;
import com.every_restaurant.springbackend.exception.ResourceNotFoundException;
import com.every_restaurant.springbackend.model.User;
import com.every_restaurant.springbackend.payload.UpdateRequest;
import com.every_restaurant.springbackend.payload.UpdateResponse;
import com.every_restaurant.springbackend.repository.UserRepository;
import com.every_restaurant.springbackend.security.CurrentUser;
import com.every_restaurant.springbackend.security.UserPrincipal;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserController(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }

    @GetMapping("/get-users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/update-user")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> RedactUser(@CurrentUser UserPrincipal userPrincipal,
                                        @RequestBody UpdateRequest updateRequest) {
        try {
            User curUser = userRepository.findById(userPrincipal.getId()).get();
            /*curUser.setPassword(passwordEncoder.encode(user.getPassword()));
            curUser.setImageUrl(user.getImageUrl());
            curUser.setName(user.getName());
            curUser.setDescription(user.getDescription());*/
            if(updateRequest.getPassword() != null) {
                if (updateRequest.getPassword().length() > 6 && updateRequest.getPassword().length() < 35) {
                    curUser.setPassword(passwordEncoder.encode(updateRequest.getPassword()));
                }
            }
            //curUser.setImageUrl(image);
            if(updateRequest.getName() != null) {
                if (updateRequest.getName().length() > 2 && updateRequest.getName().length() < 35) {
                    curUser.setName(updateRequest.getName());
                }
            }
            if(updateRequest.getDescription() != null) {
                if (updateRequest.getDescription().length() > 0 && updateRequest.getDescription().length() < 255) {
                    curUser.setDescription(updateRequest.getDescription());
                }
            }
            curUser.setUpdated_at(new Date());
            userRepository.save(curUser);
            return ResponseEntity.ok(new UpdateResponse(true, "User updated", curUser));
        } catch (Exception ex) {
            throw new BadRequestException(ex.getMessage());
        }
    }

}
