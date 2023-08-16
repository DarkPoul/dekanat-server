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
    private String firstNameEng;
    private String lastName;
    private String lastNameEng;
    private String surName;
    private Date dateOfBirth;
    private String address;

    @ManyToOne
    @JoinColumn(name = "idDistrict")
    private Districts districts;

    private String email;
    private String phoneNumber;
    private String applicantCardNumber;
    private String numberOfTheRecordBook;
    private String contractNumber;
    private String cardNumberOfAnIndividual;

    @OneToOne
    @JoinColumn(name = "IdPreviousEducation")
    private PreviousEducation previousEducation;

    @ManyToOne
    @JoinColumn(name = "IdGroup")
    private StudentGroup group;

//    private Passport passport;
//    private PreviousEducation previousEducation;
//    private DiplomaInfo diplomaInfo;
//    private List<Orders> orders;
}
