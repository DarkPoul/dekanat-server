package com.esvarog.dekanat.security.initializer;

import com.esvarog.dekanat.entity.Faculties;
import com.esvarog.dekanat.service.FacultiesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DataInitializerFaculty {
    private final FacultiesService facultiesService;

    public void init() {
        List<String> titleFaculties =
                List.of(
                        "Автомеханічний факультет",
                        "Факультет транспортного будівництва",
                        "Факультет менеджменту, логістики та туризму",
                        "Факультет економіки та права",
                        "Факультет транспортних та інформаційних технологій",
                        "Факультет заочного, дистанційного навчання та підготовки іноземних громадян"
                );
        List<String> deanName =
                List.of(
                        "Олександр",
                        "Андрій",
                        "Олена",
                        "Руслана",
                        "Віктор",
                        "Сергій"
                );
        List<String> deanSurname =
                List.of(
                        "Добровольський",
                        "Бубела",
                        "Бакуліч",
                        "Ярова",
                        "Данчук",
                        "Ковбасенко"
                );
        List<String> abbreviation =
                List.of(
                        "АМФ",
                        "ФТБ",
                        "ФМЛТ",
                        "ФЕП",
                        "ФТІТ",
                        "ФЗДН"
                );

        if (!this.facultiesService.isFacultiesExist()) {
            for (int i = 0; i < titleFaculties.size(); i++) {
                Faculties faculties = Faculties.builder()
                        .facultyName(titleFaculties.get(i))
                        .deanName(deanName.get(i))
                        .deanSurname(deanSurname.get(i))
                        .abbreviation(abbreviation.get(i))
                        .build();
                this.facultiesService.create(faculties);
            }
        }
        for (int i = 0; i < titleFaculties.size(); i++) {
            if (!this.facultiesService.isFacultiesExistByName(titleFaculties.get(i))) {
                Faculties faculties = Faculties.builder()
                        .facultyName(titleFaculties.get(i))
                        .deanName(deanName.get(i))
                        .deanSurname(deanSurname.get(i))
                        .abbreviation(abbreviation.get(i))
                        .build();
                this.facultiesService.create(faculties);
            }
        }
    }
}