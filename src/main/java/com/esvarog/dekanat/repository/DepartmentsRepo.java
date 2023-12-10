package com.esvarog.dekanat.repository;

import com.esvarog.dekanat.entity.Departments;
import com.esvarog.dekanat.entity.Disciplines;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentsRepo extends JpaRepository<Departments, Integer> {

    Departments findByDepartmentName(String title);
}
