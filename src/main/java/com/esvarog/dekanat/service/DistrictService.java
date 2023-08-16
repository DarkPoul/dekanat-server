package com.esvarog.dekanat.service;

import com.esvarog.dekanat.entity.Districts;
import com.esvarog.dekanat.repository.DistrictRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DistrictService {
    public final DistrictRepo districtRepo;

    public List<Districts> reedAll(){
        return districtRepo.findAll();
    }

    public Districts readById(Long id) {
        System.out.println("DistrictService --> ID = " + id);
        return districtRepo.findById(id).orElseThrow(() ->
                new RuntimeException("District not found - " + id));
    }
}
