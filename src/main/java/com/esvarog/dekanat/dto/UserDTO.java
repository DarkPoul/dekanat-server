package com.esvarog.dekanat.dto;

import lombok.Data;



@Data
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private boolean enabled;
    private String role;

    public UserDTO() {
    }

    public UserDTO(Long id, String username, boolean enabled, String role) {
        this.id = id;
        this.username = username;
        this.enabled = enabled;
        this.role = role;
    }
}
