package com.esvarog.dekanat.repository;

import com.esvarog.dekanat.entity.StudentGroup;
import com.esvarog.dekanat.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentsRepo extends JpaRepository<Students, Integer> {
    // метод пошуку студентів групи по id групи

}
