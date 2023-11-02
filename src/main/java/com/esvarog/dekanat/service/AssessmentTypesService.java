package com.esvarog.dekanat.service;

import com.esvarog.dekanat.entity.AssessmentTypes;
import com.esvarog.dekanat.repository.AssessmentTypesRepo;
import org.springframework.stereotype.Service;

@Service
public class AssessmentTypesService {

    private final AssessmentTypesRepo assessmentTypesRepo;

    public AssessmentTypesService(AssessmentTypesRepo assessmentTypesRepo) {
        this.assessmentTypesRepo = assessmentTypesRepo;
    }

    public AssessmentTypes create(AssessmentTypes assessmentTypes) {
        return assessmentTypesRepo.save(assessmentTypes);
    }

    //метод для перевірки чи існують взагалі типи оцінювання
    public boolean isAssessmentTypesExist() {
        return assessmentTypesRepo.count() > 0;
    }

    //метод для перевірки чи існує тип оцінювання з такою назвою
    public boolean isAssessmentTypesExist(String title) {
        return assessmentTypesRepo.findByAssessmentName(title).isPresent();
    }
}
