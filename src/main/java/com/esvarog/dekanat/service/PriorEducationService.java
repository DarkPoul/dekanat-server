package com.esvarog.dekanat.service;

import com.esvarog.dekanat.entity.PriorEducation;
import com.esvarog.dekanat.repository.PriorEducationRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PriorEducationService {

    private final PriorEducationRepo priorEducationRepo;

    public PriorEducationService(PriorEducationRepo priorEducationRepo) {
        this.priorEducationRepo = priorEducationRepo;
    }


    public Integer count() {
        return (int) this.priorEducationRepo.count();
    }

    public void save(PriorEducation priorEducation) {
        this.priorEducationRepo.save(priorEducation);
    }
}
