package com.esvarog.dekanat.security.initializer;

import com.esvarog.dekanat.entity.GroupInformation;
import com.esvarog.dekanat.service.FacultiesService;
import com.esvarog.dekanat.service.GroupInformationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DataInitializerGroup {
    private final GroupInformationService groupInformationService;
    private final FacultiesService facultiesService;
    
    public void init(){
        List<String> groupInformation = List.of(
                "Автомобільний транспорт",
                "Автомобільні транспортні засоби",
                "Будівельні та дорожні машини і устаткування",
                "Експлуатація, випробування та сервіс машин",
                "Автомобільні двигуни",
                "Технічне обслуговування та діагностика автомобільних двигунів",
                "Гібридні та електричні автомобільні енергетичні установки",
                "Відновлення та підвищення зносостійкості деталей і конструкцій",
                "Матеріалознавство",
                "Метрологія та інформаційно-вимірювальна техніка",
                "Екологія",
                "Промисловий дизайн",
                "Екологічна інженерія автотранспортної діяльності",
                "Технології захисту навколишнього середовища на автозаправних комплексах та підприємствах будівельної індустрії",
                "Автомобільні дороги, вулиці та дороги населених пунктів",
                "Аеропорти, аеродромні конструкції та споруди",
                "Технології будівельних конструкцій, виробів і матеріалів",
                "Геодезія",
                "Оцінка землі та нерухомого майна",
                "Гідротехнічні споруди в транспортному будівництві",
                "Системний аналіз в транспортній інфраструктурі",
                "Підприємництво в сфері управління нерухомим майном",
                "Транспортні технології та управління на автомобільному транспорті",
                "Організація міжнародних перевезень",
                "Митна справа у транспортній галузі",
                "Інтелектуальні системи управління дорожнім рухом",
                "Транспортна логістика міста",
                "Транспортно-логістичні системи вантажних автомобільних перевезень",
                "Розумний транспорт і логістика для міста",
                "Інформаційні управляючі системи та технології",
                "Інформаційна безпека в комп'ютеризованих системах",
                "Комп'ютерні науки",
                "Інженерія програмного забезпечення",
                "Управління документаційними процесами та науково-технічний переклад",
                "Управління інформаційно-аналітичною діяльністю та комунікації з громадськістю",
                "Консолідована інформація",
                "Облік і оподаткування",
                "Цифрові технології обліку",
                "Фінанси, банківська справа та страхування",
                "Менеджмент організацій та адміністрування (транспортний менеджмент)",
                "Менеджмент зовнішньоекономічної діяльності",
                "Менеджмент природоохоронної діяльності",
                "Логістика",
                "Маркетинг послуг",
                "Туризм",
                "Міжнародний туризм",
                "Міжнародна економіка",
                "Економіка підприємства",
                "Управління персоналом та економіка праці",
                "Бізнес-економіка",
                "Економіко-правове забезпечення бізнесу",
                "Бізнес-аналітика",
                "Правознавство",
                "Професійна освіта (транспорт)",
                "Філологія (германські мови та літератури (переклад включно), перша - англійська)"
        );
        List<String> groupAbbreviation = List.of(
                "АА",
                "АБ",
                "ДМ",
                "СМ",
                "АД",
                "ДД",
                "ГЕУ",
                "ПМ",
                "МЗ",
                "МВ",
                "ЕО",
                "ДН",
                "ТЗ А",
                "ТЗ Б",
                "БД",
                "БА",
                "ТК",
                "ГЗ",
                "ОМ",
                "ГБ",
                "СА",
                "ПТ",
                "УТ",
                "МП",
                "МС",
                "УР",
                "ТЛМ",
                "ВП",
                "РТ",
                "КН",
                "ІБК",
                "КН",
                "ПР",
                "УДП",
                "УДК",
                "КІ",
                "ОА",
                "ОАЦ",
                "ФТ",
                "МО",
                "МЗД",
                "МПД",
                "ЛГ",
                "МР",
                "ТР",
                "ТРМ",
                "МЕ",
                "ЕП",
                "ПЕ",
                "БЕ",
                "ПЗ",
                "ЕА",
                "ТП",
                "ІП",
                "ФП"
        );
        List<String> facultyNumber = List.of(
                "1",
                "1",
                "1",
                "1",
                "1",
                "1",
                "1",
                "1",
                "1",
                "1",
                "1",
                "1",
                "1",
                "2",
                "2",
                "2",
                "2",
                "2",
                "2",
                "2",
                "2",
                "2",
                "5",
                "5",
                "5",
                "5",
                "5",
                "5",
                "5",
                "5",
                "5",
                "5",
                "5",
                "5",
                "5",
                "5",
                "3",
                "3",
                "3",
                "3",
                "3",
                "3",
                "3",
                "3",
                "3",
                "3",
                "4",
                "4",
                "4",
                "4",
                "4",
                "4",
                "4",
                "4",
                "4"
        );
        if (!this.groupInformationService.isGroupInformationExist()) {
            for (int i = 0; i < groupInformation.size(); i++) {
                GroupInformation groupInformation1 = GroupInformation.builder()
                        .groupName(groupInformation.get(i))
                        .groupAbbreviation(groupAbbreviation.get(i))
                        .faculty(this.facultiesService.getFacultyByNumber(Integer.valueOf(facultyNumber.get(i))))
                        .build();
                this.groupInformationService.create(groupInformation1);
            }
        }
        for (int i = 0; i < groupInformation.size(); i++) {
            if (!this.groupInformationService.isGroupInformationExistByName(groupInformation.get(i))) {
                GroupInformation groupInformation1 = GroupInformation.builder()
                        .groupName(groupInformation.get(i))
                        .groupAbbreviation(groupAbbreviation.get(i))
                        .faculty(this.facultiesService.getFacultyByNumber(Integer.valueOf(facultyNumber.get(i))))
                        .build();
                this.groupInformationService.create(groupInformation1);
            }
        }
    }
    
    
    }