package com.esvarog.dekanat.controller;

import com.esvarog.dekanat.entity.*;
import com.esvarog.dekanat.service.EducationDocumentTypesService;
import com.esvarog.dekanat.service.FacultiesService;
import com.esvarog.dekanat.service.RegionService;
import com.esvarog.dekanat.service.StudentsService;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@RestController
@AllArgsConstructor
public class StudentsController {

    private final StudentsService studentsService;
    private final RegionService regionService;
    private final FacultiesService facultiesService;
    private final EducationDocumentTypesService educationDocumentTypesService;

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

    // метод додавання деякої кількості тестових студентів
    @PostMapping("/student/test/{count}")
    public Result addTestStudents(@PathVariable Integer count) {


        while (count > 0){

            Faker faker = new Faker(new Locale("uk"));
            Regions regions = regionService.findRegionById(new Random().nextInt(25) + 1);
            Faculties faculties = facultiesService.getFacultyByNumber(new Random().nextInt(5) + 1);
            EducationDocumentTypes educationDocumentTypes = educationDocumentTypesService.getEducationDocumentTypeByNumber(new Random().nextInt(5) + 1);

            List<String> city =
                    List.of(
                            "Ukrainian",
                            "Foreign"
                    );


            Students student = Students.builder()
                .firstNameUkr(faker.name().firstName())
                .lastNameUkr(faker.name().lastName())
                .patronymic(faker.name().lastName())
                .firstNameEng(faker.name().firstName())
                .lastNameEng(faker.name().lastName())
                .dateOfBirth(Date.valueOf("1999-01-01"))
                .gender(faker.demographic().sex())
                .email(faker.internet().emailAddress())
                .phoneNumber(faker.phoneNumber().phoneNumber())
                .region(regions)
                .address(faker.address().fullAddress())
                .faculty(faculties)
                .passportNumber(faker.idNumber().valid())
                .passportIssuedBy(faker.company().name())
                .passportIssueDate(Date.valueOf("2010-01-01"))
                .passportExpiryDate(Date.valueOf("2020-01-01"))
                .passportRegistrationNumber(faker.idNumber().valid())
//                .citizenship(city.get(new Random().nextInt(2)))
                .identificationNumber(faker.idNumber().valid())
                .contractNumber(faker.idNumber().valid())
                .studentCardNumber(faker.idNumber().valid())
                .recordBookNumber(faker.idNumber().valid())
                .educationDocumentType(educationDocumentTypes)
                .educationDocumentSeries(faker.idNumber().valid())
                .educationDocumentNumber(faker.idNumber().valid())
                .educationDocumentIssueDate(Date.valueOf("2010-01-01"))
                .educationDocumentIssuePlaceUkr(faker.company().name())
                .educationDocumentIssuePlaceEng(faker.company().name())
                .build();
            studentsService.addStudent(student);
            count--;
        }
        return new Result(true, 200, "Тестових студентів додано");
    }

}
