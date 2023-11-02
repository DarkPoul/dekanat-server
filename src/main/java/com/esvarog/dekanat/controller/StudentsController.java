package com.esvarog.dekanat.controller;

import com.esvarog.dekanat.entity.Result;
import com.esvarog.dekanat.entity.Students;
import com.esvarog.dekanat.service.StudentsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class StudentsController {

    private final StudentsService studentsService;

    //метод додавання нового студента
    @PostMapping("/student")
    public Result addStudent(@RequestBody Students student) {
        System.out.println(student.toString());
        studentsService.addStudent(student);
        return new Result(true, 200, "Студента додано");
    }

    // метод оновлення інформації про студента по id
    @PutMapping("/student/{id}")
    public Result updateStudent(@RequestBody Students student, @PathVariable Integer id) {
        student.setStudentId(id);
        studentsService.updateStudent(student);
        return new Result(true, 200, "Інформацію про студента оновлено");
    }

    // метод отримання інформації про студента по id
    @GetMapping("/student/{id}")
    public Result getStudent(@PathVariable Integer id) {
        return new Result(true, 200, "Інформацію про студента отримано", studentsService.findStudentById(id));
    }

    // метод отримання усіх студентів
    @GetMapping("/student")
    public Result getAllStudents() {
        return new Result(true, 200, "Інформацію про студентів отримано", studentsService.findAllStudents());
    }

    // метод видалення студента по id
    @DeleteMapping("/student/{id}")
    public Result deleteStudent(@PathVariable Integer id) {
        studentsService.deleteStudent(id);
        return new Result(true, 200, "Студента видалено");
    }

}
