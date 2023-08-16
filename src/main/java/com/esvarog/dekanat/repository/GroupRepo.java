package com.esvarog.dekanat.repository;

import com.esvarog.dekanat.entity.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepo extends JpaRepository<StudentGroup, Long> {
}
