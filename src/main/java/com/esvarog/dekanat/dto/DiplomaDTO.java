package com.esvarog.dekanat.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class DiplomaDTO {
    private Date date;
    private String grade;
    private String title;
}
