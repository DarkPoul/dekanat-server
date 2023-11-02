package com.esvarog.dekanat.repository;

import com.esvarog.dekanat.entity.GroupInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupInformationRepo extends JpaRepository<GroupInformation, Integer> {

    GroupInformation findByGroupName(String s);
}
