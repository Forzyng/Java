package com.every_restaurant.springbackend.payload;

import com.every_restaurant.springbackend.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateResponse {
    private boolean success;
    private String message;
    private User user;
}
