package com.esvarog.dekanat.converter;

import com.esvarog.dekanat.dto.StudentDTO;
import com.esvarog.dekanat.entity.Student;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class StudentDtoToStudentConverter implements Converter<StudentDTO, Student> {
    @Override
    public Student convert(StudentDTO source) {
        Student student = new Student();
        student.setId(source.getId());
        student.setFirstName(source.getFirstName());
        student.setLastName(source.getLastName());
        student.setSurName(source.getSurName());
        student.setDateOfBirth(Date.valueOf(source.getDateOfBirth()));
        student.setFirstNameEng(source.getFirstNameEng());
        student.setLastNameEng(source.getLastNameEng());
        student.setAddress(source.getAddress());
        student.setEmail(source.getEmail());
        student.setPhoneNumber(source.getPhoneNumber());
        return student;
    }
}
