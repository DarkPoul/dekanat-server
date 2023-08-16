package com.esvarog.dekanat.repository;

import com.esvarog.dekanat.entity.Districts;
import com.esvarog.dekanat.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo  extends JpaRepository<Student, Long> {
    Optional<Student> findStudentByFirstName(String firstName);
    List<Student> findByDistrictsId(Districts districts);
}
