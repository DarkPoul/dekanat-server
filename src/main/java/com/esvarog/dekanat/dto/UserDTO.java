package com.esvarog.dekanat.dto;

import lombok.Data;

import java.sql.Date;
import java.time.Instant;


@Data
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private boolean enabled;
    private String role;
    private int facultyId;
    private String token;
    private Instant tokenExpire;

    public UserDTO() {
    }

    public UserDTO(Long id, String username, boolean enabled, String role,int facultyId , String token, Instant tokenExpire) {
        this.id = id;
        this.username = username;
        this.enabled = enabled;
        this.role = role;
        this.facultyId = facultyId;
        this.token = token;
        this.tokenExpire = tokenExpire;
    }
}
