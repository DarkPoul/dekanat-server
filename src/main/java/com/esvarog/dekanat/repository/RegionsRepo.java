package com.esvarog.dekanat.repository;

import com.esvarog.dekanat.entity.Regions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionsRepo extends JpaRepository<Regions, Integer> {
    boolean existsByRegionName(String regionName);

    Regions findByRegionName(String name);
}
