package com.esvarog.dekanat.service;

import com.esvarog.dekanat.entity.GroupInformation;
import com.esvarog.dekanat.entity.StudentGroup;
import com.esvarog.dekanat.repository.StudentGroupRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentGroupService {

    private final StudentGroupRepo studentGroupRepo;
    private final GroupInformationService groupInformationService;

    public StudentGroupService(StudentGroupRepo studentGroupRepo, GroupInformationService groupInformationService) {
        this.studentGroupRepo = studentGroupRepo;

        this.groupInformationService = groupInformationService;
    }

    //метод додавання нової групи
    public StudentGroup addGroup(StudentGroup group) {
        return studentGroupRepo.save(group);
    }
    //метод оновлення інформації про групу по id
    public StudentGroup updateGroup(StudentGroup group) {
        return studentGroupRepo.save(group);
    }

    //метод отримання інформації про групу по id
    public List<StudentGroup> getGroup(Integer id) {
        GroupInformation groupInformation = groupInformationService.getGroupInformation(id);
        return studentGroupRepo.findByGroupInformation(groupInformation);
    }

    //метод отримання усіх груп
    public Iterable<StudentGroup> getAllGroups() {
        return studentGroupRepo.findAll();
    }

    //метод видалення групи по id
    public void deleteGroup(Integer id) {
        studentGroupRepo.deleteById(id);
    }
}
