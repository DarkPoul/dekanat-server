package com.esvarog.dekanat.controller;

import com.esvarog.dekanat.model.LoginRequest;
import com.esvarog.dekanat.model.LoginResponse;
import com.esvarog.dekanat.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest request){
        return authService.attemptLogin(request.getUsername(), request.getPassword());
    }
}
