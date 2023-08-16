package com.esvarog.dekanat.repository;

import com.esvarog.dekanat.entity.PreviousEducation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PreEduRepo extends JpaRepository<PreviousEducation, Long> {
}
