package com.esvarog.dekanat.service;

import com.esvarog.dekanat.entity.Faculties;
import com.esvarog.dekanat.entity.GroupEntity;
import com.esvarog.dekanat.entity.GroupInformation;
import com.esvarog.dekanat.repository.GroupInformationRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupInformationService {

    private final GroupInformationRepo groupInformationRepo;
    private final FacultiesService facultiesService;

    public GroupInformationService(GroupInformationRepo groupInformationRepo, FacultiesService facultiesService) {
        this.groupInformationRepo = groupInformationRepo;
        this.facultiesService = facultiesService;
    }

    //метод пошуку інформації про групу по id
    public GroupInformation getGroupInformation(Integer id) {
        return groupInformationRepo.findById(id).orElse(null);
    }

    //метод створення інформації про групу
    public GroupInformation create(GroupInformation groupInformation) {
        return this.groupInformationRepo.save(groupInformation);
    }

    public boolean isGroupInformationExist() {
        return groupInformationRepo.count() > 0;
    }


    public boolean isGroupInformationExistByName(String groupName) {
        return groupInformationRepo.findByGroupName(groupName) != null;
    }

    public List<GroupEntity> getAllGroups() {
        List<GroupInformation> all = groupInformationRepo.findAll();
        List<GroupEntity> groupEntities = new ArrayList<>();

        for (GroupInformation groupInformation : all) {
            GroupEntity groupEntity = new GroupEntity();
            groupEntity.setId(groupInformation.getId());
            groupEntity.setGroupAbbreviation(groupInformation.getGroupAbbreviation());

            groupEntities.add(groupEntity);
        }

        return groupEntities;
    }

    public List<GroupEntity> getByFacultyId(Integer facultyId) {
        Faculties faculty = facultiesService.getFacultyByNumber(facultyId);
        List<GroupInformation> all = groupInformationRepo.findAllByFaculty(faculty);
        List<GroupEntity> groupEntities = new ArrayList<>();

        for (GroupInformation groupInformation : all) {
            GroupEntity groupEntity = new GroupEntity();
            groupEntity.setId(groupInformation.getId());
            groupEntity.setGroupAbbreviation(groupInformation.getGroupAbbreviation());

            groupEntities.add(groupEntity);
        }

        return groupEntities;
    }
}
