package com.brewedbros.app.controllers;

import com.brewedbros.app.dtos.UserDto;
import com.brewedbros.app.entities.User;
import com.brewedbros.app.exceptions.UserNotFoundException;
import com.brewedbros.app.security.ApplicationUserDetails;
import com.brewedbros.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    @Autowired
    private UserService service;

    @GetMapping("/me")
    public UserDto currentUser(@AuthenticationPrincipal ApplicationUserDetails
                                       userDetails) {
        User user = service.getUser(userDetails.getUserId())
  .orElseThrow(() -> new UserNotFoundException(userDetails
                .getUserId()));
        return UserDto.fromUser(user);
    }
}
