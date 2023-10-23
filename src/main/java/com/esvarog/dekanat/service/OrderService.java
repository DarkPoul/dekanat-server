package com.esvarog.dekanat.service;

import com.esvarog.dekanat.entity.OrderStudent;
import com.esvarog.dekanat.repository.OrderStudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderService {

    private final OrderStudentRepo orderStudentRepo;

    public OrderService(OrderStudentRepo orderStudentRepo) {
        this.orderStudentRepo = orderStudentRepo;
    }


    public void save(OrderStudent orderStudent) {
        this.orderStudentRepo.save(orderStudent);
    }
}
