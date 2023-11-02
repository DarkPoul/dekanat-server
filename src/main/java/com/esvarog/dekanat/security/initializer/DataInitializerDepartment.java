package com.esvarog.dekanat.security.initializer;

import com.esvarog.dekanat.entity.Departments;
import com.esvarog.dekanat.service.DepartmentsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DataInitializerDepartment {
    private final DepartmentsService departmentsService;

    public void init(){
        List<String> departmentTitle =
                List.of(
                        "Кафедра автомобілів",
                        "Кафедра виробництва, ремонту та матеріалознавства",
                        "Кафедра вищої математики",
                        "Кафедра двигунів і теплотехніки",
                        "Кафедра дорожньо-будівельних матеріалів та хімії",
                        "Кафедра екології та безпеки життєдіяльності",
                        "Кафедра економіки",
                        "Кафедра інженерії машин транспортного будівництва",
                        "Кафедра іноземних мов",
                        "Кафедра іноземної філоології та перекладу",
                        "Кафедра інформаційних систем і технологій",
                        "Кафедра інформаційно-аналітичної діяльності та інформаційної безпеки",
                        "Кафедра комп'ютерної, інженерної графіки та дизайну",
                        "Кафедра конституційного та адміністративного права",
                        "Кафедра менеджменту",
                        "Кафедра міжнародних перевезень та митного контролю",
                        "Кафедра мостів, тунелів та гідротехнічних споруд",
                        "Кафедра опору матеріалів та машинознавства",
                        "Кафедра проектування доріг, геодезії та землеустрою",
                        "Кафедра системного проектування об'єктів транспортної інфраструктури та геодезії",
                        "Кафедра теорії та історії держави і права",
                        "Кафедра теоретичної і прикладної механіки",
                        "Кафедра технологічної експлуатації автомобілів та автосервісу",
                        "Кафедра транспортних систем та безпеки дорожнього руху",
                        "Кафедра транспортних технологій",
                        "Кафедра транспортного будівництва та управління майном",
                        "Кафедра транспортного права та логістики",
                        "Кафедра туризму",
                        "Кафедра управління виробництвом і майном",
                        "Кафедра фізики",
                        "Кафедра фізичного виховання і спорту",
                        "Кафедра філософії і педагогіки",
                        "Кафедра фінансів, обліку і аудиту"
                );

        List<String> departmentAbbreviation =
                List.of(
                        "КА",
                        "КВРМ",
                        "КВМ",
                        "КДІТ",
                        "КДБМХ",
                        "КЕБЖ",
                        "КЕ",
                        "КІМТБ",
                        "КІМ",
                        "КІФП",
                        "КІСТ",
                        "КІАДІБ",
                        "ККІГД",
                        "ККАП",
                        "КМ",
                        "КМПМК",
                        "КМТГС",
                        "КОМ",
                        "КПДГЗ",
                        "КПДГЗ",
                        "КПДГЗ",
                        "КТІДП",
                        "КТІПІП",
                        "КТЕАА",
                        "КТСБДР",
                        "КТТ",
                        "КТБУМ",
                        "КТПЛ",
                        "КТ",
                        "КУВМ",
                        "КФ",
                        "КФВС",
                        "КФП",
                        "КФОА"
                );

        List<String> departmentTranslation =
                List.of(
                        "Department of Automobiles",
                        "Department of Production, Repair and Materials Science",
                        "Department of Higher Mathematics",
                        "Department of Engines and Heat Engineering",
                        "Department of Road-Building Materials and Chemistry",
                        "Department of Ecology and Life Safety",
                        "Department of Economics",
                        "Department of Engineering of Transport Construction Machinery",
                        "Department of Foreign Languages",
                        "Department of Foreign Philology and Translation",
                        "Department of Information Systems and Technologies",
                        "Department of Information and Analytical Activities and Information Security",
                        "Department of Computer, Engineering Graphics and Design",
                        "Department of Constitutional and Administrative Law",
                        "Department of Management",
                        "Department of International Transport and Customs Control",
                        "Department of Bridges, Tunnels and Hydraulic Structures",
                        "Department of Resistance of Materials and Machine Science",
                        "Department of Road Design, Geodesy and Land Management",
                        "Department of System Design of Transport Infrastructure Facilities and Geodesy",
                        "Department of Theory and History of State and Law",
                        "Department of Theoretical and Applied Mechanics",
                        "Department of Technological Operation of Vehicles and Car Service",
                        "Department of Transport Systems and Road Safety",
                        "Department of Transport Technologies",
                        "Department of Transport Construction and Property Management",
                        "Department of Transport Law and Logistics",
                        "Department of Tourism",
                        "Department of Production and Property Management",
                        "Department of Physics",
                        "Department of Physical Education and Sports",
                        "Department of Philosophy and Pedagogy",
                        "Department of Finance, Accounting and Audit"
                );

        if (!this.departmentsService.isExist()) {
            for (String s : departmentTitle) {
                Departments departments = Departments.builder()
                        .departmentName(s)
                        .departmentAbbreviation(departmentAbbreviation.get(departmentTitle.indexOf(s)))
                        .departmentTranslation(departmentTranslation.get(departmentTitle.indexOf(s)))
                        .build();
                this.departmentsService.create(departments);
            }
        }
        for (String s : departmentTitle) {
            if (!this.departmentsService.isExist(s)) {
                Departments departments = Departments.builder()
                        .departmentName(s)
                        .departmentAbbreviation(departmentAbbreviation.get(departmentTitle.indexOf(s)))
                        .departmentTranslation(departmentTranslation.get(departmentTitle.indexOf(s)))
                        .build();
                this.departmentsService.create(departments);
            }
        }
    }



}