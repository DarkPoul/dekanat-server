package com.esvarog.dekanat.service;

import com.esvarog.dekanat.dto.PreEduDTO;
import com.esvarog.dekanat.entity.PreviousEducation;
import com.esvarog.dekanat.repository.PreEduRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PreEduService {
    private final PreEduRepo preEduRepo;

    public List<PreviousEducation> reedAll(){
        return preEduRepo.findAll();
    }

    public PreviousEducation create(PreEduDTO dto){
        return preEduRepo.save(PreviousEducation.builder()
                        .dateOfGraduation(Date.valueOf(dto.getDateOfGraduation()))
                        .schoolName(dto.getSchoolName())
                        .serialOfDocument(dto.getSerialOfDocument())
                        .typeOfDocument(dto.getTypeOfDocument())
                .build());
    }

    public PreviousEducation reedById(Long id){
        return preEduRepo.findById(id).orElseThrow(() ->
                new RuntimeException("Edu not found - " + id));
    }

    public PreviousEducation reedByIdOrCreate(Long id, String DateOfGraduation, String SchoolName, String SerialOfDocument, String TypeOfDocument) {
        if (preEduRepo.findById(id).isEmpty()){
            createPreEdu(DateOfGraduation, SchoolName, SerialOfDocument, TypeOfDocument);
        }
        return preEduRepo.findById(id).orElseThrow(() ->
                new RuntimeException("Edu not found - " + id));
    }

    public void createPreEdu(String DateOfGraduation, String SchoolName, String SerialOfDocument, String TypeOfDocument){
        PreEduDTO preEduDTO = new PreEduDTO();
        preEduDTO.setDateOfGraduation(DateOfGraduation);
        preEduDTO.setSchoolName(SchoolName);
        preEduDTO.setSerialOfDocument(SerialOfDocument);
        preEduDTO.setTypeOfDocument(TypeOfDocument);
        create(preEduDTO);
    }

}
