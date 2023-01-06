package com.example.userservice.dto;

import com.example.userservice.domain.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {
    private final String userId;
    private final String email;
    private final String name;

    private final List<OrderResponse> orders;

    public UserResponse(String userId, String email, String name, List<OrderResponse> orders) {
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.orders = orders;
    }

    public static UserResponse of(User user) {
        return new UserResponse(user.getUserId(), user.getEmail(), user.getName(), new ArrayList<>());
    }
}
