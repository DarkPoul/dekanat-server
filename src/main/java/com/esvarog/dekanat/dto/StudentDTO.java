package com.esvarog.dekanat.dto;

import lombok.Data;

import java.util.Date;

@Data
public class StudentDTO {
    private Long id;

    private String firstName;
    private String lastName;
    private String surName;
    private String dateOfBirth;

    private String firstNameEng;
    private String lastNameEng;

    private String address;
    private String email;
    private String phoneNumber;

    public StudentDTO() {
    }

    public StudentDTO(Long id,
                      String firstName, String lastName, String surName, String dateOfBirth,
                      String firstNameEng, String lastNameEng,
                      String address, String email, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.surName = surName;
        this.dateOfBirth = dateOfBirth;
        this.firstNameEng = firstNameEng;
        this.lastNameEng = lastNameEng;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
