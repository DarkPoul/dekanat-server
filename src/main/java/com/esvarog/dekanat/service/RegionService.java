package com.esvarog.dekanat.service;

import com.esvarog.dekanat.entity.Regions;
import com.esvarog.dekanat.repository.RegionsRepo;
import org.springframework.stereotype.Service;

@Service
public class RegionService {

    private final RegionsRepo regionsRepo;

    public RegionService(RegionsRepo regionsRepo) {
        this.regionsRepo = regionsRepo;
    }

    //метод створення регіонів
    public Regions create(Regions regions) {
        return this.regionsRepo.save(regions);
    }

    //метод для перевірки чи регіони взагалі існують
    public boolean isRegionsExist() {
        return this.regionsRepo.count() > 0;
    }

    //метод для перевірки регіону за його назвою
    public boolean isRegionsExistByName(String regionName) {
        return this.regionsRepo.existsByRegionName(regionName);
    }

    //метод для отримання регіону за його id
    public Regions findRegionById(Integer id) {
        return this.regionsRepo.findById(id).orElse(null);
    }


    public Regions getRegionByName(String Name) {
        return this.regionsRepo.findByRegionName(Name);
    }
}
