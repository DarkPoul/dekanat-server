package com.esvarog.dekanat.controller;

import com.esvarog.dekanat.service.AuthService;
import com.esvarog.dekanat.entity.Result;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AuthController {
    // This class is responsible for authentication

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public Result getLoginInfo(Authentication authentication) {
        return new Result(true, 200, "Login successful", this.authService.getLoginInfo(authentication));
    }

}
