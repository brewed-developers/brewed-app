package com.brewedbros.app.services;

import com.brewedbros.app.entities.User;
import com.brewedbros.app.entities.UserRole;
import com.brewedbros.app.repositories.UserRepository;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createOfficer(String email, String password) {

        User user = User.builder()
                .id(UUID.randomUUID().toString())
                .email(email)
                .password(passwordEncoder.encode(password))
                .firstName("First Name")
                .lastName("Last Name")
                .roles(Sets.newHashSet(UserRole.OFFICER))
                .build();
        return repository.save(user);
    }
    @Override
    public Optional<User> getUser(String userId) {
        return repository.findById(userId);
    }
}