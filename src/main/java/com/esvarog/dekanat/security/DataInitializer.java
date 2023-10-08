package com.esvarog.dekanat.security;

import com.esvarog.dekanat.entity.Users;
import com.esvarog.dekanat.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final UserService userService;

    public DataInitializer(UserService userService) {
        this.userService = userService;
    }

    public void init() {
        try{
            this.userService.loadUserByUsername("admin");
        } catch (Exception e) {
            Users newUser = Users.builder()
                    .username("admin")
                    .password("admin")
                    .role("ROLE_ADMIN")
                    .enabled(true)
                    .build();
            this.userService.create(newUser);
        }
    }
}
