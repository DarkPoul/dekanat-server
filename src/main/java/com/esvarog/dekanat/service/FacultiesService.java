package com.esvarog.dekanat.service;

import com.esvarog.dekanat.entity.Faculties;
import com.esvarog.dekanat.repository.FacultiesRepo;
import org.springframework.stereotype.Service;

@Service
public class FacultiesService {
    public FacultiesRepo facultiesRepo;

    public FacultiesService(FacultiesRepo facultiesRepo) {
        this.facultiesRepo = facultiesRepo;
    }

    public Faculties create(Faculties faculties) {
        return this.facultiesRepo.save(faculties);
    }

    //метод для перевірки чи факультети взагалі існують
    public boolean isFacultiesExist() {
        return this.facultiesRepo.count() > 0;
    }

    //метод для перевірки факультету за його назвою
    public boolean isFacultiesExistByName(String facultyName) {
        return this.facultiesRepo.existsByFacultyName(facultyName);
    }

    public Faculties getFacultyByNumber(Integer s) {
        return this.facultiesRepo.findByFacultyId(s);
    }

    public Faculties getFacultyByName(String name) {
        return this.facultiesRepo.findByFacultyName(name);
    }
}
