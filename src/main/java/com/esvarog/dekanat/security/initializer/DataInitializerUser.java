package com.esvarog.dekanat.security.initializer;

import com.esvarog.dekanat.entity.Users;
import com.esvarog.dekanat.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataInitializerUser{
    private final UserService userService;

    public void init(){
        try {
            this.userService.loadUserByUsername("admin");
        } catch (UsernameNotFoundException e){
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
