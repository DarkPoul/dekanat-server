package com.esvarog.dekanat.repository;

import com.esvarog.dekanat.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepo extends JpaRepository<Passport, Long> {
}
