package com.esvarog.dekanat.security.initializer;

import com.esvarog.dekanat.entity.Users;
import com.esvarog.dekanat.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataInitializerUser {
    private final UserService userService;

    public void init() {
        try {
            // Try to load the user by username
            this.userService.loadUserByUsername("admin");
        } catch (UsernameNotFoundException e) {
            // If the user is not found, create a new user
            Users admin = new Users();
            admin.setUsername("admin");
            admin.setPassword("admin");
            admin.setRole("ADMIN");
            admin.setEnabled(true);

            // Create the user using the create method
            this.userService.create(admin);
        }
    }
}
