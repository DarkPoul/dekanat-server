package com.esvarog.dekanat.repository;

import com.esvarog.dekanat.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentsRepo extends JpaRepository<Departments, Integer> {

    Optional<Departments> findByDepartmentName(String title);
}
