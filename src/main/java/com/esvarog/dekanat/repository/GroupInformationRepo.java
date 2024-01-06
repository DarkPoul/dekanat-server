package com.esvarog.dekanat.repository;

import com.esvarog.dekanat.entity.Faculties;
import com.esvarog.dekanat.entity.GroupInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupInformationRepo extends JpaRepository<GroupInformation, Integer> {

    GroupInformation findByGroupName(String s);

    List<GroupInformation> findAllByFaculty(Faculties faculty);
}
