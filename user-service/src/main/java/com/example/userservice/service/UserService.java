package com.example.userservice.service;

import com.example.userservice.domain.User;
import com.example.userservice.dto.UserRequest;

public interface UserService {
    User createUser(UserRequest userRequest);
}
