package com.esvarog.dekanat.converter;

import com.esvarog.dekanat.dto.StudentDTO;
import com.esvarog.dekanat.entity.Student;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StudentToStudentDtoConverter implements Converter<Student, StudentDTO> {
    @Override
    public StudentDTO convert(Student source) {
        return new StudentDTO(
                source.getId(),
                source.getFirstName(),
                source.getLastName(),
                source.getSurName(),
                source.getDateOfBirth().toString(),
                source.getFirstNameEng(),
                source.getLastNameEng(),
                source.getAddress(),
                source.getEmail(),
                source.getPhoneNumber()
        );
    }
}
