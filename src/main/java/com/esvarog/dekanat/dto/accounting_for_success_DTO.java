package com.esvarog.dekanat.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class accounting_for_success_DTO {
    String faculty;
    String speciality;
    String educational_program;
    String number_of_course;
    String group_abr;
    String number_of_order;
    String date;
    String month;
    String title_od_disc;
    String number_of_semester;
    String type_of_control;
    String hours;
    String first_teach;
    boolean first_exam_teach;
    String second_teach;
    boolean second_exam_teach;
    String dean_name;
}
