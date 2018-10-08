package com.brewedbros.app.dtos;

import com.brewedbros.app.entities.User;
import com.brewedbros.app.entities.UserRole;
import lombok.Value;

import java.util.Set;

@Value
public class UserDto {
    private final String id;
    private final String email;
    private final Set<UserRole> roles;

    public static UserDto fromUser(User user) {
        return new UserDto(user.getId().trim(),
                user.getEmail(),
                user.getRoles());
    }
}
