package com.esvarog.dekanat.service;

import com.esvarog.dekanat.entity.GroupInformation;
import com.esvarog.dekanat.repository.GroupInformationRepo;
import org.springframework.stereotype.Service;

@Service
public class GroupInformationService {

    private final GroupInformationRepo groupInformationRepo;

    public GroupInformationService(GroupInformationRepo groupInformationRepo) {
        this.groupInformationRepo = groupInformationRepo;
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
}
