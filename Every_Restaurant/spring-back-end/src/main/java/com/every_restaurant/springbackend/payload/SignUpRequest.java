package com.every_restaurant.springbackend.payload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class SignUpRequest {
    @NotBlank
    private String login;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

}
