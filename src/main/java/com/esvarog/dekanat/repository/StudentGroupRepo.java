package com.esvarog.dekanat.repository;

import com.esvarog.dekanat.entity.GroupInformation;
import com.esvarog.dekanat.entity.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentGroupRepo extends JpaRepository<StudentGroup, Integer> {

    List<StudentGroup> findByGroupInformation(GroupInformation groupInformation);
}
