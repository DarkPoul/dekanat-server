package com.esvarog.dekanat.service;

import com.esvarog.dekanat.dto.DiplomaDTO;
import com.esvarog.dekanat.entity.Diploma;
import com.esvarog.dekanat.repository.DiplomaRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DiplomaService {

    private final DiplomaRepo diplomaRepo;

    public Diploma create(DiplomaDTO dto){
        return diplomaRepo.save(Diploma.builder()
                        .date(dto.getDate())
                        .grade(dto.getGrade())
                        .title(dto.getTitle())
                .build());
    }

    public List<Diploma> reed(){
        return diplomaRepo.findAll();
    }

    public Diploma reed(Long id){
        return diplomaRepo.findById(id).orElseThrow(() -> new RuntimeException("Diploma not found, id -> " + id));
    }

    public Diploma update(Diploma diploma) {
        return diplomaRepo.save(diploma);
    }

    public void delete(Long id){
        diplomaRepo.deleteById(id);
    }

}
