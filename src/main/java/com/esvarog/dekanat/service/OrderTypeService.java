package com.esvarog.dekanat.service;

import com.esvarog.dekanat.entity.OrderType;
import com.esvarog.dekanat.repository.OrderTypeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderTypeService {

    private final OrderTypeRepo orderTypeRepo;

    //метод створення
    public OrderType create(OrderType orderType) {
        return this.orderTypeRepo.save(orderType);
    }
    //метод оновлення
    public OrderType update(OrderType orderType) {
        return this.orderTypeRepo.save(orderType);
    }
    //метод видалення
    public void delete(OrderType orderType) {
        this.orderTypeRepo.delete(orderType);
    }
    //метод для перевірки чи існує
    public boolean isOrderTypeExist() {
        return this.orderTypeRepo.count() > 0;
    }
    //метод для перевірки за назвою
    public boolean isOrderTypeExistByTitle(String orderTitle) {
        return this.orderTypeRepo.existsByOrderTitle(orderTitle);
    }
    //метод для отриання всіх
    public Iterable<OrderType> getAll() {
        return this.orderTypeRepo.findAll();
    }
    //метод для отримання за id
    public OrderType getById(Integer id) {
        return this.orderTypeRepo.findById(id).orElse(null);
    }


}
