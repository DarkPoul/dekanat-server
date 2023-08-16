package com.esvarog.dekanat.controller;

import com.esvarog.dekanat.dto.StudentDTO;
import com.esvarog.dekanat.entity.Student;
import com.esvarog.dekanat.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/student/create")
    public ResponseEntity<Student> create(@RequestBody StudentDTO dto){
        return new ResponseEntity<>(studentService.create(dto), HttpStatus.OK);
    }

    @GetMapping("/student/readAll")
    public ResponseEntity<List<Student>> reed(){
        return new ResponseEntity<>(studentService.reedAll(), HttpStatus.OK);
    }

    @GetMapping("/student/readByID/{id}")
    public ResponseEntity<Student> reedById(@PathVariable Long id){
        return new ResponseEntity<>(studentService.reedById(id), HttpStatus.OK);
    }

    @PutMapping("/student/update")
    public ResponseEntity<Student> update(@RequestBody Student student){
        return new ResponseEntity<>(studentService.update(student), HttpStatus.OK);
    }
    @DeleteMapping("/student/delete/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        studentService.delete(id);
        return HttpStatus.OK;
    }

}
