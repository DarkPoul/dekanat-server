package com.esvarog.dekanat.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String username;
    private String password;
    private boolean enabled;
    private String role;
}
