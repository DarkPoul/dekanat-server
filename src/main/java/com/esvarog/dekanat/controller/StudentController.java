package com.esvarog.dekanat.controller;

import com.esvarog.dekanat.converter.StudentDtoToStudentConverter;
import com.esvarog.dekanat.converter.StudentToStudentDtoConverter;
import com.esvarog.dekanat.dto.StudentDTO;
import com.esvarog.dekanat.entity.Result;
import com.esvarog.dekanat.entity.Student;
import com.esvarog.dekanat.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;
    private final StudentDtoToStudentConverter studentDtoToStudentConverter;
    private final StudentToStudentDtoConverter studentToStudentDtoConverter;

    public StudentController(StudentService studentService, StudentDtoToStudentConverter studentDtoToStudentConverter, StudentToStudentDtoConverter studentToStudentDtoConverter) {
        this.studentService = studentService;
        this.studentDtoToStudentConverter = studentDtoToStudentConverter;
        this.studentToStudentDtoConverter = studentToStudentDtoConverter;
    }

    @GetMapping(path = "/student/{id}")
    public Result findStudentById(@PathVariable String id) {
        Student student = this.studentService.findById(id);
        return new Result(true, 200, "success get user info", student);
    }

    @GetMapping(path = "/student")
    public Result findAllStudents() {
        List<Student> students = this.studentService.findAll();
//        students.stream().map(student -> this) TODO: add dto converter
        return new Result(true, 200, "success get user info", students);
    }

    @PostMapping(path = "/student")
    public Result addStudent(@RequestBody StudentDTO studentDTO) {
        Student newStudent = this.studentDtoToStudentConverter.convert(studentDTO);
        Student savedStudent = this.studentService.save(newStudent);
        StudentDTO student = this.studentToStudentDtoConverter.convert(savedStudent);
        return new Result(true, 200, "success add user", student);
    }

    @PutMapping(path = "/student/{id}")
    public Result updateStudent(@PathVariable String id, @RequestBody StudentDTO studentDTO) {
        Student update = this.studentDtoToStudentConverter.convert(studentDTO);
        Student updateStudent = this.studentService.update(id, update);
        StudentDTO updatedStudentDto = this.studentToStudentDtoConverter.convert(updateStudent);
        return new Result(true, 200, "success update user", updatedStudentDto);
    }

    @DeleteMapping(path = "/student/{id}")
    public Result deleteStudent(@PathVariable String id) {
        this.studentService.delete(id);
        return new Result(true, 200, "success delete user");
    }

    @GetMapping(path = "/student/add_test")
    public Result addTestStudent(){
        Student student = new Student();
        student.setId(1L);
        student.setFirstName("Іван");
        student.setLastName("Іванов");
        student.setSurName("Іванович");
        student.setDateOfBirth(Date.valueOf("2000-11-11"));
        student.setFirstNameEng("Ivan");
        student.setLastNameEng("Ivanov");
        student.setAddress("вул. Іванова, 1");
        student.setEmail("test1@test.com");
        student.setPhoneNumber("+380000000000");
        Student savedStudent = this.studentService.save(student);
        StudentDTO studentDTO = this.studentToStudentDtoConverter.convert(savedStudent);
        Student student2 = new Student();
        student2.setId(2L);
        student2.setFirstName("Петро");
        student2.setLastName("Петров");
        student2.setSurName("Петрович");
        student2.setDateOfBirth(Date.valueOf("2000-11-11"));
        student2.setFirstNameEng("Petro");
        student2.setLastNameEng("Petrov");
        student2.setAddress("вул. Петрова, 1");
        student2.setEmail("test@test.com");
        student2.setPhoneNumber("+380000000000");
        Student savedStudent2 = this.studentService.save(student2);
        StudentDTO studentDTO2 = this.studentToStudentDtoConverter.convert(savedStudent2);


        return new Result(true, 200, "success add user", List.of(studentDTO, studentDTO2));
    }
}
