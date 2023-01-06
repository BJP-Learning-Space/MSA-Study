package com.example.userservice.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false, length = 100, unique = true)
    private String encryptedPassword;

    @Column(nullable = false, length = 50)
    private String name;

    public User() {
    }

    public User(String email, String encryptedPassword, String name) {
        this.email = email;
        this.encryptedPassword = encryptedPassword;
        this.name = name;
    }

    public User(final String userId, final String email, final String encryptedPassword, final String name) {
        this.userId = userId;
        this.email = email;
        this.encryptedPassword = encryptedPassword;
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public String getName() {
        return name;
    }
}
