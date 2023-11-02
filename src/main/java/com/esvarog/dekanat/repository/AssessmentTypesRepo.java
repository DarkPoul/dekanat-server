package com.esvarog.dekanat.repository;

import com.esvarog.dekanat.entity.AssessmentTypes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssessmentTypesRepo extends JpaRepository<AssessmentTypes, Integer> {
    Optional<AssessmentTypes> findByAssessmentName(String title);
}
