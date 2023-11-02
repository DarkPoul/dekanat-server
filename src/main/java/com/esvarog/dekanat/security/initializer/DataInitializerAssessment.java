package com.esvarog.dekanat.security.initializer;

import com.esvarog.dekanat.entity.AssessmentTypes;
import com.esvarog.dekanat.service.AssessmentTypesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DataInitializerAssessment{
 private final AssessmentTypesService assessmentTypesService;

    public void init(){
        List<String> assessmentType =
                List.of(
                        "Залік",
                        "Екзамен",
                        "Диференційований залік",
                        "Курсова робота",
                        "Курсовий проект",
                        "Розрахункова робота",
                        "Розрахунково-графічна робота"
                );
        if (!this.assessmentTypesService.isAssessmentTypesExist()) {
            for (String s : assessmentType) {
                AssessmentTypes assessmentTypes = AssessmentTypes.builder()
                        .assessmentName(s)
                        .assessmentForm("First Form")
                        .build();
                this.assessmentTypesService.create(assessmentTypes);
            }
        }
        for (String s : assessmentType) {
            if (!this.assessmentTypesService.isAssessmentTypesExist(s)) {
                AssessmentTypes assessmentTypes = AssessmentTypes.builder()
                        .assessmentName(s)
                        .assessmentForm("First Form")
                        .build();
                this.assessmentTypesService.create(assessmentTypes);
            }
        }
    }
}