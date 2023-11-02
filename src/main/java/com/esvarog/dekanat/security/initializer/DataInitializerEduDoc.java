package com.esvarog.dekanat.security.initializer;

import com.esvarog.dekanat.entity.EducationDocumentTypes;
import com.esvarog.dekanat.service.EducationDocumentTypesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DataInitializerEduDoc {

    private final EducationDocumentTypesService educationDocumentTypesService;

    public void init(){
        List<String> typeOfDocEdu = List.of(
                "Свідоцтво про здобуття базової середньої освіти",
                "Свідоцтво про базову загальну середню освіту",
                "Свідоцтво про здобуття базової середньої освіти (для осіб з особливими освітніми потребами, зумовленими порушеннями інтелектуального розвитку)",
                "Свідоцтво про базову загальну середню освіту за спеціальною програмою",
                "Свідоцтво про здобуття повної загальної середньої освіти",
                "Атестат про повну загальну середню освіту",
                "Свідоцтво про присвоєння (підвищення) робітничої кваліфікації державного зразка",
                "Диплом кваліфікованого робітника",
                "Диплом молодшого бакалавра",
                "Диплом спеціаліста",
                "Диплом бакалавра",
                "Диплом магістра"

        );
        if (!this.educationDocumentTypesService.isExist()) {
            for (String s : typeOfDocEdu) {
                EducationDocumentTypes educationDocumentTypes = EducationDocumentTypes.builder()
                        .typeNameUkr(s)
                        .typeNameEng("Translation")
                        .build();
                this.educationDocumentTypesService.create(educationDocumentTypes);
            }
        }
        for (String s : typeOfDocEdu) {
            if (!this.educationDocumentTypesService.isExist(s)) {
                EducationDocumentTypes educationDocumentTypes = EducationDocumentTypes.builder()
                        .typeNameUkr(s)
                        .typeNameEng("Translation")
                        .build();
                this.educationDocumentTypesService.create(educationDocumentTypes);
            }
        }
    };

}