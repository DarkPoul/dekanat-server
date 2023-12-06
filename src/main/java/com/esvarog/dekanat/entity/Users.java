package com.esvarog.dekanat.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;

import java.time.Instant;

@Entity
@Data
@Builder
@NoArgsConstructor
@Transactional
@AllArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean enabled;
    private String password;
    private String role;
    private String username;
    private String token;
    private Instant tokenExpire;

}
