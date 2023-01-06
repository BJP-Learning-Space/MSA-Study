package com.example.userservice.service;

import com.example.userservice.dto.UserRequest;
import com.example.userservice.dto.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);
    UserResponse findUserById(String userId);
    Iterable<UserResponse> findAllUsers();
}
