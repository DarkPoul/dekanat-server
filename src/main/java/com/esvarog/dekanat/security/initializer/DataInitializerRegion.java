package com.esvarog.dekanat.security.initializer;

import com.esvarog.dekanat.entity.Regions;
import com.esvarog.dekanat.service.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DataInitializerRegion {

    private final RegionService regionService;

    public void init() {
        List<String> regionTitle =
                List.of(
                        "АР Крим",
                        "Вінницька область",
                        "Волинська область",
                        "Дніпропетровська область",
                        "Донецька область",
                        "Житомирська область",
                        "Закарпатська область",
                        "Запорізька область",
                        "Івано-Франківська область",
                        "Київська область",
                        "Кіровоградська область",
                        "Луганська область",
                        "Львівська область",
                        "Миколаївська область",
                        "Одеська область",
                        "Полтавська область",
                        "Рівненська область",
                        "Сумська область",
                        "Тернопільська область",
                        "Харківська область",
                        "Херсонська область",
                        "Хмельницька область",
                        "Черкаська область",
                        "Чернівецька область",
                        "Чернігівська область"
                );
        if (!this.regionService.isRegionsExist()) {
            for (String s : regionTitle) {
                Regions regions = Regions.builder()
                        .regionName(s)
                        .build();
                this.regionService.create(regions);
            }
        }
        for (String s : regionTitle) {
            if (!this.regionService.isRegionsExistByName(s)) {
                Regions regions = Regions.builder()
                        .regionName(s)
                        .build();
                this.regionService.create(regions);
            }
        }
    }
}