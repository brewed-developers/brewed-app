package com.brewedbros.app.repositories;

import com.brewedbros.app.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    Optional<User> findByEmailIgnoreCase(String email);
}