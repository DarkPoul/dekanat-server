package com.esvarog.dekanat.service;

import com.esvarog.dekanat.entity.Departments;
import com.esvarog.dekanat.repository.DepartmentsRepo;
import org.springframework.stereotype.Service;

@Service
public class DepartmentsService {

    private final DepartmentsRepo departmentsRepo;

    public DepartmentsService(DepartmentsRepo departmentsRepo) {
        this.departmentsRepo = departmentsRepo;
    }

    public Departments create(Departments departments) {
        return this.departmentsRepo.save(departments);
    }

    //Функція перевірки наявності в базі даних взагалі
    public boolean isExist() {
        return this.departmentsRepo.count() > 0;
    }

    //Функція перевірки наявності в базі даних за назвою
    public boolean isExist(String title) {
        return this.departmentsRepo.findByDepartmentName(title).isPresent();
    }
}
