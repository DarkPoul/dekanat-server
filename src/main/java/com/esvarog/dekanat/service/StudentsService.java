package com.esvarog.dekanat.service;

import com.esvarog.dekanat.entity.Students;
import com.esvarog.dekanat.repository.StudentsRepo;
import org.springframework.stereotype.Service;

@Service
public class StudentsService {

    private final StudentsRepo studentsRepo;

    public StudentsService(StudentsRepo studentsRepo) {
        this.studentsRepo = studentsRepo;
    }

    //метод додавання нового студента
    public Students addStudent(Students student) {
        return studentsRepo.save(student);
    }

    // метод оновлення інформації про студента по id
    public Students updateStudent(Students student) {
        return studentsRepo.save(student);
    }

    // метод видалення студента по id
    public void deleteStudent(Integer id) {
        studentsRepo.deleteById(id);
    }

    // метод пошуку студента по id
    public Students findStudentById(Integer id) {
        return studentsRepo.findById(id).orElse(null);
    }

    // метод пошуку усіх студентів
    public Iterable<Students> findAllStudents() {
        return studentsRepo.findAll();
    }

    // метод пошуку студентів групи по id групи
    public Iterable<Students> findStudentsByGroupId(Integer id) {
        return null;
    }

}
