package com.esvarog.dekanat.repository;

import com.esvarog.dekanat.entity.EducationDocumentTypes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EducationDocumentTypesRepo extends JpaRepository<EducationDocumentTypes, Integer> {
    //Функція пошуку типу документу за назвою
    Optional<EducationDocumentTypes> findByTypeNameUkr(String title);
    EducationDocumentTypes findByDocumentTypeId(int i);
}
