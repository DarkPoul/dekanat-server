package com.esvarog.dekanat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String surName;
    private Date dateOfBirth;

    private String firstNameEng;
    private String lastNameEng;

    // private String group;

    // private String passport;

	// private String districts;
    private String address;
    private String email;
    private String phoneNumber;
 //    private String numberOfTheRecordBook;
 //    private String contractNumber;
 //    private String applicantCardNumber;
 //    private String cardNumberOfAnIndividual;
    
 //    private String previousEducation;
 //    private String diploma;
}
