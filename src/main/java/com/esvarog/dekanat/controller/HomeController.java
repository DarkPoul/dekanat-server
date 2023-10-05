package com.esvarog.dekanat.controller;

import com.esvarog.dekanat.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeController {



    @CrossOrigin
    @GetMapping("/secured")
    public String secured(@AuthenticationPrincipal UserPrincipal principal) {
        return "If you see this, then you're logged in as user " + principal.getUsername() + " User ID: " + principal.getUserId();
    }

    @CrossOrigin
    @GetMapping("/admin")
    public String admin(@AuthenticationPrincipal UserPrincipal principal){
        return "If you see this, then you are an ADMIN. User ID: " + principal.getUserId();
    }

}
