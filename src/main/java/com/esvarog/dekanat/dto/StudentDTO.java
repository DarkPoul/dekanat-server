package com.esvarog.dekanat.dto;

import com.esvarog.dekanat.entity.OrderStudent;
import com.esvarog.dekanat.entity.PassData;
import com.esvarog.dekanat.entity.PriorEducation;
import lombok.Data;


@Data
public class StudentDTO {
    private Integer id;

    private String firstName;
    private String surName;
    private String lastName;

    private String firstNameEng;
    private String lastNameEng;

    private String applicantCardNumber;
    private String numberOfTheRecordBook;
    private String contractNumber;
    private String cardNumberOfAnIndividual;

    private String phoneNumber;
    private String email;

    private PassData passData;
    private PriorEducation priorEducation;
    private OrderStudent orderStudent;

    public StudentDTO() {
    }

    public StudentDTO
            (
                    Integer id, String firstName, String surName, String lastName, String firstNameEng,
                    String lastNameEng, String applicantCardNumber, String numberOfTheRecordBook, String contractNumber,
                    String cardNumberOfAnIndividual, String phoneNumber, String email, PassData passData,
                    PriorEducation priorEducation, OrderStudent orderStudent
            )
    {
        this.id = id;
        this.firstName = firstName;
        this.surName = surName;
        this.lastName = lastName;
        this.firstNameEng = firstNameEng;
        this.lastNameEng = lastNameEng;
        this.applicantCardNumber = applicantCardNumber;
        this.numberOfTheRecordBook = numberOfTheRecordBook;
        this.contractNumber = contractNumber;
        this.cardNumberOfAnIndividual = cardNumberOfAnIndividual;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passData = passData;
        this.priorEducation = priorEducation;
        this.orderStudent = orderStudent;
    }
}
