package com.esvarog.ua.Dekanat.admin_panel;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class create_pass{
    public create_pass(String pass){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(pass);

        System.out.println("Ваш пароль: " + encodedPassword);
    }

}

