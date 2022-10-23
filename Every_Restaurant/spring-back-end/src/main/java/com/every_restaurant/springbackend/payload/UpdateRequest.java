package com.every_restaurant.springbackend.payload;

import lombok.Data;

@Data
public class UpdateRequest {
    private String password;
    private String name;
    private String description;
    private String image;
}
