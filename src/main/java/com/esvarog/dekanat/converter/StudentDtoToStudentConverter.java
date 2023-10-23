package com.esvarog.dekanat.converter;

import com.esvarog.dekanat.dto.StudentDTO;
import com.esvarog.dekanat.entity.Student;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StudentDtoToStudentConverter implements Converter<StudentDTO, Student> {
    @Override
    public Student convert(StudentDTO source) {
        Student student = new Student();
        student.setId(source.getId());

        student.setFirstName(source.getFirstName());
        student.setSurname(source.getSurName());
        student.setLastName(source.getLastName());

        student.setFirstNameEng(source.getFirstNameEng());
        student.setLastNameEng(source.getLastNameEng());

        student.setApplicantCardNumber(source.getApplicantCardNumber());
        student.setNumberOfTheRecordBook(source.getNumberOfTheRecordBook());
        student.setContractNumber(source.getContractNumber());
        student.setCardNumberOfTheIndividual(source.getCardNumberOfAnIndividual());

        student.setPhoneNumber(source.getPhoneNumber());
        student.setEmail(source.getEmail());

        student.setPassData(source.getPassData());
        student.setPriorEducation(source.getPriorEducation());
        student.setOrderStudent(source.getOrderStudent());

        return student;
    }
}
