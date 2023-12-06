package com.esvarog.dekanat.repository;

import com.esvarog.dekanat.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {
    Users findByUsername(String username);

    Users findByToken(String token);
}
