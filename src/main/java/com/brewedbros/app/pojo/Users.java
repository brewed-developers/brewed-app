package com.brewedbros.app.pojo;

import com.brewedbros.app.entities.User;
import com.brewedbros.app.entities.UserRole;
import com.google.common.collect.Sets;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

public class Users {
    private static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
    public static final String OFFICER_EMAIL = "officer@example.com";
    public static final String OFFICER_PASSWORD = "officer";
    public static final String CAPTAIN_EMAIL = "captain@example.com";
    public static final String CAPTAIN_PASSWORD = "captain";

    private static final User OFFICER = User.builder().id(UUID.randomUUID().toString()).email(OFFICER_EMAIL).password(PASSWORD_ENCODER.encode(OFFICER_PASSWORD)).roles(Sets.newHashSet(UserRole.OFFICER)).build();
    private static final User CAPTAIN = User.builder().id(UUID.randomUUID().toString()).email(CAPTAIN_EMAIL).password(PASSWORD_ENCODER.encode(CAPTAIN_PASSWORD)).roles(Sets.newHashSet(UserRole.CAPTAIN)).build();

    public static User newRandomOfficer() {
        return newRandomOfficer(UUID.randomUUID().toString());
    }

    public static User newRandomOfficer(String userId) {
        String uniqueId = userId.toString().substring(0, 5);
        return User.builder().id(userId).email("user-" + uniqueId + "@example.com").password(PASSWORD_ENCODER.encode("user")).roles(Sets.newHashSet(UserRole.OFFICER)).build();
    }

    public static User officer() {
        return OFFICER;
    }

    public static User captain() {
        return CAPTAIN;
    }

    private Users() {
    }
}
