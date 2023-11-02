package com.esvarog.dekanat.security.initializer;

import com.esvarog.dekanat.entity.OrderType;
import com.esvarog.dekanat.service.OrderTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DataInitializerOrder {
    private final OrderTypeService orderTypeService;
    
    public void init(){
        List<String> orderTypes =
                List.of(
                        "Змінено фінансування",
                        "Переведено",
                        "Надано повторне навчання",
                        "Поновлено на повторне навчання",
                        "Поновлено",
                        "Надано академвідпустку",
                        "Повернено з академвідпустки",
                        "Продовжено академвідпустку",
                        "Надано декретну відпустку",
                        "Повернено з декретної відпустки",
                        "Продовжено декретну відпустку",
                        "Завершено навчання",
                        "Достроково завершено навчання",
                        "Відраховано із ЗО"

                );

        if (!this.orderTypeService.isOrderTypeExist()) {
            for (String s : orderTypes) {
                OrderType orderType = OrderType.builder()
                        .orderTitle(s)
                        .build();
                this.orderTypeService.create(orderType);
            }
        }
        for (String s : orderTypes) {
            if (!this.orderTypeService.isOrderTypeExistByTitle(s)) {
                OrderType orderType = OrderType.builder()
                        .orderTitle(s)
                        .build();
                this.orderTypeService.create(orderType);
            }
        }
    }
}