package com.esvarog.dekanat.service;

import com.esvarog.dekanat.entity.Student;
import com.esvarog.dekanat.repository.StudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StudentService {

    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student findById(String id) {
        return this.studentRepo.findById(id).orElseThrow();
    }

    public List<Student> findAll() {
        return this.studentRepo.findAll();
    }

    public Student save(Student newStudent) {
        newStudent.setId((int) (this.studentRepo.count() + 1));
        return this.studentRepo.save(newStudent);
    }

    public Student update(String studentId, Student update){
        return this.studentRepo.findById(studentId)
                .map(oldStudent -> {
                    oldStudent.setFirstName(update.getFirstName());
                    oldStudent.setSurname(update.getSurname());
                    oldStudent.setLastName(update.getLastName());

                    oldStudent.setFirstNameEng(update.getFirstNameEng());
                    oldStudent.setLastNameEng(update.getLastNameEng());

                    oldStudent.setApplicantCardNumber(update.getApplicantCardNumber());
                    oldStudent.setNumberOfTheRecordBook(update.getNumberOfTheRecordBook());
                    oldStudent.setContractNumber(update.getContractNumber());
                    oldStudent.setCardNumberOfTheIndividual(update.getCardNumberOfTheIndividual());

                    oldStudent.setPassData(update.getPassData());
                    oldStudent.setPriorEducation(update.getPriorEducation());
                    oldStudent.setOrderStudent(update.getOrderStudent());

                    oldStudent.setEmail(update.getEmail());
                    oldStudent.setPhoneNumber(update.getPhoneNumber());

                    return this.studentRepo.save(oldStudent);
        }).orElseThrow();
    }

    public void delete(String id) {
        this.studentRepo.findById(id).orElseThrow();
        this.studentRepo.deleteById(id);

    }


    public Integer count() {
        return (int) this.studentRepo.count();
    }
}
