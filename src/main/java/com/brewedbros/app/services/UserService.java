package com.brewedbros.app.services;

import com.brewedbros.app.entities.User;

import java.util.Optional;

public interface UserService {
    User createOfficer(String email, String password);

    Optional<User> getUser(String userId);
}
