package com.esvarog.dekanat.service;

import com.esvarog.dekanat.dto.StudentDTO;
import com.esvarog.dekanat.entity.Districts;
import com.esvarog.dekanat.entity.Student;
import com.esvarog.dekanat.repository.StudentRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepo studentRepo;
    private final DistrictService districtService;
    private final PreEduService preEduService;
    private final GroupService groupService;

    public Student create(StudentDTO dto){
        return studentRepo.save(Student.builder()
                .firstName(dto.getFirstName())
                .firstNameEng(dto.getFirstName_eng())
                .lastName(dto.getLastName())
                .lastNameEng(dto.getLastName_eng())
                .surName(dto.getSurName())
                .dateOfBirth(dto.getDateOfBirth())
                .address(dto.getAddress())
                .districts(districtService.readById(dto.getDistrict().getId()))
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .applicantCardNumber(dto.getApplicant_card_number())
                .numberOfTheRecordBook(dto.getNumber_of_the_record_book())
                .contractNumber(dto.getContract_number())
                .cardNumberOfAnIndividual(dto.getCard_number_of_an_individual())
                .previousEducation(preEduService.reedByIdOrCreate(dto.getPreviousEducation().getId(),
                        dto.getPreviousEducation().getDateOfGraduation().toString(),
                            dto.getPreviousEducation().getSchoolName(),
                            dto.getPreviousEducation().getSerialOfDocument(),
                            dto.getPreviousEducation().getTypeOfDocument()))
                .group(groupService.reedById(dto.getGroup().getId()))


//              private Passport passport;
//              private DiplomaInfo diplomaInfo;
//              private List<Orders> orders;
                .build());
    }
    public List<Student> reedAll(){
        return studentRepo.findAll();
    }

    public Student reedById(Long id){
        return studentRepo.findById(id).orElseThrow(() ->
                new RuntimeException("Student not found - " + id));
    }

    public Student update(Student student) {
        return studentRepo.save(student);
    }

    public void delete(Long id) {
        studentRepo.deleteById(id);
    }

    public List<Student> readByDistrictId(Districts districts) {
        return studentRepo.findByDistrictsId(districts);
    }


}
