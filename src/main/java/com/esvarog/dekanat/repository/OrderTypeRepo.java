package com.esvarog.dekanat.repository;

import com.esvarog.dekanat.entity.OrderType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderTypeRepo extends JpaRepository<OrderType, Integer> {

    boolean existsByOrderTitle(String orderTitle);
}
