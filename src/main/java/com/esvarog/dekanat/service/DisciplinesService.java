package com.esvarog.dekanat.service;

import com.esvarog.dekanat.entity.Departments;
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
        if (isDisciplineExists(discipline.getDisciplineName())){
            System.out.println("Discipline exists");
            discipline.setDisciplineId(getDisciplineIdByName(discipline.getDisciplineName()));
            disciplinesRepository.save(discipline);
        }else {
            System.out.println("Discipline doesn't exist");
            discipline.setDisciplineId((int) disciplinesRepository.count()+1);
            disciplinesRepository.save(discipline);
        }
    }

    //id дисципліни по назві
    public int getDisciplineIdByName(String disciplineName) {
        return disciplinesRepository.findByDisciplineName(disciplineName).getDisciplineId();
    }

    //Чи дмсципліна з такою назвою існує
    public boolean isDisciplineExists(String disciplineName) {
        return disciplinesRepository.findByDisciplineName(disciplineName) != null;
    }


}
