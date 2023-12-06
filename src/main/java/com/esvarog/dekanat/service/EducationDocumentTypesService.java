package com.esvarog.dekanat.service;

import com.esvarog.dekanat.entity.EducationDocumentTypes;
import com.esvarog.dekanat.repository.EducationDocumentTypesRepo;
import org.springframework.stereotype.Service;

@Service
public class EducationDocumentTypesService {

    private final EducationDocumentTypesRepo educationDocumentTypesRepo;

    public EducationDocumentTypesService(EducationDocumentTypesRepo educationDocumentTypesRepo) {
        this.educationDocumentTypesRepo = educationDocumentTypesRepo;
    }

    //функція створення нового типу документу
    public EducationDocumentTypes create(EducationDocumentTypes educationDocumentTypes) {
        return educationDocumentTypesRepo.save(educationDocumentTypes);
    }

    //Функція перевірки наявності типів документів в базі даних в загалі
    public boolean isExist() {
        return educationDocumentTypesRepo.count() > 0;
    }

    //Функція перевірки наявності типів документів в базі даних за назвою
    public boolean isExist(String title) {
        return educationDocumentTypesRepo.findByTypeNameUkr(title).isPresent();
    }

    public EducationDocumentTypes getEducationDocumentTypeByNumber(int i) {
        return educationDocumentTypesRepo.findByDocumentTypeId(i);
    }
}
