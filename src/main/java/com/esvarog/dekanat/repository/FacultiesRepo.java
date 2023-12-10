package com.esvarog.dekanat.repository;

import com.esvarog.dekanat.entity.Faculties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultiesRepo extends JpaRepository<Faculties, Integer> {
    //метод для перевірки факультету за його назвою
    boolean existsByFacultyName(String facultyName);

    Faculties findByFacultyId(Integer s);

    Faculties findByFacultyName(String name);
}
