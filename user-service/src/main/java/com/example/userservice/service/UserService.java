package com.example.userservice.service;

import com.example.userservice.domain.User;
import com.example.userservice.dto.UserRequest;

import java.util.List;

public interface UserService {
    User createUser(UserRequest userRequest);

    List<User> findAllUsers();
}
