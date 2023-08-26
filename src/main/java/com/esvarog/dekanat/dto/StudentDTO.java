package com.esvarog.dekanat.dto;

import com.esvarog.dekanat.entity.Districts;
import com.esvarog.dekanat.entity.Passport;
import com.esvarog.dekanat.entity.PreviousEducation;
import com.esvarog.dekanat.entity.StudentGroup;
import lombok.Data;

import java.sql.Date;

@Data
public class StudentDTO {
    private String firstName;
    private String firstName_eng;
    private String lastName;
    private String lastName_eng;
    private String surName;
    private Date dateOfBirth;
    private String address;
    private Districts district;
    private String email;
    private String phoneNumber;
    private String applicant_card_number;
    private String number_of_the_record_book;
    private String contract_number;
    private String card_number_of_an_individual;
    private PreviousEducation previousEducation;
    private StudentGroup group;
    private Passport passport;
//
//    private DiplomaInfo diplomaInfo;
//    private List<Orders> orders;
}
