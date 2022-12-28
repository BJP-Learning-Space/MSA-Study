package com.example.userservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRequest(
        @NotNull(message = "Email cannot be null") @Size(min = 2, message = "Email should have at least 2 characters") @Email String email,
        @NotNull(message = "Password cannot be null") @Size(min = 8, message = "Password should have at least 8 characters") String password,
        @NotNull(message = "Name cannot be null") @Size(min = 2, message = "Name should have at least 2 characters") String name) {
    public UserRequest(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    @Override
    public String email() {
        return email;
    }

    @Override
    public String password() {
        return password;
    }

    @Override
    public String name() {
        return name;
    }
}
