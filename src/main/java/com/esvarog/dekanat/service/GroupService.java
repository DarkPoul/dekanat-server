package com.esvarog.dekanat.service;

import com.esvarog.dekanat.dto.GroupDTO;
import com.esvarog.dekanat.entity.StudentGroup;
import com.esvarog.dekanat.repository.GroupRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GroupService {
    private final GroupRepo groupRepo;

    public StudentGroup create(GroupDTO dto){
        return groupRepo.save(StudentGroup.builder()
                        .admissionYear(dto.getAdmissionYear())
                        .courseNumber(dto.getCourseNumber())
                        .groupNumber(dto.getGroupNumber())
                        .specialtyAbbreviation(dto.getSpecialtyAbbreviation())
                        .formOfStudy(dto.getFormOfStudy())
                .build());
    }

    public List<StudentGroup> reedAll(){
        return groupRepo.findAll();
    }

    public StudentGroup reedById(Long id){
        return groupRepo.findById(id).orElseThrow(() -> new RuntimeException("Group not found - " + id));
    }

    public StudentGroup update(StudentGroup studentGroup){
        return groupRepo.save(studentGroup);
    }

    public void delete(Long id) {
        groupRepo.deleteById(id);
    }
}
