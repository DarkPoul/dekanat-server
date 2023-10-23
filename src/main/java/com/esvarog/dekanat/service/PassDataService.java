package com.esvarog.dekanat.service;

import com.esvarog.dekanat.entity.PassData;
import com.esvarog.dekanat.repository.PassDataRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PassDataService {

    private final PassDataRepo passDataRepo;

    public PassDataService(PassDataRepo passDataRepo) {
        this.passDataRepo = passDataRepo;
    }


    public Integer count() {
        return (int) this.passDataRepo.count();
    }

    public void save(PassData passData) {
        this.passDataRepo.save(passData);
    }
}
