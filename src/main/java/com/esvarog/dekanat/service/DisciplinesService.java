package com.esvarog.dekanat.service;

import com.esvarog.dekanat.entity.Disciplines;
import com.esvarog.dekanat.repository.DisciplinesRepository;
import org.springframework.stereotype.Service;

@Service
public class DisciplinesService {

    private final DisciplinesRepository disciplinesRepository;

    public DisciplinesService(DisciplinesRepository disciplinesRepository) {
        this.disciplinesRepository = disciplinesRepository;
    }

    public void saveDiscipline(Disciplines discipline) {
        discipline.setDisciplineId((int) disciplinesRepository.count()+1);
        disciplinesRepository.save(discipline);
    }

    public int countDisciplines() {
        return (int) disciplinesRepository.count();
    }
}
